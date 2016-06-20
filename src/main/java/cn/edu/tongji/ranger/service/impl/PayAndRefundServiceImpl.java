package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.beans.PayDetails;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.OrderDetail;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.model.TransactionRecord;
import cn.edu.tongji.ranger.service.AngencyService;
import cn.edu.tongji.ranger.service.OrderService;
import cn.edu.tongji.ranger.service.PayAndRefundService;
import cn.edu.tongji.ranger.service.TransactionRecordService;
import cn.edu.tongji.ranger.utils.OrderStateEnum;
import cn.edu.tongji.ranger.utils.ReturnCodeEnum;
import cn.edu.tongji.ranger.utils.ReturnStatusEnum;
import cn.edu.tongji.ranger.utils.ReturnWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiaoShanhe on 2016/6/7.
 */
@Service("PayAndRefundService")
@Transactional
public class PayAndRefundServiceImpl implements PayAndRefundService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AngencyService angencyService;

    @Autowired
    private TransactionRecordService transactionRecordService;

    private int payDelayDays = 7;

    public int getPayDelayDays() {
        return payDelayDays;
    }

    public void setPayDelayDays(int payDelayDays) {
        this.payDelayDays = payDelayDays;
    }

    public ReturnWrapper<String> payToSystem(PayDetails payDetails) {
        ReturnWrapper<String> returnWrapper = null;

        OrderDetail orderDetail = orderService.getOrderDetail(payDetails.getOrderId());
        Orderform orderform = orderDetail.getOrderform();
        long buyerId = orderform.getBuyerId();
        Angency angency = angencyService.findById(buyerId);
        double balance = angency.getBalance();
        String payPassWord = angency.getPassword();

        //检查状态
        if (orderform.getState() != OrderStateEnum.待付款.getValue()) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.DUPLICATED_OPERATION);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("order form does not need pay");
            return returnWrapper;
        }

        //检查密码
        if (! payPassWord.equals(payDetails.getPayPass())) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.CURRENT_PASSWORD_WRONG);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("wrong pay password");
            return returnWrapper;
        }

        //检查余额
        if (balance < payDetails.getAmount()) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.BALANCE_NOT_ENOUGH);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("Insufficient balance");
            return returnWrapper;
        }

        //更新angency余额(angency余额 减少)
        angency.setBalance(balance - payDetails.getAmount());
        angencyService.update(angency);

        //转账到系统中间账户(system余额 增加)
        Angency systemAngency = angencyService.getSystemAccoount();
        systemAngency.setBalance(systemAngency.getBalance() + payDetails.getAmount());

        //更新订单状态
        orderform.setState(OrderStateEnum.已付款.getValue());
        orderService.updateOrderForm(orderform);

        //查询供应商id
        Long supplierId = orderService.findSupplierId(payDetails.getOrderId());

        //插入交易记录，设置状态为 BUYER_PAY_TO_AGENT
        TransactionRecord record = new TransactionRecord();
        record.setFromId(buyerId);
        record.setToId(supplierId);
        record.setTime(new Timestamp(new Date().getTime()));
        record.setOrderformId(payDetails.getOrderId());
        record.setStatus(TransactionRecordServiceImpl.BUYER_PAY_TO_AGENT);
        transactionRecordService.create(record);

        payDelay(payDetails.getOrderId());

        returnWrapper = new ReturnWrapper<>();
        returnWrapper.setStatus(ReturnStatusEnum.SUCCEED);
        returnWrapper.setCode(ReturnCodeEnum.No_Error);
        returnWrapper.setData("success");
        returnWrapper.setMessage("pay successfully");
        return returnWrapper;
    }

    public void payDelay(Long orderFormId) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            TransactionRecord record = transactionRecordService.findByOrderFormId(orderFormId);
            if (record.getStatus() != TransactionRecordServiceImpl.AGENT_PAY_TO_SELLER) {
                payToSeller(orderFormId);
            } else {
                service.shutdown();
            }
        }, payDelayDays, payDelayDays, TimeUnit.DAYS);
    }

    public ReturnWrapper<String> payToSeller(Long orderFormId) {
        ReturnWrapper<String> returnWrapper;
        TransactionRecord record = transactionRecordService.findByOrderFormId(orderFormId);
        if (record == null) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.RESOURCE_NOT_EXIST);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("order has no payment record");
            return returnWrapper;
        }
        //先检查是否已经是 AGENT_PAY_TO_SELLER 状态
        if (record.getStatus() == TransactionRecordServiceImpl.AGENT_PAY_TO_SELLER) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.DUPLICATED_OPERATION);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("fund has been transferred to seller");
            return returnWrapper;
        }

        double totalPrice = orderService.getOrderDetail(orderFormId).getPrice().getTotal();
        Long supplierId = record.getToId();
        //从系统中间账户转出
        Angency system = angencyService.getSystemAccoount();
        system.setBalance(system.getBalance() - totalPrice);
        //转入到卖家账户
        Angency seller = angencyService.findById(supplierId);
        seller.setBalance(seller.getBalance() + totalPrice);
        //更新交易记录状态为 AGENT_PAY_TO_SELLER
        if (transactionRecordService.changeRecordStatus(record.getId(), "AGENT_PAY_TO_SELLER")) {
            //更新成功
            //更改订单状态
            Orderform orderform = orderService.getOrderDetail(orderFormId).getOrderform();
            orderform.setState(OrderStateEnum.已完成.getValue());
            orderService.updateOrderForm(orderform);
            //返回成功
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.SUCCEED);
            returnWrapper.setCode(ReturnCodeEnum.No_Error);
            returnWrapper.setData("success");
            returnWrapper.setMessage("transfer to seller successfully");
            return returnWrapper;
        } else {
            //更新失败
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.Unknown_Error);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("fail to transfer to seller");
            return returnWrapper;
        }
    }
}
