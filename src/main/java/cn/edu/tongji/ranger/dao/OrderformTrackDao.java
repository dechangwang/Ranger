package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.OrderformTrack;

import java.util.List;

/**
 * Created by 马二爷 on 2016/5/10.
 */
public interface OrderformTrackDao {
    List<OrderformTrack> getOrderTracksByOrderId(long orderid);
}
