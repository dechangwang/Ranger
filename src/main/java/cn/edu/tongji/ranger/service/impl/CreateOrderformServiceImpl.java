package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.CreateOrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by daidongyang on 5/24/16.
 */
@Service("CreateOrderformService")
@Transactional
public class CreateOrderformServiceImpl implements CreateOrderformService {

    @Autowired
    private GenericDao genericDao;

    @Override
    public void createOrderform(Orderform orderform) {
        genericDao.persist(orderform);
    }
}
