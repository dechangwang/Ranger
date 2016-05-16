package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.dao.SearchProductDao;
import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model.SimpleProduct;
import cn.edu.tongji.ranger.service.SearchProductService;
import cn.edu.tongji.ranger.utils.SearchCondition;
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

    public List<SimpleProduct> listProducts(SearchCondition searchCondition) {
        StringBuilder searchStrSb = new StringBuilder(searchCondition.getSearchStr());
        if(searchCondition.getLimits() != null){
            for(String str : searchCondition.getLimits()){
                searchStrSb.append(" ");
                searchStrSb.append(str);
            }
        }

        String[] searchKeys = searchStrSb.toString().split("\\s+");
        long setOffLocationId = searchCondition.getSetoffLoctionId();
        int firstResult = searchCondition.getFirstResult();
        int resultSize = searchCondition.getResultSize();
        SearchProductOrderEnum order = searchCondition.getOrder();
        double minPrice = searchCondition.getMinPrice();
        double maxPrice = searchCondition.getMaxPrice();
        int minDuration = searchCondition.getMinDuration();
        int maxDuration = searchCondition.getMaxDuration();

        List<Long> pids = null;

        // need to : add check logic code here
        pids = searchProductDao.searchForIds(searchKeys, setOffLocationId, firstResult, resultSize, order);
        List<SimpleProduct> simpleProducts = new ArrayList<SimpleProduct>();
        if(pids != null){
            for(Long pid : pids){
                SimpleProduct simpleProduct = genericDao.findById(pid, SimpleProduct.class);
                simpleProducts.add(simpleProduct);
            }
        }
        return simpleProducts;

    }

    public List<Location> listLocations(long fatherId) {
        Location location = new Location();
        location.setFatherId(fatherId);
        List<Location> results = genericDao.findByExample(location, Location.class);
        return results;
    }

    public Product getProductInfor(long productId) {
        return genericDao.findById(productId, Product.class);
    }


}
