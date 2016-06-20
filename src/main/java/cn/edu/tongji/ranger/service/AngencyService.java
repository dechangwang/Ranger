package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Angency;

import java.util.List;

public interface AngencyService extends BaseService<Angency> {

    public List<Angency> findExistAngency(String name);

    public Angency findById(long id);

    public boolean updateAngency(Angency angency);

    public Angency findByPhone(String phone);

    public Angency findByEmail(String email);

    public Angency getSystemAccoount();
}