package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model2show.Product2;
import cn.edu.tongji.ranger.model2show.SimpleProduct;
import cn.edu.tongji.ranger.utils.SearchCondition;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */


public interface SearchProductService {
    List<SimpleProduct>  listProducts(SearchCondition searchCondition);
    List<Location> listLocations(long fatherId);
    List<Location> getCofatherLocations(long id);
    Location getLocationById(long id);
    Product2 getProductInfor(long productId);
    Long getResultCount(SearchCondition searchCondition);
}
