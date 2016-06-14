package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.TransactionRecord;

public interface TransactionRecordDao extends BaseDao<TransactionRecord> {

    public TransactionRecord findById(Long id);

}
