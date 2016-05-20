package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.OrderformTrackDao;
import cn.edu.tongji.ranger.model.OrderformTrack;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 马二爷 on 2016/5/10.
 */
@Repository("OrderformTrackDao")
public class OrderformTrackDaoImpl implements OrderformTrackDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<OrderformTrack> getOrderTracksByOrderId(long orderid) {
        Session session=sessionFactory.getCurrentSession();
        String hql="FROM OrderformTrack ot WHERE ot.orderformId=:oid";
        Query query=session.createQuery(hql);
        query.setParameter("oid",orderid);
        return (List<OrderformTrack>)query.list();
    }
}
