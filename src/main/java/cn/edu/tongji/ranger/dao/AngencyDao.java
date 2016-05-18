package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Angency;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */
public interface AngencyDao extends BaseDao<Angency> {
    public List<Angency> findByName(String name);

    public Angency findById(long id);

    public boolean updateAngency(Angency angency);

    public Angency findByPhone(String phone);

    public Angency findByEmail(String email);
     public Angency getAngencyById(long id);
}
