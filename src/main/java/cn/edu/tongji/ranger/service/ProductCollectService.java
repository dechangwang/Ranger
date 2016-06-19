package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.model.Collection;
import cn.edu.tongji.ranger.model2show.Collection2;
import cn.edu.tongji.ranger.utils.CollectionCreateParam;

import java.util.List;

/**
 * Created by daidongyang on 5/23/16.
 */
public interface ProductCollectService {
    List<Collection2> listCollectionsByAngencyId(Long angencyId);
    void deleteCollectionById(Long collectionId);
    Collection2 findCollectionById(Long collectionId);
    void createCollection(CollectionCreateParam collectionCreateParam);
}
