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


    public Long create(Angency angency){
        return angencyDao.create(angency);
    }

    public void update(Angency angency) {
        angencyDao.update(angency);
    }

    public void remove(Angency angency) {
        angencyDao.remove(angency);
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

    public Angency findByPhone(String phone) {
        return angencyDao.findByPhone(phone);
    }

    public Angency findByEmail(String email) {
        return angencyDao.findByEmail(email);
    }

    public Angency getSystemAccoount() {
        return angencyDao.findById(0);
    }
}
