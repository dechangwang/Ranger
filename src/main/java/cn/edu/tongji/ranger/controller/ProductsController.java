package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.*;
import cn.edu.tongji.ranger.service.GuideService;
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

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> releaseProduct(@RequestBody ProductsInfo productsInfo) {  //发布产品
        System.out.println(productsInfo);

        Product product = new Product();
        product.setName(productsInfo.getName());
        product.setSearchContent(productsInfo.getBrief() + productsInfo.getBackway() + productsInfo.getDetail() + productsInfo.getName() + "" +
                productsInfo.getHotelname() + productsInfo.getStartloc().getName() + productsInfo.getSetoffway() + productsInfo.getStartdate() +
                productsInfo.getTag() + productsInfo.getDuration());
        product.setSummary(productsInfo.getDetail());
        product.setDuration(productsInfo.getDuration());
        product.setPostcode(productsInfo.getPostcode());
        product.setPostReceiver(productsInfo.getReceiver());
        product.setPostPhone(productsInfo.getPostphone());
        product.setPostAddress(productsInfo.getPostaddress());

        String angency_id = productsInfo.getAngency_id();
        Angency angency = productsService.findById(Long.parseLong(angency_id), Angency.class);
        product.setSupplier(angency);
        //setoff location
        product.setSetoffLocation(productsInfo.getStartloc());

        Set<TripDestination> locations = new HashSet<TripDestination>();
        if (productsInfo.getDestinations().size() > 0)
        for(Location location : productsInfo.getDestinations()){
            TripDestination td = new TripDestination();
            td.setLocation(location);
            td.setBrief("");
            td.setProduct(product);
            locations.add(td);
        }

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


        //TripTraffic
        Set<TripTraffic> tripTrafficSet = new HashSet<TripTraffic>();
        List<String> trafficList = productsInfo.getTraffics();
        String searchCon = product.getSearchContent();
        if(trafficList.size() > 0){
            for(String methodTraff:trafficList){
                if(methodTraff.equals("1")){
                    searchCon +=" 火车";
                   addTraffic(tripTrafficSet,1L,product);
                }else if(methodTraff.equals("2")){
                    searchCon +=" 飞机";
                    addTraffic(tripTrafficSet,2L,product);
                }else if(methodTraff.equals("3")){
                    searchCon +=" 轮船";
                    addTraffic(tripTrafficSet,3L,product);
                }else if(methodTraff.equals("4")){
                    searchCon +=" 汽车";
                    addTraffic(tripTrafficSet,4L,product);
                }else if(methodTraff.equals("6") && !productsInfo.getOtherway().equals("")){
                    searchCon +=" "+productsInfo.getOtherway();
                    TrafficType trafficType = productsService.findById(6L, TrafficType.class);
                    TripTraffic tripTraffic = new TripTraffic();
                    tripTraffic.setUpdateTime(timestamp);
                    tripTraffic.setIsExpired((byte) 1);
                    tripTraffic.setTrafficType(trafficType);
                    tripTraffic.setBrief(productsInfo.getOtherway());
                    tripTraffic.setProduct(product);
                    tripTrafficSet.add(tripTraffic);
                }
            }
            product.setTripTraffics(tripTrafficSet);
        }

        product.setSearchContent(searchCon);
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

        List<Guide> guideList = guideService.findByAngencyID(Long.parseLong(productsInfo.getAngency_id()));
        Set<TripSetoff> tripSetoffSet = new HashSet<TripSetoff>();
        if(productsInfo.getSetoffdate().size() > 0){
            for(int i = 0;i<productsInfo.getSetoffdate().size();i++){
                TripSetoff tripSetoff = new TripSetoff();
                tripSetoff.setUpdateTime(timestamp);
                tripSetoff.setAvgRemark(0);
                tripSetoff.setCommentCount(0);
                tripSetoff.setPurchaseCount(0);

                for (Guide guide : guideList){
                    if (guide.getName().equals(productsInfo.getGuidesname().get(i))){
                        tripSetoff.setGuide(guide);
                        break;
                    }
                }

                StringTokenizer stringTokenizer = new StringTokenizer(productsInfo.getSetoffdate().get(i), "T");
                String str = stringTokenizer.nextToken() + " " + stringTokenizer.nextToken().substring(0, 10);

                StringTokenizer stringDate = new StringTokenizer(productsInfo.getSetoffdate().get(i), "T");
                String dt = stringDate.nextToken();
                String[] ss = dt.split("-");
                String strContent = product.getSearchContent();
                strContent = strContent + " "+ss[0]+"年"+" "+ss[1]+"月"+" "+ss[2]+"日 ";
                product.setSearchContent(strContent);

                Timestamp setOffTime = Timestamp.valueOf(str);
                tripSetoff.setTripSetoffDate(setOffTime);


                tripSetoff.setProduct(product);
                tripSetoffSet.add(tripSetoff);
            }
        }

        //TripSetoff
        product.setTripSetoffs(tripSetoffSet);

        long id = productsService.create(product);

        Map<String, String> map = new HashMap<String, String>();
        map.put("res", "success");
        map.put("product_id",id+"");
        return map;
    }

    private void addTraffic(Set<TripTraffic> tripTrafficSet,long id,Product product){
        TrafficType trafficType = productsService.findById(id, TrafficType.class);
        TripTraffic tripTraffic = new TripTraffic();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        tripTraffic.setUpdateTime(timestamp);
        tripTraffic.setIsExpired((byte) 1);
        tripTraffic.setTrafficType(trafficType);
        tripTraffic.setBrief("");
        tripTraffic.setProduct(product);
        tripTrafficSet.add(tripTraffic);
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
        List<Timestamp> timestampList = new ArrayList<>();
        for(Iterator iterator = setoffs.iterator();iterator.hasNext();){
            TripSetoff tripSetoff = (TripSetoff) iterator.next();
            timestampList.add(tripSetoff.getTripSetoffDate());
        }

        Timestamp setoff_date = setoffs.iterator().next().getTripSetoffDate();
        map.put("setoff_date",timestampList+"");
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
//        product.getTripSetoffs().iterator().next().setTripSetoffDate(Timestamp.valueOf(setoff_date));
        product.getTripSetoffs().iterator().next().setUpdateTime(new Timestamp(new Date().getTime()));
        productsService.update(product);
        Map<String,String> map = new HashMap<String, String>();
        map.put("res","success");
        return map;
    }

}
