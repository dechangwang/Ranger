package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.init.HibernateUtil;
import cn.edu.tongji.ranger.utils.SearchProductOrderEnum;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/15/16.
 */
public class SearchProductDaoImplTest {
    SessionFactory sessionFactory;
    Transaction transaction;

    @Before
    public void before(){
        sessionFactory = HibernateUtil.getSessionFactory();
        transaction = sessionFactory.getCurrentSession().beginTransaction();

    }

    @Test
    public void searchForIdsTest() throws Exception {
        String[] searchKeys = {"北京", "三"};
        long setOffLocationId = 1L;
        int firstResult = 0;
        int resultsize = 2;
        List<Long> results = searchForIds(searchKeys, setOffLocationId, firstResult, resultsize, SearchProductOrderEnum.PRICE_UP);
        System.out.println(results);
    }

    @After
    public void after(){
        transaction.commit();
    }

    public List<Long> searchForIds(String[] searchKeys, long setoffLocationId, int firstResult, int resultSize, SearchProductOrderEnum order) {
        List<Long> results = new ArrayList<Long>();
        String select = "select product.id as pid ";
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
                groupBy = "group by pid ";
                orderBy = "order by avg(trip_price.price) ";
                break;

            case PRICE_DOWN:
                from += "natural join trip_price ";
                groupBy = "group by pid ";
                orderBy = "order by avg(trip_price.price) desc ";
                break;

            case COMMENT_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by pid ";
                orderBy = "order by sum(trip_setoff.comment_count) desc ";
                break;

            case PURCHASE_COUNT:
                from += "natural join trip_setoff ";
                groupBy = "group by pid ";
                orderBy = "order by sum(trip_setoff.purchase_count) desc ";
                break;

            case REMARK:
                from += "natural join trip_setoff ";
                groupBy = "group by pid ";
                orderBy = "order by (sum(trip_setoff.comment_count * trip_setoff.avg_remark)/sum(trip_setoff.comment_count)) desc";
                break;

        }

        String sql = select + from + where + groupBy + orderBy;
        Session session = sessionFactory.getCurrentSession();
        System.out.println(sql);
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        sqlQuery.setFirstResult(firstResult);
        sqlQuery.setMaxResults(resultSize);
        List list = sqlQuery.list();
        for(Object o : list){
            Map row = (Map)o;
            Long pid = ((BigInteger)row.get("pid")).longValue();
            results.add(pid);
        }
        return results;
    }

    private String generateWhereStrWithLikes(String[] args){
        StringBuilder sb = new StringBuilder("where (");
        for(int i = 0; i < args.length - 1; i++){
            sb.append("product.search_content like \"%");
            sb.append(args[i]);
            sb.append("%\" or ");
        }
        sb.append("product.search_content like \"%");
        sb.append(args[args.length - 1]);
        sb.append("%\") ");
        return sb.toString();
    }


}