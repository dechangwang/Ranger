package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.RechargeDao;
import cn.edu.tongji.ranger.model.BankCard;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangdechang on 2016/5/16.
 */
@Repository("RechargeDao")
public class RechargeDaoImpl implements RechargeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean findByNumber(String cardNumber) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(BankCard.class)
                .add(Restrictions.eq("cardNumber", cardNumber));

        List<BankCard> list = criteria.list();
        if(list.size() > 0)
            return true;
        return false;
    }
}
