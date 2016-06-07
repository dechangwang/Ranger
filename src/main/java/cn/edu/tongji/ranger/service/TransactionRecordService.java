package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.TransactionRecord;

/**
 * Created by LiaoShanhe on 2016/6/6.
 */
public interface TransactionRecordService extends BaseService<TransactionRecord> {

    public TransactionRecord findById(Long id);

    public boolean changeRecordStatus(Long id, String status);

}
