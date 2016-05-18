package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdechang on 2016/5/16.
 */

@Controller
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @RequestMapping(value = "/money",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> recharge(@RequestParam(value = "card_number")String card_number){
        Map<String,String> map = new HashMap<String, String>();
        boolean rechareRes = rechargeService.findByNumber(card_number);
        System.out.println(card_number+rechareRes);
        if (rechareRes){
            map.put("res","success");
        }else{
            map.put("res","no");
        }
        return map;
    }
}
