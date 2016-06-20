package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.OrderListItem;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.utils.IdAndStrWrapper;

import java.util.List;

/**
 * Created by Dai on 6/19/16.
 */
public interface SupplierOrderformService {
    List<OrderListItem> getOrderformsBySupplierId(Long supplierId);
    int uploadConfirm(IdAndStrWrapper idAndStrWrapper);
    int uploadReConfirm(IdAndStrWrapper idAndStrWrapper);
}
