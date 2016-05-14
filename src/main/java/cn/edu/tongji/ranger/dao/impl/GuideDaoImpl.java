package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.GuideDao;
import cn.edu.tongji.ranger.model.Guide;
import org.hibernate.Session;
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

    public boolean updateGuide(Guide guide) {
        Session session = sessionFactory.getCurrentSession();
        session.update(guide);
        return true;
    }

    public Guide findById(long id) {
        Guide guide = (Guide) sessionFactory.getCurrentSession().get(Guide.class,id);
        return guide;
    }
}
