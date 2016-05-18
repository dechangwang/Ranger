package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.AngencyDao;
import cn.edu.tongji.ranger.model.Account;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.service.AngencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AngencyService")
@Transactional
public class AngencyServiceImpl implements AngencyService {

    @Autowired
    private AngencyDao angencyDao;


    public void create(Angency angency){
        angencyDao.create(angency);
    }

    public List<Angency> findExistAngency(String name) {
        return angencyDao.findByName(name);
    }

    public Angency findById(long id) {
        return angencyDao.findById(id);
    }

    public boolean updateAngency(Angency angency) {
        return angencyDao.updateAngency(angency);
    }
}
