package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.*;

import java.util.List;

/**
 * Created by wangdechang on 2016/5/7.
 */
public interface ProductsDao {
    public long create(Product product);
    public <T>T findById(Long id, Class<T> type);
    public List<MyProduct> findBySupplierId(long supplierID);
    public void update(Product product);
/*
    public Product findById(long id);
*/
    public void create(TripPicture tripPicture);
    public void create(TripDetail tripDetail);
    public void create(TripAccomodation tripAccomodation);
    public void create(TripDestination tripDestination);
    public void create(TripSetoff tripSetoff);
    public void create(TripTraffic tripTraffic);
    public void create(TrafficType trafficType);
    public void create(Location location);


}
