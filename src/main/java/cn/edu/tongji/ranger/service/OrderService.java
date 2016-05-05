package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.OrderListItem;
import cn.edu.tongji.ranger.model.Orderform;

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
}
