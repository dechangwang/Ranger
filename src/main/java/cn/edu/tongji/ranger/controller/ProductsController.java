package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseProduct(@RequestBody ProductsInfo productsInfo) {  //发布产品
        System.out.println(productsInfo);

        Product product = new Product();
        product.setName(productsInfo.getName());
        product.setSearchContent(productsInfo.getBrief() + productsInfo.getBackway() + productsInfo.getDetail() + productsInfo.getName() + "" +
                productsInfo.getHotelname() + productsInfo.getStartloc() + productsInfo.getSetoffway() + productsInfo.getStartdate() +
                productsInfo.getTag() + productsInfo.getDuration());
        product.setSummary(productsInfo.getDetail());
        product.setDuration(productsInfo.getDuration());
        product.setPostcode(productsInfo.getPostcode());
        product.setPostReceiver(productsInfo.getReceiver());
        product.setPostPhone(productsInfo.getPostphone());
        product.setPostAddress(productsInfo.getPostaddress());

        Angency angency = productsService.findById(9L, Angency.class);
        Location location = new Location();
        location.setFatherId(-1);
        location.setName(productsInfo.getStartloc());
        //travel angency
        product.setSupplier(angency);
        //setoff location
        product.setSetoffLocation(location);

        TripDestination td = new TripDestination();
        Location lt = productsService.findById(2L, Location.class);
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

       /* TrafficType trafficType = new TrafficType();
        trafficType.setType("出发");
        trafficType.setBrief(productsInfo.getSetoffway());


        TrafficType trafficTypeBack = new TrafficType();
        trafficTypeBack.setType("返程");
        trafficTypeBack.setBrief(productsInfo.getBackway());*/
        TrafficType trafficType = productsService.findById(2L, TrafficType.class);

        TrafficType trafficTypeBack = productsService.findById(1L,TrafficType.class);

        //TripTraffic
        Set<TripTraffic> tripTrafficSet = new HashSet<TripTraffic>();
        TripTraffic tripTraffic = new TripTraffic();
        tripTraffic.setUpdateTime(timestamp);
        tripTraffic.setIsExpired((byte) 1);
        tripTraffic.setTrafficType(trafficType);
        tripTraffic.setBrief("");
        tripTraffic.setProduct(product);
        tripTrafficSet.add(tripTraffic);

        TripTraffic tripTrafficBack = new TripTraffic();
        tripTrafficBack.setBrief("");
        tripTrafficBack.setUpdateTime(timestamp);
        tripTrafficBack.setIsExpired((byte) 1);
        tripTrafficBack.setTrafficType(trafficTypeBack);
        tripTrafficSet.add(tripTrafficBack);
        tripTrafficBack.setProduct(product);
        product.setTripTraffics(tripTrafficSet);

        //TripPicture
       /* Set<TripPicture> tripPictureSet = new HashSet<TripPicture>();
        TripPicture tripPicture = new TripPicture();
        tripPicture.setBrief("图片");
        String path = UploadFileController.getDir();
        tripPicture.setPicturePath(path);
        tripPicture.setProduct(product);
        tripPictureSet.add(tripPicture);
        product.setTripPictures(tripPictureSet);*/

        //TripAccomodation
        Set<TripAccomodation> tripAccomodationSet = new HashSet<TripAccomodation>();
        TripAccomodation tripAccomodation = new TripAccomodation();
        tripAccomodation.setUpdateTime(timestamp);
        tripAccomodation.setIsExpired((byte) 0);
        tripAccomodation.setAccomodationType(productsInfo.getHotelname());
        tripAccomodation.setBrief(productsInfo.getHoteldesc());
        tripAccomodation.setProduct(product);
        tripAccomodationSet.add(tripAccomodation);
        product.setTripAccomodations(tripAccomodationSet);


        //TripPrice
        TouristType touristTypeAdult = productsService.findById(1L, TouristType.class);
        TouristType touristTypeChild = productsService.findById(2L, TouristType.class);

        Set<TripPrice> tripPriceSet = new HashSet<TripPrice>();
        TripPrice tripPrice = new TripPrice();
        tripPrice.setIsExpired((byte) 0);
        tripPrice.setTouristType(touristTypeAdult);
        tripPrice.setUpdateTime(timestamp);
        tripPrice.setPrice(productsInfo.getAdultprice());
        tripPrice.setProduct(product);
        tripPriceSet.add(tripPrice);

        TripPrice tripPrice2 = new TripPrice();
        tripPrice2.setIsExpired((byte) 0);
        tripPrice2.setTouristType(touristTypeChild);
        tripPrice2.setUpdateTime(timestamp);
        tripPrice2.setPrice(productsInfo.getChildprice());
        tripPrice2.setProduct(product);
        tripPriceSet.add(tripPrice2);

        product.setTripPrices(tripPriceSet);

        Guide guide = productsService.findById(2L, Guide.class);
        //TripSetoff
        Set<TripSetoff> tripSetoffSet = new HashSet<TripSetoff>();
        TripSetoff tripSetoff = new TripSetoff();
        tripSetoff.setUpdateTime(timestamp);
        tripSetoff.setAvgRemark(0);
        tripSetoff.setCommentCount(0);
        tripSetoff.setPurchaseCount(0);
        StringTokenizer stringTokenizer = new StringTokenizer(productsInfo.getStartdate(), "T");
        String str = stringTokenizer.nextToken() + " " + stringTokenizer.nextToken().substring(0, 10);
        Timestamp setOffTime = Timestamp.valueOf(str);
        tripSetoff.setTripSetoffDate(setOffTime);
        tripSetoffSet.add(tripSetoff);
        tripSetoff.setGuide(guide);
        tripSetoff.setProduct(product);
        product.setTripSetoffs(tripSetoffSet);

        long id = productsService.create(product);

        Map<String, String> map = new HashMap<String, String>();
        map.put("res", "success");
        map.put("product_id",id+"");
        return map;
    }

    @RequestMapping(value = "/lists", method = RequestMethod.POST)
    @ResponseBody
    public List<MyProduct> productsList(@RequestParam(value = "id")String id) {
        System.out.println("id = "+id);
        List<MyProduct> productList = productsService.findBySupplierId(Long.parseLong(id));
        System.out.println(productList);

        return productList;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> productInfo(@RequestParam(value = "id") String product_id){
        System.out.println(product_id);
        Long id = Long.parseLong(product_id);
        Product product = productsService.findById(id,Product.class);
        System.out.println(product.getName());
        System.out.println(product.getDuration());
        System.out.println(product.getPostAddress());
        System.out.println(product.getTripAccomodations());

        Map<String,String> map = new HashMap<String, String>();
        map.put("id",product_id);
        map.put("name",product.getName());
        map.put("summary",product.getSummary());
        map.put("duration",product.getDuration()+"");
        Set<TripSetoff> setoffs = product.getTripSetoffs();
        Timestamp setoff_date = setoffs.iterator().next().getTripSetoffDate();
        map.put("setoff_date",setoff_date+"");
        map.put("postcode",product.getPostcode());
        map.put("post_receiver",product.getPostReceiver());
        map.put("post_address",product.getPostAddress());
        map.put("post_phone",product.getPostPhone());
        return map;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> productEdit(@RequestParam(value = "id") String id,
                                          @RequestParam(value = "name") String name,
                                          @RequestParam(value = "summary")String summary,
                                          @RequestParam(value = "duration")String duration,
                                          @RequestParam(value = "setoff_date")String setoff_date,
                                          @RequestParam(value = "postcode")String postcode,
                                          @RequestParam(value = "post_receiver")String post_receiver,
                                          @RequestParam(value = "post_address")String post_address,
                                          @RequestParam(value = "post_phone")String post_phone){
        Long productId = Long.parseLong(id);
        Product product = productsService.findById(productId,Product.class);
        product.setName(name);
        product.setSummary(summary);
        product.setDuration(Integer.parseInt(duration));
        product.setPostcode(postcode);
        product.setPostAddress(post_address);
        product.setPostReceiver(post_receiver);
        product.setPostPhone(post_phone);
        product.getTripSetoffs().iterator().next().setTripSetoffDate(Timestamp.valueOf(setoff_date));
        product.getTripSetoffs().iterator().next().setUpdateTime(new Timestamp(new Date().getTime()));
        productsService.update(product);
        Map<String,String> map = new HashMap<String, String>();
        map.put("res","success");
        return map;
    }

}
