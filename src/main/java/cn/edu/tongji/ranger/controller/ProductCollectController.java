package cn.edu.tongji.ranger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void findByAngencyId(Long angencyId){

    }

    @RequestMapping("/get")
    public void getCollectionById(Long collectionId){

    }
}
