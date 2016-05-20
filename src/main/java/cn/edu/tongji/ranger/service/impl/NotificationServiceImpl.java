package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.NotificationDao;
import cn.edu.tongji.ranger.model.Notification;
import cn.edu.tongji.ranger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Notification> findAllNotificationsByAngencyId(Long receiver_id) {
        return (List<Notification>) notificationDao.findAllNotificationsByAngencyId(receiver_id);
    }

    public List<Notification> findUnreadNotifications(Long receiver_id) {
        List<Notification> notifications = findAllNotificationsByAngencyId(receiver_id);
        for (Notification notification : notifications) {
            if (notification.getIsViewed() != (byte) 0) {
                notifications.remove(notification);
            }
        }
        return notifications;
    }

    public List<Notification> findReadNotifications(Long receiver_id) {
        List<Notification> notifications = findAllNotificationsByAngencyId(receiver_id);
        for (Notification notification : notifications) {
            if (notification.getIsViewed() != (byte) 1) {
                notifications.remove(notification);
            }
        }
        return notifications;
    }

}
