package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.GuideDao;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Guide;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Repository("GuideDao")
public class GuideDaoImpl implements GuideDao {
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
        Guide guide = (Guide) sessionFactory.getCurrentSession().get(Guide.class, id);
        return guide;
    }

    @Override
    public Guide findByPhone(String phone) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Guide.class)
                .add(Restrictions.eq("phone", phone));
        List<Guide> guideList = criteria.list();
        return guideList.size() == 0 ? null : guideList.get(0);
    }

    @Override
    public List<Guide> findByAngencyID(Long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Guide.class)
                .add(Restrictions.eq("angency_id",id));
        List<Guide> guideList = criteria.list();
        return guideList;
    }

    @Override
    public void deleteGuide(Guide guide) {
        sessionFactory.getCurrentSession().delete(guide);
    }
}
