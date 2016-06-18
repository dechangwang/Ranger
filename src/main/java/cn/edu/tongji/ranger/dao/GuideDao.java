package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Guide;

import java.util.List;

/**
 * Created by wangdechang on 2016/4/25.
 */
public interface GuideDao {
    public void create(Guide guide);
    public boolean updateGuide(Guide guide);
    public Guide findById(long id);
    public Guide findByPhone(String phone);
    public List<Guide> findByAngencyID(Long id);
    public void deleteGuide(Guide guide);
}
