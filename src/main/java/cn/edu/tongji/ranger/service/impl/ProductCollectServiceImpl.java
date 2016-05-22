package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Collection;
import cn.edu.tongji.ranger.service.ProductCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created by daidongyang on 5/23/16.
 */

@Service("ProductCollectService")
public class ProductCollectServiceImpl implements ProductCollectService {

    @Autowired
    private GenericDao genericDao;

    @Override
    public List<Collection> listCollectionsByAngencyId(Long angencyId) {
        Angency angency = genericDao.findById(angencyId, Angency.class);
        Collection example = new Collection();
        example.setAngency(angency);
        List<Collection> results = genericDao.findByExample(example, Collection.class);
        return results;
    }

    @Override
    public void deleteCollectionById(Long collectionId) {
        genericDao.deleteById(collectionId, Collection.class);

    }

    @Override
    public Collection findCollectionById(Long collectionId) {
        return genericDao.findById(collectionId, Collection.class);
    }
}
