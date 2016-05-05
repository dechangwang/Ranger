package cn.edu.tongji.ranger.dao;

/**
 * Created by 马二爷 on 2016/5/2.
 */
public interface TripPriceDao {
    public double getProductTouristPrice(long productId,long touristTypeId);
}
