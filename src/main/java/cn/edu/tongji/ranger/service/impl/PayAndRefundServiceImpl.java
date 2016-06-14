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

    public ReturnWrapper<String> pay(PayDetails payDetails) {
        ReturnWrapper<String> returnWrapper = null;

        OrderDetail orderDetail = orderService.getOrderDetail(payDetails.getOrderId());
        Orderform orderform = orderDetail.getOrderform();
        long buyerId = orderform.getBuyerId();
        Angency angency = angencyService.findById(buyerId);
        double balance = angency.getBalance();
        String payPassWord = angency.getPassword();

        if (! payPassWord.equals(payDetails.getPayPass())) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.CURRENT_PASSWORD_WRONG);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("wrong pay password");
            return returnWrapper;
        }

        if (balance < payDetails.getAmount()) {
            returnWrapper = new ReturnWrapper<>();
            returnWrapper.setStatus(ReturnStatusEnum.FAILED);
            returnWrapper.setCode(ReturnCodeEnum.BALANCE_NOT_ENOUGH);
            returnWrapper.setData("fail");
            returnWrapper.setMessage("Insufficient balance");
            return returnWrapper;
        }

        //更新angency余额
        angency.setBalance(balance - payDetails.getAmount());
        angencyService.update(angency);

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

        returnWrapper = new ReturnWrapper<>();
        returnWrapper.setStatus(ReturnStatusEnum.SUCCEED);
        returnWrapper.setCode(ReturnCodeEnum.No_Error);
        returnWrapper.setData("success");
        returnWrapper.setMessage("pay successfully");
        return returnWrapper;
    }
}
