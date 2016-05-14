package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by daidongyang on 5/15/16.
 */

@Controller
@RequestMapping("/search")
public class SearchProductController {

    @ResponseBody
    public List<Product> searchProduct(){
        return null;
    }
}
