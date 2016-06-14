package cn.edu.tongji.ranger.controller;


import cn.edu.tongji.ranger.model.Angency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/view")
public class AccountController {

/*
    @Autowired

    private AccountService accountService;
*/


    @RequestMapping("/test")
    public void test(){
        Angency angency = new Angency(1,"旅游券","认证","简介","125125125125","tongji@126.com",
                "上海市同济大学曹安公路","D:\\pictruce\\ico.png",12563,"欢迎来到八爪鱼旅游","thisismypasssword");
//        accountService.create(angency);
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
    public Map<String, Object> re(@RequestParam(value = "name")String name, @RequestParam(value = "password")String pass) {
        System.out.println(name + " " + pass);
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("result","这是结果");
        return m;
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
////    public Map<String, Object> register(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
//    public Map<String, Object> register(@RequestBody Account account) {
//        System.out.println("===================="+ "进行注册" +"==================");
//        Map<String, Object> map = new HashMap<String, Object>();
//        //Account account = new Account();
//        //account.setName(name);
//        //account.setPassword(password);
//        accountService.create(account);
//        map.put("result", "SUCCESS");
//        return map;
//    }
//
    /*private class Account {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

    @RequestMapping(value = "/ceshirb", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Account account) {
        String name = account.getName();
        String password = account.getPassword();
        return String.valueOf(account);
    }*/

}
