package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Guide;

/**
 * Created by wangdechang on 2016/4/25.
 */
public interface GuideService {
    public void create(Guide guide);
    public boolean updateGuide(Guide guide);
    public Guide findById(Long id);

}
