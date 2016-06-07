package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.TripPictureDao;
import cn.edu.tongji.ranger.model.TripPicture;
import cn.edu.tongji.ranger.service.TripPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangdechang on 2016/6/6.
 */

@Service("TripPictureService")
@Transactional
public class TripPictureServiceImpl implements TripPictureService {

    @Autowired
    TripPictureDao tripPictureDao;
    @Override
    public void create(TripPicture tripPicture) {
        tripPictureDao.create(tripPicture);
    }
}
