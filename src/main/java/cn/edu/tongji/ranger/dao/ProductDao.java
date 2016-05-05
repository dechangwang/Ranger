package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Product;

/**
 * Created by 马二爷 on 2016/4/30.
 */
public interface ProductDao {
    public Product getProductById(long pid);
}
