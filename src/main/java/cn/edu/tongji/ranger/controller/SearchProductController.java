package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model2show.SimpleProduct;
import cn.edu.tongji.ranger.service.SearchProductService;
import cn.edu.tongji.ranger.utils.SearchCondition;
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
 * Created by daidongyang on 5/15/16.
 */

@Controller
@RequestMapping("/api/searchproduct")
public class SearchProductController {

    @Autowired
    private SearchProductService searchProductService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<SimpleProduct> searchProduct(@RequestBody SearchCondition searchCondition){
        System.out.println(searchCondition);
        List<SimpleProduct> results = searchProductService.listProducts(searchCondition);
        System.out.println(results.size());
//        return new ArrayList<SimpleProduct>();
        return results;
    }

    @RequestMapping(value = "/setoff")
    @ResponseBody
    public List<Location> showLocations(@RequestBody long fatherId){
        return searchProductService.listLocations(fatherId);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> test(@RequestBody SearchCondition searchcondition){
        System.out.println(searchcondition);
        Map<String,String> map = new HashMap<String, String>();
        map.put("res","test");
        return map;

    }


}
