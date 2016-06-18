package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GuideDao;
import cn.edu.tongji.ranger.model.Guide;
import cn.edu.tongji.ranger.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */
@Service("GuideService")
@Transactional
public class GuideServiceImpl implements GuideService{
    @Autowired
    private GuideDao guideDao;
    public void create(Guide guide) {
        guideDao.create(guide);
    }

    public boolean updateGuide(Guide guide) {
        return guideDao.updateGuide(guide);
    }

    public Guide findById(Long id) {
        return guideDao.findById(id);
    }

    @Override
    public Guide findByPhone(String phone) {
        return guideDao.findByPhone(phone);
    }

    @Override
    public List<Guide> findByAngencyID(Long id) {
        return guideDao.findByAngencyID(id);
    }

    @Override
    public void delteGuide(Guide guide) {
        guideDao.deleteGuide(guide);
    }
}
