package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/account")
public class AccountController {

/*
    @Autowired
    private AccountService accountService;
*/

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
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> login(@RequestBody Account account) {
//        System.out.println("===================="+ "进行登录" +"==================");
//        String name = account.getName();
//        String password = account.getPassword();
//        List<Account> accounts = accountService.find(name);
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (accounts.size() != 0) {
//            System.out.println("..==========db pass: " + accounts.get(0).getPassword() + ";;; front pass: " + password);
//            if (accounts.get(0).getPassword().equals(password)) {
//                map.put("result", "SUCCESS");
//                return map;
//            }
//        }
//        map.put("result", "FAIL");
//        return map;
//    }

}
