package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.AngencyDao;
import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.service.AngencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AngencyService")
@Transactional
public class AngencyServiceImpl implements AngencyService {

//    @Autowired
//    private AccountDao accountDao;
    @Autowired
    private AngencyDao angencyDao;

//    public void create(Account account) {
//        accountDao.create(account);
//    }
//
    public void create(Angency angency){
        angencyDao.create(angency);
    }
//    public List<Account> find(String name) {
//        return accountDao.findByName(name);
//    }

    public List<Angency> findExistAngency(String name) {
        return angencyDao.findByName(name);
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
