package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.OrderformDao;
import cn.edu.tongji.ranger.model.Orderform;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 马二爷 on 2016/4/26.
 */
@Repository("OrderformDao")
public class OrderformDaoImpl implements OrderformDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Orderform findByOrderId(long orderId) {
            Session session=sessionFactory.getCurrentSession();

            /*String hql="FROM Orderform o WHERE o.id=:oid";
            Query query=session.createQuery(hql);
            query.setParameter("oid",orderId);*/

            return (Orderform)session.get(Orderform.class,orderId);
    }

    public List<Orderform> findByBuyerId(long buyerId) {
        Session session=sessionFactory.getCurrentSession();
        String hql="FROM Orderform o WHERE o.buyerId=:bid";
        Query query=session.createQuery(hql);
        query.setParameter("bid",buyerId);
        return (List<Orderform>)query.list();
    }

    public List<Orderform> findByTripSetOffId(long setoffId) {
       Session session=sessionFactory.getCurrentSession();
        String hql="From Orderform o WHERE o.tripSetoffId=:setoffid";
        Query query=session.createQuery(hql);
        query.setParameter("setoffid",setoffId);
        return (List<Orderform>)query.list();
    }

    public void createOrder(Orderform orderform) {
        Session session=sessionFactory.getCurrentSession();
        session.save(orderform);

    }

    public boolean updateOrder(Orderform orderform) {
        Session session=sessionFactory.getCurrentSession();
        try {
            session.update(orderform);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteOrderById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Orderform orderform=(Orderform)session.load(Orderform.class,id);
        if(orderform!=null)
            session.delete(orderform);

    }
}
