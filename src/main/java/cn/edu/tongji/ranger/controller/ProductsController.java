package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

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
    public Map<String, String> releaseProduct(@RequestBody ProductsInfo productsInfo) {  //发布产品
        Product product = new Product();
        product.setName(productsInfo.getName());
        product.setSummary(productsInfo.getBrief());
        product.setSearchContent(productsInfo.getDetail());
        product.setDuration(productsInfo.getDuration());
        product.setPostcode(productsInfo.getPostcode());
        product.setPostReceiver(productsInfo.getReceiver());
        product.setPostPhone(productsInfo.getPostphone());
        product.setPostAddress(productsInfo.getPostaddress());

        Angency angency = productsService.findById(7L,Angency.class);
        Location location = new Location();
        location.setFatherId(1);
        location.setName(productsInfo.getStartloc());
        //travel angency
        product.setSupplier(angency);
        //setoff location
        product.setSetoffLocation(location);

        TripDestination td = new TripDestination();
        Location lt = productsService.findById(2L,Location.class);
        td.setLocation(lt);
        td.setBrief("");
        td.setProduct(product);
        Set<TripDestination> locations = new HashSet<TripDestination>();
        locations.add(td);
        //destination
        product.setTripDestinations(locations);

        //TripDetail
        Set<TripDetail> tripDetailSet = new HashSet<TripDetail>();
        TripDetail tripDetail = new TripDetail();
        tripDetail.setContent(productsInfo.getDetail());
        tripDetail.setType(productsInfo.getTag());
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        tripDetail.setUpdateTime(timestamp);
        tripDetail.setProduct(product);
        tripDetailSet.add(tripDetail);
        tripDetail.setProduct(product);
        product.setTripDetails(tripDetailSet);

        TrafficType trafficType = new TrafficType();
        trafficType.setType("出发");
        trafficType.setBrief(productsInfo.getSetoffway());


        TrafficType trafficTypeBack = new TrafficType();
        trafficTypeBack.setType("返程");
        trafficTypeBack.setBrief(productsInfo.getBackway());

       //TripTraffic
        Set<TripTraffic> tripTrafficSet = new HashSet<TripTraffic>();
        TripTraffic tripTraffic = new TripTraffic();
        tripTraffic.setUpdateTime(timestamp);
        tripTraffic.setIsExpired((byte)1);
        tripTraffic.setTrafficType(trafficType);
        tripTraffic.setBrief("");
        tripTraffic.setProduct(product);
        tripTrafficSet.add(tripTraffic);

        TripTraffic tripTrafficBack = new TripTraffic();
        tripTrafficBack.setBrief("");
        tripTrafficBack.setUpdateTime(timestamp);
        tripTrafficBack.setIsExpired((byte)1);
        tripTrafficBack.setTrafficType(trafficTypeBack);
        tripTrafficSet.add(tripTrafficBack);
        tripTrafficBack.setProduct(product);
        product.setTripTraffics(tripTrafficSet);

        //

        productsService.create(product);


        System.out.println(productsInfo);
        /* Product product = new Product();
        product.setName("北京三日游");
        product.setSummary("北京三日游");
        product.setDuration(3);
        product.setSearchContent("北京 三日游");
        product.setPostcode("201804");
        product.setPostPhone("12345678");
        product.setPostAddress("SiPing Road");
        product.setPostReceiver("wdchang");
        Angency angency = sp.findById(7L,Angency.class);
        Location location = new Location();
        location.setName("Hunan");
        location.setFatherId(2);
        product.setSupplier(angency);
        product.setSetoffLocation(location);
        TripDestination td = new TripDestination();
        Location lt = sp.findById(2L, Location.class);
        td.setLocation(lt);
        td.setProduct(product);
        td.setBrief("");
        Set<TripDestination> locations = new HashSet<TripDestination>();
        locations.add(td);
        product.setTripDestinations(locations);
        sp.attachDirty(product);*/


        Map<String,String> map = new HashMap<String,String>();
        map.put("res","release product result");
        return map;
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
