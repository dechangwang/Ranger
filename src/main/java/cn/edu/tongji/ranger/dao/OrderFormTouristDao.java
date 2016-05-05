package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.OrderformTourist;

import java.util.List;

/**
 * Created by 马二爷 on 2016/5/2.
 */
public interface OrderFormTouristDao {
   public List<OrderformTourist> getOrderFormTouristByOrderId(long orderId);

}
