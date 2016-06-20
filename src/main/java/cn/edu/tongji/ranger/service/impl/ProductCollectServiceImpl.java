package cn.edu.tongji.ranger.service.impl;

import cn.edu.tongji.ranger.dao.GenericDao;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Collection;
import cn.edu.tongji.ranger.model.Product3;
import cn.edu.tongji.ranger.model2show.Collection2;
import cn.edu.tongji.ranger.service.ProductCollectService;
import cn.edu.tongji.ranger.utils.CollectionCreateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by daidongyang on 5/23/16.
 */

@Service("ProductCollectService")
@Transactional
public class ProductCollectServiceImpl implements ProductCollectService {

    @Autowired
    private GenericDao genericDao;

    @Override
    public List<Collection2> listCollectionsByAngencyId(Long angencyId) {
        try {
            Collection2 example = new Collection2();
            example.setAngencyId(angencyId);
            List<Collection2> results = genericDao.findByExample(example, Collection2.class);
            return results;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void deleteCollectionById(Long collectionId) {
        genericDao.deleteById(collectionId, Collection2.class);

    }

    @Override
    public Collection2 findCollectionById(Long collectionId) {
        return genericDao.findById(collectionId, Collection2.class);
    }

    @Override
    public void createCollection(CollectionCreateParam collectionCreateParam) {
        long productId = collectionCreateParam.getProductId();
        long angencyId = collectionCreateParam.getAngencyId();
        
        Collection2 collection2 = new Collection2();
        Product3 product = genericDao.findById(productId, Product3.class);
        collection2.setProduct(product);
        collection2.setAngencyId(angencyId);
        collection2.setCollectTime(new Timestamp(new Date().getTime()));
        genericDao.saveOrUpdate(collection2);


    }
}
