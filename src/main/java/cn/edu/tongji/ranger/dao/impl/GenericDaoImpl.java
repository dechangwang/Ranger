package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.dao.GenericDao;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */
public class GenericDaoImpl implements GenericDao {
    public void saveOrUpdate(Object obj) {

    }

    public <T> List<T> findByExample(T instance, Class<T> type) {
        return null;
    }

    public <T> T findById(Long id, Class<T> type) {
        return null;
    }
}
