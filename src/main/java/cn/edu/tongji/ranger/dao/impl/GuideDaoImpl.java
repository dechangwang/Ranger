package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.GuideDao;
import cn.edu.tongji.ranger.model.Guide;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Repository("GuideDao")
public class GuideDaoImpl implements GuideDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Guide guide) {
        sessionFactory.getCurrentSession().persist(guide);
    }
}
