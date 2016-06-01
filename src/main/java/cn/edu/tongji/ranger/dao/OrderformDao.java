package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Orderform;

import java.util.List;

/**
 * Created by 马二爷 on 2016/4/26.
 */
public interface OrderformDao {
    public Orderform findByOrderId(long orderId);
    public List<Orderform> findByBuyerId(long buyerId);
    public List<Orderform> findByTripSetOffId(long setoffId);

    public void createOrder(Orderform orderform);
    public boolean updateOrder(Orderform orderform);
    public void deleteOrderById(long id);

}
