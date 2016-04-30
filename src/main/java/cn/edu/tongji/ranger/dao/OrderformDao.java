package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Orderform;

import java.util.List;

/**
 * Created by 马二爷 on 2016/4/26.
 */
public interface OrderformDao {
    public Orderform findByOrderId(int orderId);
    public List<Orderform> findByBuyerId(int buyerId);
    public List<Orderform> findByTripSetOffId(int setoffId);

    public void createOrder(Orderform orderform);
    public void updateOrder(Orderform orderform);
    public void deleteOrderById(long id);
}
