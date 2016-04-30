package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by 马二爷 on 2016/4/28.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/listAll")
    public String listAll(Principal principal)
    {

        return "order/list";
    }


}
