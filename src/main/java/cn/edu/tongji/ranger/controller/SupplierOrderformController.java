package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.OrderListItem;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.SupplierOrderformService;
import cn.edu.tongji.ranger.utils.IdAndStrWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Dai on 6/19/16.
 */
@Controller
@RequestMapping("/api/supplierorderform")
public class SupplierOrderformController {
    @Autowired
    private SupplierOrderformService supplierOrderformService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<OrderListItem> getOrderformsBySupplierId(@RequestBody long supplierId){
        return supplierOrderformService.getOrderformsBySupplierId(supplierId);
    }

    @RequestMapping(value = "/uploadconfirm", method = RequestMethod.POST)
    @ResponseBody
    public int uploadConfirm(@RequestBody IdAndStrWrapper idAndStrWrapper){
        return supplierOrderformService.uploadConfirm(idAndStrWrapper);
    }

    @RequestMapping(value = "/uploadreconfirm", method = RequestMethod.POST)
    @ResponseBody
    public int uploadReConfirm(@RequestBody IdAndStrWrapper idAndStrWrapper){
        return supplierOrderformService.uploadReConfirm(idAndStrWrapper);
    }
}
