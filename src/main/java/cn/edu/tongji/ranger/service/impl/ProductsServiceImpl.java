package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.ProductsDao;
import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Service("ProductsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDao productsDao;

    public void create(Product product) {
        productsDao.create(product);
    }

    public void create(TripPicture tripPicture) {
        productsDao.create(tripPicture);
    }

    public void create(TripDetail tripDetail) {
        productsDao.create(tripDetail);
    }

    public void create(TripAccomodation tripAccomodation) {
        productsDao.create(tripAccomodation);
    }

    public void create(TripDestination tripDestination) {
        productsDao.create(tripDestination);
    }

    public void create(TripSetoff tripSetoff) {
        productsDao.create(tripSetoff);
    }

    public void create(TripTraffic tripTraffic) {
        productsDao.create(tripTraffic);
    }

    public void create(TrafficType trafficType) {
        productsDao.create(trafficType);
    }

    public void create(Location location) {
        productsDao.create(location);
    }
}
