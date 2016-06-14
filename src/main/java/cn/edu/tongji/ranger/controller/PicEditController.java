package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.service.AngencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdechang on 2016/6/13.
 */
@Controller
@RequestMapping("/picture")
public class PicEditController {

    @Autowired
    private AngencyService angencyService;

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public List<String> editAngencyPic(@RequestParam("angencyId")String angencyId){
        System.out.println(angencyId);
        Angency angency = angencyService.findById(Long.parseLong(angencyId));
        List<String> list = new ArrayList<>();
        String[] imageArr = angency.getCertificate().split("&");
        for(String str : imageArr){
            System.out.println("str - >"+str);
            str = str.trim();
            int len = str.trim().length();
           // str = str.substring(angencyId.length()+1,len);
            if(null != str && !"".equals(str))
                list.add(str);
        }

        return list;
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Map<String,String> deleteAngencyPic(@RequestParam("id")String id, @RequestParam("name")String name){
        System.out.println("id = "+id+" name = "+name);
        Map<String,String> map = new HashMap<String,String>();
        Angency angency = angencyService.findById(Long.parseLong(id));
        String[] imageArr = angency.getCertificate().split("&");
        List<String> list = new ArrayList<>();
        for(String str : imageArr){
            str = str.trim();
            if(null != str && !"".equals(str))
                if(!str.equals(name))
                    list.add(str);
        }
        String temPath ="";
        for(String str : list){
            temPath =temPath + str+"&";
        }
        int lenghOfPath = temPath.length();
        angency.setCertificate(temPath.substring(0,lenghOfPath - 1));
        angencyService.updateAngency(angency);
        map.put("res","deletePic");
        return map;
    }

}
