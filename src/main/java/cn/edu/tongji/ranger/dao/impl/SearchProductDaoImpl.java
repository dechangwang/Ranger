package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.SearchProductDao;
import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by daidongyang on 5/14/16.
 */

@Repository("SearchProductDao")
public class SearchProductDaoImpl implements SearchProductDao {

    @Autowired
    private SessionFactory sessionFactory;

//    private String countSql = "";
//
//    private Long resultCounts = 1L;

    public List<Long> searchForIds(String[] searchKeys, long setoffLocationId,int firstResult, int resultSize, SearchProductOrderEnum order) {
        List<Long> results = new ArrayList<Long>();
        String select = "select product.product_id as pid ";

        String from = "from product ";
        String where = generateWhereStrWithLikes(searchKeys) + "and product.setoff_location_id = " + setoffLocationId + " ";
        String groupBy = "";
        String orderBy = "";

        switch(order){
            case DEFAULT:
                break;

            case CLICK_RATE:
                orderBy = "order by product.click_rate desc ";
                break;

            case PRICE_UP:
                from += "natural join  trip_price ";
                groupBy = "group by product.product_id ";
                orderBy = "order by avg(trip_price.price) ";
                break;

            case PRICE_DOWN:
                from += "natural join trip_price ";
                groupBy = "group by product.product_id ";
                orderBy = "order by avg(trip_price.price) desc ";
                break;

            case COMMENT_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by pid ";
                orderBy = "order by sum(trip_setoff.comment_count) desc ";
                break;

            case PURCHASE_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by product.product_id ";
                orderBy = "order by sum(trip_setoff.purchase_count) desc ";
                break;

            case REMARK:
                from += "natural join trip_setoff ";
                groupBy = "group by product.product_id ";
                orderBy = "order by (sum(trip_setoff.comment_count * trip_setoff.avg_remark)/sum(trip_setoff.comment_count)) desc";
                break;

        }

        String sql = select + from + where + groupBy + orderBy;
        Session session = sessionFactory.getCurrentSession();
//        System.err.println(sql);

//        countSql = "select count(distinct product.product_id) " + from + where;
//        updateResultsCount();
//        System.err.println(countSql);
//        System.err.println(((Number) sqlQuery.uniqueResult()).intValue());
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        sqlQuery.setFirstResult(firstResult - 1);
        sqlQuery.setMaxResults(resultSize);
        List list = sqlQuery.list();
        for(Object o : list){
            Map row = (Map)o;
            Long pid = ((BigInteger)row.get("pid")).longValue();
            results.add(pid);
        }
        return results;
    }

    public List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize, SearchProductOrderEnum order, int duration) {
        return null;
    }

    public List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize, SearchProductOrderEnum order, double lowerLimit, double upperLimit) {
        return null;
    }

    public List<Long> searchForIds(String[] searchKeys, long setOffLocationId, int firstResult, int resultSize, SearchProductOrderEnum order, int duration, double lowerLimit, double upperLimit) {
        return null;
    }

    @Override
    public Long getResultsCount(String[] searchKeys, long setoffLocationId, SearchProductOrderEnum order){

        String select = "select product.product_id as pid ";

        String from = "from product ";
        String where = generateWhereStrWithLikes(searchKeys) + "and product.setoff_location_id = " + setoffLocationId + " ";
        String groupBy = "";
        String orderBy = "";

        switch(order){
            case DEFAULT:
                break;

            case CLICK_RATE:
                orderBy = "order by product.click_rate desc ";
                break;

            case PRICE_UP:
                from += "natural join  trip_price ";
                groupBy = "group by product.product_id ";
                orderBy = "order by avg(trip_price.price) ";
                break;

            case PRICE_DOWN:
                from += "natural join trip_price ";
                groupBy = "group by product.product_id ";
                orderBy = "order by avg(trip_price.price) desc ";
                break;

            case COMMENT_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by pid ";
                orderBy = "order by sum(trip_setoff.comment_count) desc ";
                break;

            case PURCHASE_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by product.product_id ";
                orderBy = "order by sum(trip_setoff.purchase_count) desc ";
                break;

            case REMARK:
                from += "natural join trip_setoff ";
                groupBy = "group by product.product_id ";
                orderBy = "order by (sum(trip_setoff.comment_count * trip_setoff.avg_remark)/sum(trip_setoff.comment_count)) desc";
                break;

        }

        String sql = select + from + where + groupBy;

        Long result = 1L;
        String countSql = "select count(distinct pid) from  ( " + sql + ") as temp";
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(countSql);
        try{
            System.out.println(countSql);
            result = ((Number) sqlQuery.uniqueResult()).longValue();
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;

    }



    private String generateWhereStrWithLikes(String[] args){
        StringBuilder sb = new StringBuilder("where (");
        for(int i = 0; i < args.length - 1; i++){
            sb.append("product.search_content like \"%");
            sb.append(args[i]);
            sb.append("%\" and ");
        }
        sb.append("product.search_content like \"%");
        sb.append(args[args.length - 1]);
        sb.append("%\") ");
        return sb.toString();
    }
}
