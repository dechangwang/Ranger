package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.TransactionRecordDao;
import cn.edu.tongji.ranger.model.TransactionRecord;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TransactionRecordDao")
public class TransactionRecordDaoImpl extends BaseDaoImpl<TransactionRecord> implements TransactionRecordDao {

    @Autowired
    private SessionFactory sessionFactory;

    public TransactionRecord findById(Long id) {
        return (TransactionRecord) sessionFactory.getCurrentSession().get(TransactionRecord.class, id);
    }

    public TransactionRecord findByOrderFormId(Long orderFormId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TransactionRecord.class)
                .add(Restrictions.eq("orderformId", orderFormId));
        List list = criteria.list();
        return list.size() > 0 ? (TransactionRecord) list.get(0) : null;
    }
}
