package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.OrderDetail;
import cn.edu.tongji.ranger.model.OrderListItem;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.model.OrderformTourist;

import java.util.List;

/**
 * Created by 马二爷 on 2016/4/28.
 */

public interface OrderService {
    public List<OrderListItem> getAllListOrder(long buyerid);
    public List<OrderListItem> getToBeACK(long buyerid);
    public List<OrderListItem> getToPay(long buyreid);
    public List<OrderListItem> getHasPaidDeposit(long buyerid);
    public List<OrderListItem> getHasPaidAll(long buyerid);
    public List<OrderListItem> getHasFinished(long buyerid);
    public List<OrderListItem> getHasCanceled(long buyerid);
    public List<OrderListItem> getHasEvaluate(long buyerid);
    public OrderDetail getOrderDetail(long orderId);
    public boolean addTourist(OrderformTourist tourist);
    public boolean changeOrderState(long orderid);
    public boolean comment(long orderid,String content);

    public Long findSupplierId(Long orderId);
    public boolean updateOrderForm(Orderform orderform);

}
