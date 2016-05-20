package cn.edu.tongji.ranger.dao;

public interface BaseDao<T> {

    public Long create(T t);

    public void update(T t);

    public void remove(T t);

}
