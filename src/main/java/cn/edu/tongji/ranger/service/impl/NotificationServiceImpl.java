package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.NotificationDao;
import cn.edu.tongji.ranger.model.Notification;
import cn.edu.tongji.ranger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

@Service("NotificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    public Long create(Notification notification) {
        return notificationDao.create(notification);
    }

    public void update(Notification notification) {
        notificationDao.update(notification);

    }

    public void remove(Notification notification) {
        notificationDao.remove(notification);
    }

    public Notification findById(Long id) {
        return notificationDao.findById(id);
    }

    public List<Notification> findAllNotificationsByAngencyId(Long receiver_id, int page) {
        return (List<Notification>) notificationDao.findAllNotificationsByAngencyId(receiver_id, page);
    }

    public List<Notification> findUnreadNotificationsByAngencyId(Long receiver_id, int page) {
        return (List<Notification>) notificationDao.findUnreadNotificationsByAngencyId(receiver_id, page);
        /*List<Notification> notifications = findAllNotificationsByAngencyId(receiver_id);
        Iterator<Notification> iterator = notifications.iterator();
        while (iterator.hasNext()) {
            Notification n = iterator.next();
            if (n.getIsViewed() != (byte) 0) {
                iterator.remove();
            }
        }
        return notifications;*/
    }

    public List<Notification> findReadNotificationsByAngencyId(Long receiver_id, int page) {
        return (List<Notification>) notificationDao.findReadNotificationsByAngencyId(receiver_id, page);
        /*List<Notification> notifications = findAllNotificationsByAngencyId(receiver_id);
        Iterator<Notification> iterator = notifications.iterator();
        while (iterator.hasNext()) {
            Notification n = iterator.next();
            if (n.getIsViewed() != (byte) 1) {
                iterator.remove();
            }
        }
        return notifications;*/
    }

    public boolean setViewed(Long notificationId) {
        try {
            Notification notification = notificationDao.findById(notificationId);
            notification.setIsViewed((byte) 1);
            notificationDao.update(notification);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Integer getPageNumber(Long aid, String type) {
        return notificationDao.getPageNumber(aid, type);
    }

}
