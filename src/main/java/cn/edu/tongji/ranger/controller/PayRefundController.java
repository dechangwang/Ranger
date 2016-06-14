package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.beans.PayDetails;
import cn.edu.tongji.ranger.service.PayAndRefundService;
import cn.edu.tongji.ranger.utils.ReturnWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/trade")
public class PayRefundController {

    @Autowired
    private PayAndRefundService payAndRefundService;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public ReturnWrapper<String> pay(@RequestBody PayDetails payDetails) {
        return payAndRefundService.pay(payDetails);
    }

}
