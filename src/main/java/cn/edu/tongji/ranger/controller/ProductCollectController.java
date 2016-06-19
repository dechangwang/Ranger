package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Collection;
import cn.edu.tongji.ranger.model2show.Collection2;
import cn.edu.tongji.ranger.service.ProductCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daidongyang on 5/23/16.
 */
@Controller
@RequestMapping("/api/collect")
public class ProductCollectController {

    @Autowired
    ProductCollectService productCollectService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> delete(@RequestBody Long id){
        productCollectService.deleteCollectionById(id);
        Map<String,String> map = new HashMap<String, String>();
        map.put("res","succeed delete");
        return map;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Collection2> findByAngencyId(@RequestBody Long angencyId){
        return productCollectService.listCollectionsByAngencyId(angencyId);
    }

    @RequestMapping("/get")
    @ResponseBody
    public Collection getCollectionById(Long collectionId){
        return null;
    }
}
