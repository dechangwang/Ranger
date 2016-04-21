package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.service.AbstractService;
import cn.edu.tongji.ranger.utils.ReturnPageWrapper;
import cn.edu.tongji.ranger.utils.ReturnWrapper;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.search.Search;

import java.io.Serializable;
import java.util.List;

public class AbstractServiceImpl<T, ID extends Serializable> implements AbstractService<T, ID> {
/*
    protected GenericDAO<T, ID> dao;

    AbstractServiceImpl(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    public ReturnWrapper<T> find(ID id) {
        ReturnWrapper<T> ret = new ReturnWrapper<T>();

        ret.setData(dao.find(id));

        return ret;
    }

    public ReturnWrapper<T> save(T entity) {
        ReturnWrapper<T> ret = new ReturnWrapper<T>();

        dao.save(entity);
        ret.setData(entity);

        return ret;
    }

    public ReturnWrapper<T> update(T entity) {
        ReturnWrapper<T> ret = new ReturnWrapper<T>();

        dao.save(entity);
        ret.setData(entity);

        return ret;
    }

    public ReturnWrapper<Void> remove(ID id) {
        ReturnWrapper<Void> ret = new ReturnWrapper<Void>();

        dao.remove(dao.find(id));

        return ret;
    }

    @SuppressWarnings("unchecked")
    public ReturnWrapper<List<T>> list() {
        ReturnWrapper<List<T>> ret = new ReturnWrapper<List<T>>();

        Search s = new Search().addSortDesc("id");
        ret.setData((List<T>)dao.search(s));

        return ret;
    }

    @SuppressWarnings("unchecked")
    public ReturnWrapper<List<T>> list(int currPageNum, int numPerPage) {
        ReturnPageWrapper<List<T>> ret = new ReturnPageWrapper<List<T>>();

        Search s = new Search().addSortDesc("id").setFirstResult((currPageNum - 1) * numPerPage).setMaxResults(numPerPage);
        ret.setData((List<T>)dao.search(s));

        ret.setCurrPageNum(currPageNum);
        ret.setNumPerPage(numPerPage);
        ret.setTotalItemNum(dao.count(new Search()));

        return ret;
    }*/

}
