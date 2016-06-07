package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by daidongyang on 5/23/16.
 */
@Controller
@RequestMapping("/api/collect")
public class ProductCollectController {

    @RequestMapping("/delete")
    public void delete(Long id){

    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Collection> findByAngencyId(Long angencyId){
        return null;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Collection getCollectionById(Long collectionId){
        return null;
    }
}
