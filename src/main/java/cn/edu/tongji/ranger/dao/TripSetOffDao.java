package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.TripSetoff;
import cn.edu.tongji.ranger.model2show.TripSetoff2;
import org.springframework.stereotype.Repository;

/**
 * Created by 马二爷 on 2016/4/30.
 */

public interface TripSetOffDao {
    public TripSetoff2 getTripSetOffById(long id);
}
