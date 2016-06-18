package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.model.Orderform;
import org.springframework.stereotype.Service;

/**
 * Created by daidongyang on 5/24/16.
 */


public interface CreateOrderformService {

    void createOrderform(Orderform orderform);

}
