package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Notification;

import java.util.List;

public interface NotificationDao extends BaseDao<Notification> {

    public Notification findById(Long id);

    public List findUnreadNotificationsByAngencyId(Long id);

    public List findUnreadNotificationsByAngencyId(Long id, int page);

    public List findReadNotificationsByAngencyId(Long id);

    public List findReadNotificationsByAngencyId(Long id, int page);

    public List findAllNotificationsByAngencyId(Long id);

    public List findAllNotificationsByAngencyId(Long id, int page);

    public Integer getPageNumber(Long aid, String type);

}
