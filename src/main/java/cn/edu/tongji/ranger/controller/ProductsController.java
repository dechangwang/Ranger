package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Location;
import cn.edu.tongji.ranger.model.ProductsInfo;
import cn.edu.tongji.ranger.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdechang on 2016/5/7.
 */
@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/release",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseProduct(@RequestBody ProductsInfo productsInfo) {
        Location location = new Location();
        location.setName(productsInfo.getStartloc());
        location.setFatherId(1);


        System.out.println(productsInfo);
        return null;
    }
    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<BB> productsList(){
        List<BB> b = new ArrayList<BB>();
        b.add(new BB("122","南京旅游","2016-6-1","2016-5-1","成人："+1000.0+"小孩：500","未出行"));
        b.add(new BB("111","北京旅游","2016-6-1","2016-5-1",""+1000.0,"未出行"));
        b.add(new BB("123","北京旅游","2016-6-1","2016-5-1",""+1000.0,"未出行"));
        b.add(new BB("133","北京旅游","2016-6-1","2016-5-1",""+1000.0,"未出行"));

        return b;
    }
}
