package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.NotificationDao;
import cn.edu.tongji.ranger.model.Notification;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NotificationDao")
public class NotificationDaoImpl /*implements NotificationDao*/ {

    @Autowired
    private SessionFactory sessionFactory;

    /*public List<Notification> findAllNotifications() {
        return null;
    }

    public long create(Notification notification) {
        sessionFactory.getCurrentSession().persist(notification);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .setProjection(Projections.projectionList().add(Projections.max("id")));
        return (Long) criteria.list().get(0);
    }

    public void update(Notification notification) {

    }

    public void remove(Notification notification) {

    }

    public Notification findById(long id) {
        return null;
    }*/
}
