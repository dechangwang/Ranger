package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Angency;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */
public interface AngencyDao {
    public void create(Angency angency);
    public List<Angency> find();
}
