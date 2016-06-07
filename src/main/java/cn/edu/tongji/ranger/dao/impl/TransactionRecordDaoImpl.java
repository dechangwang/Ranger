package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.TransactionRecordDao;
import cn.edu.tongji.ranger.model.TransactionRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TransactionRecordDao")
public class TransactionRecordDaoImpl extends BaseDaoImpl<TransactionRecord> implements TransactionRecordDao {

    @Autowired
    private SessionFactory sessionFactory;

    public TransactionRecord findById(Long id) {
        return (TransactionRecord) sessionFactory.getCurrentSession().get(TransactionRecord.class, id);
    }
}
