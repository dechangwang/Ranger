package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.service.AccountService;
import cn.edu.tongji.ranger.utils.ReturnWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ReturnWrapper<Account> register(@RequestBody Account account) {
        return accountService.save(account);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam(value = "accountId") Long id,
                     @RequestParam(value = "name") String name,
                     @RequestParam(value = "password") String password) {
        ReturnWrapper<Account> accountReturnWrapper = accountService.find(id);
        Account account = accountReturnWrapper.getData();
        Map<String, Object> map = new HashMap<String, Object>();
        if (account.getName().equals(name) && account.getPassword().equals(password)) {
            map.put("result", "SUCCESS");
        } else {
            map.put("result", "FAIL");
        }
        return map;
    }

}
