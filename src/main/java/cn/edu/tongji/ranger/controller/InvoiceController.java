package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdechang on 2016/5/12.
 */
@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {
    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    @ResponseBody
    public List<Invoice> productsList(){
        List<Invoice> list = new ArrayList<Invoice>();
        list.add(new Invoice("11111","这是发票信息","2016-6-1","2051"));
        list.add(new Invoice("11122","这是发票信息","2016-6-1","2051"));
        list.add(new Invoice("11133","这是发票信息","2016-6-1","2051"));
        return list;
    }
}
