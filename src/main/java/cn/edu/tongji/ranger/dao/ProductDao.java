package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model.Product3;
import cn.edu.tongji.ranger.model2show.Product2;

/**
 * Created by 马二爷 on 2016/4/30.
 */
public interface ProductDao {
    public Product3 getProductById(long pid);
}
