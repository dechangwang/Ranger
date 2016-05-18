package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.NotificationDao;
import cn.edu.tongji.ranger.model.Notification;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NotificationDao")
public class NotificationDaoImpl extends BaseDaoImpl<Notification> implements NotificationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Notification findById(Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("id", id));
        return (Notification) criteria.list().get(0);
    }

    public List<Notification> findAllNotificationsByAngencyId(Long receiver_id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiver_id", receiver_id)).addOrder(Order.desc("generate_time"));
        return (List<Notification>) criteria.list();
    }

}
