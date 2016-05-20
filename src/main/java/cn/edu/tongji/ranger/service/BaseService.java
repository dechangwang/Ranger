package cn.edu.tongji.ranger.service;

public interface BaseService<T> {

    public Long create(T t);

    public void update(T t);

    public void remove(T t);

}
