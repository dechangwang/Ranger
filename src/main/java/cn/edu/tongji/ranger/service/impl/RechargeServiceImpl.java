package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.RechargeDao;
import cn.edu.tongji.ranger.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangdechang on 2016/5/16.
 */
@Service("RechargeService")
@Transactional
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeDao rechargeDao;

    public boolean findByNumber(String cardNumber) {
        return rechargeDao.findByNumber(cardNumber);
    }
}
