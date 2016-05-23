package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Notification;
import cn.edu.tongji.ranger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/unread/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Notification> listUnread(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        return notificationService.findUnreadNotificationsByAngencyId(id);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Notification> listRead(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        return notificationService.findReadNotificationsByAngencyId(id);
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Notification> listAll(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        return notificationService.findAllNotificationsByAngencyId(id);
    }

    @RequestMapping(value = "/setviewed/{nid}", method = RequestMethod.GET)
    @ResponseBody
    public String setViewed(@PathVariable("nid") Long nid) {
        String s =  String.valueOf(notificationService.setViewed(nid));
        System.out.println(s);
        return s;
    }

}
