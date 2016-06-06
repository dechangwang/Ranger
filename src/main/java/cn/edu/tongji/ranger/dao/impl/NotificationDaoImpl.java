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

    public int maxNumberPerPage = 5;

    @Autowired
    private SessionFactory sessionFactory;

    public Notification findById(Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("id", id));
        return (Notification) criteria.list().get(0);
    }

    public List findUnreadNotificationsByAngencyId(Long receiver_id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .add(Restrictions.eq("isViewed", (byte) 0))
                .addOrder(Order.desc("generateTime"));
        return (List<Notification>) criteria.list();
    }

    public List findUnreadNotificationsByAngencyId(Long receiver_id, int page) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .add(Restrictions.eq("isViewed", (byte) 0))
                .addOrder(Order.desc("generateTime"));
        int start = (page - 1) * maxNumberPerPage;
        criteria.setFirstResult(start);
        criteria.setMaxResults(maxNumberPerPage);
        return (List<Notification>) criteria.list();
    }

    public List findReadNotificationsByAngencyId(Long receiver_id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .add(Restrictions.eq("isViewed", (byte) 1))
                .addOrder(Order.desc("generateTime"));
        return (List<Notification>) criteria.list();
    }

    public List findReadNotificationsByAngencyId(Long receiver_id, int page) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .add(Restrictions.eq("isViewed", (byte) 1))
                .addOrder(Order.desc("generateTime"));
        int start = (page - 1) * maxNumberPerPage;
        criteria.setFirstResult(start);
        criteria.setMaxResults(maxNumberPerPage);
        return (List<Notification>) criteria.list();
    }

    public List findAllNotificationsByAngencyId(Long receiver_id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .addOrder(Order.desc("generateTime"));
        return (List<Notification>) criteria.list();
    }

    public List<Notification> findAllNotificationsByAngencyId(Long receiver_id, int page) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Notification.class)
                .add(Restrictions.eq("receiverId", receiver_id))
                .addOrder(Order.desc("generateTime"));
        int start = (page - 1) * maxNumberPerPage;
        criteria.setFirstResult(start);
        criteria.setMaxResults(maxNumberPerPage);
        return (List<Notification>) criteria.list();
    }

    public Integer getPageNumber(Long aid, String type) {
        int count = 0;
        switch (type) {
            case "unread":
                count = findUnreadNotificationsByAngencyId(aid).size();
                break;
            case "read":
                count = findReadNotificationsByAngencyId(aid).size();
                break;
            default:
                count = findAllNotificationsByAngencyId(aid).size();
        }
        if (count % maxNumberPerPage == 0)
            return count / maxNumberPerPage;
        else
            return count / maxNumberPerPage + 1;
    }


}
