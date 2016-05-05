package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.AccountDao;
import cn.edu.tongji.ranger.model.Account;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Account account) {
//        System.out.println(sessionFactory);
        sessionFactory.getCurrentSession().persist(account);
    }

    public List<Account> findByName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Account.class)
                .add(Restrictions.eq("name", name));
        return (List<Account>) criteria.list();
    }
}
/*
@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> implements AccountDao {

}
*/
