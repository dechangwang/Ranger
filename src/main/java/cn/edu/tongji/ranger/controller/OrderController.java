package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.OrderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 马二爷 on 2016/4/28.
 */

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/submittourist/{oid}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> submitTourist(@PathVariable("oid") long oid,@RequestBody TouristForm tourist)
    {
        Map<String,String> result=new HashMap<String, String>();
        OrderformTourist tourist1=new OrderformTourist(tourist);
        tourist1.setOrderformId(oid);
        //插入数据库
        if(orderService.addTourist(tourist1))
            result.put("result","success");
        else
            result.put("result","fail");
        return result;

    }


    @RequestMapping(value="/detail/{oid}",method=RequestMethod.GET)
    @ResponseBody
    public OrderDetail viewDetail(@PathVariable("oid")long orderId)
    {
        OrderDetail detail=orderService.getOrderDetail(orderId);
        return detail;
    }

    @RequestMapping(value = "/listAll/{bid}",method = RequestMethod.GET)
    public ResponseEntity<List<OrderListItem>> listAll(@PathVariable("bid") long bid)
    {
        List<OrderListItem> orders=orderService.getAllListOrder(bid);
        if(orders.isEmpty())
        {
            return new ResponseEntity<List<OrderListItem>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<OrderListItem>>(orders, HttpStatus.OK);
    }

    @RequestMapping(value="/listToBeAck/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listToBeAck(@PathVariable("bid") long bid)
    {
        return orderService.getToBeACK(bid);
    }
    @RequestMapping(value="/listToPay/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listToPay(@PathVariable("bid") long bid)
    {
        return orderService.getToPay(bid);
    }

    @RequestMapping(value="/listHasPaidDeposit/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasPaidDeposit(@PathVariable("bid") long bid)
    {
        return orderService.getHasPaidDeposit(bid);
    }

    @RequestMapping(value="/listHasPaidAll/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasPaidAll(@PathVariable("bid") long bid)
    {
        return orderService.getHasPaidAll(bid);
    }

    @RequestMapping(value="/listHasFinished/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasFinished(@PathVariable("bid") long bid)
    {
        return orderService.getHasFinished(bid);
    }

    @RequestMapping(value="/listHasEvaluated/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasEvaluated(@PathVariable("bid") long bid)
    {
        return orderService.getHasEvaluate(bid);
    }

    @RequestMapping(value="/listHasCanceled/{bid}",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasCanceled(@PathVariable("bid") long bid)
    {
        return orderService.getHasCanceled(bid);
    }


}
