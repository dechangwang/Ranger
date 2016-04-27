package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Guide;
import cn.edu.tongji.ranger.service.AccountService;
import cn.edu.tongji.ranger.service.GuideService;
import cn.edu.tongji.ranger.utils.ReturnWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/view")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
//    public Map<String, Object> register(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
    public Map<String, Object> register(@RequestBody Account account) {
        System.out.println("===================="+ "进行注册" +"==================");
        Map<String, Object> map = new HashMap<String, Object>();
        //Account account = new Account();
        //account.setName(name);
        //account.setPassword(password);
       // accountService.create(account);

        map.put("result", "SUCCESS");
        return map;
    }

    @RequestMapping("/test")
    public void test(){
        Angency angency = new Angency(1,"旅游券","认证","简介","125125125125","tongji@126.com",
                "上海市同济大学曹安公路","D:\\pictruce\\ico.png",12563,"欢迎来到八爪鱼旅游","thisismypasssword");
        accountService.create(angency);
    }

    @RequestMapping("/testguide")
    public String testGuideAdd(){
//        Angency angency = new Angency(1,"携程","认证","简介","125125125125","tongji@126.com",
//                "上海市同济大学曹安公路","D:\\pictruce\\ico.png",12563,"欢迎来到八爪鱼旅游");
       // Guide guide = new Guide("Andy",1,true,"12345678","tongji@162.com","上海市杨浦区同济大学" );
        //accountService.create(angency);
       // guide.setAngency(angency);
       // guideService.create(guide);

        return "home";
    }

    @RequestMapping("/register")
    public String testRegister(){
        return "angency_register";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody Account account) {
        System.out.println("===================="+ "进行登录" +"==================");
        String name = account.getName();
        String password = account.getPassword();
        List<Account> accounts = accountService.find(name);
        Map<String, Object> map = new HashMap<String, Object>();
        if (accounts.size() != 0) {
            System.out.println("..==========db pass: " + accounts.get(0).getPassword() + ";;; front pass: " + password);
            if (accounts.get(0).getPassword().equals(password)) {
                map.put("result", "SUCCESS");
                return map;
            }
        }
        map.put("result", "FAIL");
        return map;
    }

}
