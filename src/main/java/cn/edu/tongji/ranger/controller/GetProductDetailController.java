package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.model2show.Product2;
import cn.edu.tongji.ranger.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daidongyang on 5/17/16.
 */

@Controller
@RequestMapping("/api/getproductdetail/")
public class GetProductDetailController {

    @Autowired
    private SearchProductService searchProductService;

    @RequestMapping(value = "id", method = RequestMethod.POST)
    @ResponseBody
    public Product2 getProductById(@RequestBody Long id){
        System.out.println(id);
        Product2 p =  searchProductService.getProductInfor(id);
        System.out.println(p);
        return p;
    }

}
