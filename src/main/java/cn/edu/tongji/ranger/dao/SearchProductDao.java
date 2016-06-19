package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;

import java.util.List;
import java.util.Set;

/**
 * Created by daidongyang on 5/14/16.
 */
public interface SearchProductDao {
//    List<SimpleProduct> getSimpleProducts(String searchStr, int resultSize, SearchProductOrderEnum searchProductOrderEnum);

    List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize, SearchProductOrderEnum order);

    List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize,
                           SearchProductOrderEnum order, int duration);

    List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize,
                                SearchProductOrderEnum order,
                                double lowerLimit, double upperLimit);

    List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize,
                            SearchProductOrderEnum order, int duration,
                            double lowerLimit, double upperLimit);

    Long getResultsCount(String[] searchKeys, long setoffLocationId, SearchProductOrderEnum order);

}
