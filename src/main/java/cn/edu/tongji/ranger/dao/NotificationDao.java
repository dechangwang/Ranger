package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Notification;

import java.util.List;

public interface NotificationDao extends BaseDao<Notification> {

    public Notification findById(Long id);

    public List findAllNotificationsByAngencyId(Long id);

}
