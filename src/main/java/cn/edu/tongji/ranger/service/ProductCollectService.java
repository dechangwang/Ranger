package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Collection;

import java.util.List;

/**
 * Created by daidongyang on 5/23/16.
 */
public interface ProductCollectService {
    List<Collection> listCollectionsByAngencyId(Long angencyId);
    void deleteCollectionById(Long collectionId);
    Collection findCollectionById(Long collectionId);
}
