package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Notification;

import java.util.List;

public interface NotificationService extends BaseService<Notification> {

    public Notification findById(Long id);

    public List<Notification> findAllNotificationsByAngencyId(Long receiver_id);

    public List<Notification> findUnreadNotificationsByAngencyId(Long receiver_id);

    public List<Notification> findReadNotificationsByAngencyId(Long receiver_id);

    public boolean setViewed(Long notificationId);

}
