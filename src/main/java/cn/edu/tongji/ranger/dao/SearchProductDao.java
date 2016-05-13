package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model.SimpleProduct;
import cn.edu.tongji.ranger.utils.SearchProductOrderType;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */
public interface SearchProductDao {
    List<SimpleProduct> getSimpleProducts(String searchStr, int resultSize, SearchProductOrderType searchProductOrderType);

    List<Product> getProduct(String searchStr, int resultSize, SearchProductOrderType searchProductOrderType);
}
