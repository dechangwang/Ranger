package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */


public interface SearchProductService {
    List<Product>  listProducts(String searchStr, long setOffLocationId, int resultSize, SearchProductOrderEnum searchProductOrderEnum);
}
