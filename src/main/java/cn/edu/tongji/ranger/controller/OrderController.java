package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.OrderListItem;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/listAll/{bid}",method = RequestMethod.GET)
    public ResponseEntity<List<OrderListItem>> listAll(@PathVariable("bid") long bid)
    {
        //String buyerid=principal.getName();
        System.out.println("in backend controller");
        List<OrderListItem> orders=orderService.getAllListOrder(bid);
        if(orders.isEmpty())
        {
            return new ResponseEntity<List<OrderListItem>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<OrderListItem>>(orders, HttpStatus.OK);
    }

   /* @RequestMapping(value="/list/ToBeAck",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listToBeAck(Principal principal)
    {
        return orderService.getToBeACK();
    }
    @RequestMapping(value="/list/ToPay",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listToPay(Principal principal)
    {
        return orderService.getToPay();
    }

    @RequestMapping(value="/list/HasPaidDeposit",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasPaidDeposit(Principal principal)
    {
        return orderService.getHasPaidDeposit();
    }

    @RequestMapping(value="/list/HasPaidAll",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasPaidAll(Principal principal)
    {
        return orderService.getHasPaidAll();
    }

    @RequestMapping(value="/list/HasFinished",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasFinished(Principal principal)
    {
        return orderService.getHasFinished();
    }

    @RequestMapping(value="/list/HasCanceled",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderListItem> listHasCanceled(Principal principal)
    {
        return orderService.getHasCanceled();
    }

    @RequestMapping(value = "/detail/{orderid}",method =RequestMethod.GET)
    @ResponseBody
    public Orderform orderDetail(@PathVariable("orderid")long id)
    {

    }*/


}
