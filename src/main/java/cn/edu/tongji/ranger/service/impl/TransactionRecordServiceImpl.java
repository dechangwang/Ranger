package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.TransactionRecordDao;
import cn.edu.tongji.ranger.model.TransactionRecord;
import cn.edu.tongji.ranger.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LiaoShanhe on 2016/6/6.
 */
@Service("TransactionRecordService")
@Transactional
public class TransactionRecordServiceImpl implements TransactionRecordService {

    public static final int BUYER_PAY_TO_AGENT = 0;
    public static final int AGENT_PAY_TO_SELLER = 1;

    @Autowired
    private TransactionRecordDao transactionRecordDao;

    public Long create(TransactionRecord transactionRecord) {
        return transactionRecordDao.create(transactionRecord);
    }

    public void update(TransactionRecord transactionRecord) {
        transactionRecordDao.update(transactionRecord);
    }

    public void remove(TransactionRecord transactionRecord) {
        transactionRecordDao.remove(transactionRecord);
    }

    public TransactionRecord findById(Long id) {
        return transactionRecordDao.findById(id);
    }

    public boolean changeRecordStatus(Long id, String status) {
        TransactionRecord transactionRecord = findById(id);
        switch (status) {
            case "BUYER_PAY_TO_AGENT":
                transactionRecord.setStatus(BUYER_PAY_TO_AGENT);
                break;
            case "AGENT_PAY_TO_SELLER":
                transactionRecord.setStatus(AGENT_PAY_TO_SELLER);
                break;
            default:
                return false;
        }
        update(transactionRecord);
        return true;
    }

    public TransactionRecord findByOrderFormId(Long orderFormId) {
        return transactionRecordDao.findByOrderFormId(orderFormId);
    }
}
