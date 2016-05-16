package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model.Product;
import cn.edu.tongji.ranger.utils.SearchCondition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by daidongyang on 5/15/16.
 */

@Controller
@RequestMapping("/api/searchproduct")
public class SearchProductController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<Product> searchProduct(){
        return null;
    }

    @RequestMapping(value = "/setoff")
    @ResponseBody
    public List<Location> showLocations(long fatherId){
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> test(@RequestBody SearchCondition searchcondition){
        System.out.println(searchcondition);
        return null;
    }
}
