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
        System.out.println(productsInfo);

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
        tripTrafficSet.add(tripTraffic);
        tripTrafficBack.setProduct(product);
        product.setTripTraffics(tripTrafficSet);

        //TripPicture
        Set<TripPicture> tripPictureSet = new HashSet<TripPicture>();
        TripPicture tripPicture = new TripPicture();
        tripPicture.setBrief("图片");
        String path = UploadFileController.getDir();
        tripPicture.setPicturePath(path);
        tripPicture.setProduct(product);
        tripPictureSet.add(tripPicture);
        product.setTripPictures(tripPictureSet);

        //TripAccomodation
        Set<TripAccomodation> tripAccomodationSet = new HashSet<TripAccomodation>();
        TripAccomodation tripAccomodation = new TripAccomodation();
        tripAccomodation.setUpdateTime(timestamp);
        tripAccomodation.setIsExpired((byte)0);
        tripAccomodation.setAccomodationType(productsInfo.getHotelname());
        tripAccomodation.setBrief(productsInfo.getHoteldesc());
        tripAccomodation.setProduct(product);
        tripAccomodationSet.add(tripAccomodation);
        product.setTripAccomodations(tripAccomodationSet);


        //TripPrice
        TouristType touristTypeAdult = productsService.findById(1L,TouristType.class);
        TouristType touristTypeChild = productsService.findById(2L,TouristType.class);

        Set<TripPrice> tripPriceSet = new HashSet<TripPrice>();
        TripPrice tripPrice = new TripPrice();
        tripPrice.setIsExpired((byte)0);
        tripPrice.setTouristType(touristTypeAdult);
        tripPrice.setUpdateTime(timestamp);
        tripPrice.setPrice(productsInfo.getAdultprice());
        tripPrice.setProduct(product);
        tripPriceSet.add(tripPrice);

        TripPrice tripPrice2 = new TripPrice();
        tripPrice2.setIsExpired((byte)0);
        tripPrice2.setTouristType(touristTypeChild);
        tripPrice2.setUpdateTime(timestamp);
        tripPrice2.setPrice(productsInfo.getAdultprice());
        tripPrice2.setProduct(product);
        tripPriceSet.add(tripPrice2);

        product.setTripPrices(tripPriceSet);


//        //TripSetoff
//        Set<TripSetoff> tripSetoffSet = new HashSet<TripSetoff>();
//        TripSetoff tripSetoff = new TripSetoff();
//        tripSetoff.setUpdateTime(timestamp);
//        tripSetoff.setAvgRemark(0);
//        tripSetoff.setCommentCount(0);
//        tripSetoff.setPurchaseCount(0);
//        tripSetoff.setTripSetoffDate(new Timestamp(productsInfo.getStartdate()));


        productsService.create(product);



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
