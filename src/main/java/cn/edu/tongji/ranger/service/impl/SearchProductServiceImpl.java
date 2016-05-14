package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.dao.SearchProductDao;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.service.SearchProductService;
import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daidongyang on 5/15/16.
 */

@Service("SearchProductService")
@Transactional
public class SearchProductServiceImpl implements SearchProductService {

    @Autowired
    private SearchProductDao searchProductDao;

    @Autowired
    private GenericDao genericDao;

    public List<Product> listProducts(String searchStr, long setOffLocationId, int firstResult, int resultSize,
                                      SearchProductOrderEnum order) {
        String[] searchKeys = searchStr.split(" ");
        List<Long> pids = searchProductDao.searchForIds(searchKeys, setOffLocationId, firstResult, resultSize, order);
        List<Product> products = new ArrayList<Product>();
        for(Long pid : pids){
            Product product = genericDao.findById(pid, Product.class);
            products.add(product);
        }

        return products;
    }
}
