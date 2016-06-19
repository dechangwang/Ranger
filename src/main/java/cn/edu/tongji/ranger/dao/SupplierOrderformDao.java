package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Orderform;

import java.util.List;

/**
 * Created by Dai on 6/19/16.
 */
public interface SupplierOrderformDao {
    List<Long> getOrderformBySupplierId(Long supplierId);
}
