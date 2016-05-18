package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GuideDao;
import cn.edu.tongji.ranger.model.Guide;
import cn.edu.tongji.ranger.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
