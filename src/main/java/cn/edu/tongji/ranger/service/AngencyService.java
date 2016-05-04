package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.model.Angency;

import java.util.List;

public interface AngencyService {
    public void create(Account account);
    public void create(Angency angency);
    public List<Account> find(String name);
    public List<Angency> findExistAngency(String name);
}

/*

public interface AccountService extends AbstractService<Account, Long> {

}
*/
