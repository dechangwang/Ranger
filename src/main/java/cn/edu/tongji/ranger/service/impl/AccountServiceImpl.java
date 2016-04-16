package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.service.AccountService;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl extends AbstractServiceImpl<Account, Long> implements AccountService {
    @Autowired
    AccountServiceImpl(GenericDAO<Account, Long> dao) {
        super(dao);
    }
}
