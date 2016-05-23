package cn.edu.tongji.ranger.dao;

import java.util.List;

/**
 * Created by daidongyang on 5/14/16.
 */
public interface GenericDao {
    void saveOrUpdate(Object obj);
    <T> List<T> findByExample(T instance, Class<T> type);
    <T>T findById(Long id, Class<T> type);
    <T> void deleteById(Long id, Class<T> type);
    void persist(Object obj);
}
