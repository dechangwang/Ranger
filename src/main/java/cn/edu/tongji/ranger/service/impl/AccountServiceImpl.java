package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.AccountDao;
import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.service.AccountService;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void create(Account account) {
        accountDao.create(account);
    }

    public List<Account> find(String name) {
        return accountDao.findByName(name);
    }
}

/*
@Service
public class AccountServiceImpl extends AbstractServiceImpl<Account, Long> implements AccountService {
    @Autowired
    AccountServiceImpl(GenericDAO<Account, Long> dao) {
        super(dao);
    }
}
*/
