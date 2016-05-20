package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Notification;
import cn.edu.tongji.ranger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/unread", method = RequestMethod.GET)
    @ResponseBody
    public List<Notification> listUnread() {

        System.out.println("调用notification controller");

        List<Notification> ns = new ArrayList<Notification>();
        for (int i = 0; i < 5; i ++) {
            Notification n = new Notification();
            n.setId(i);
            n.setContent("第" + i + "条");
            n.setGenerateTime(new Timestamp(System.currentTimeMillis()));
            n.setOrderformId(i*10);
            n.setIsViewed((byte) 0);
            n.setReceiverId(i*100);
            ns.add(n);
        }

        return ns;
//        return notificationService.findUnreadNotifications((long) 5);
    }

}
