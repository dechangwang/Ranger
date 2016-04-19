package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Account;

import java.util.List;

public interface AccountService {
    public void create(Account account);
    public List<Account> find(String name);
}

/*

public interface AccountService extends AbstractService<Account, Long> {

}
*/
