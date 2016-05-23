package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Orderform;
import cn.edu.tongji.ranger.service.CreateOrderformService;
import cn.edu.tongji.ranger.utils.SearchCondition;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daidongyang on 5/24/16.
 */

@Controller
@RequestMapping("/api/createOrderform")
public class CreateOrderformController {

    @Autowired
    private CreateOrderformService createOrderformService;

    public static class OrderformData{

        @JsonProperty("setoff_id")
        private long setoffId;

        @JsonProperty("booker")
        private String booker;

        @JsonProperty("booker_phone")
        private String bookerPhone;

        @JsonProperty("booker_address")
        private String bookerAddress;

        @JsonProperty("angency_id")
        private long angencyId;

        public long getSetoffId() {
            return setoffId;
        }

        public void setSetoffId(long setoffId) {
            this.setoffId = setoffId;
        }

        public String getBooker() {
            return booker;
        }

        public void setBooker(String booker) {
            this.booker = booker;
        }

        public String getBookerPhone() {
            return bookerPhone;
        }

        public void setBookerPhone(String bookerPhone) {
            this.bookerPhone = bookerPhone;
        }

        public String getBookerAddress() {
            return bookerAddress;
        }

        public void setBookerAddress(String bookerAddress) {
            this.bookerAddress = bookerAddress;
        }

        public long getAngencyId() {
            return angencyId;
        }

        public void setAngencyId(long angencyId) {
            this.angencyId = angencyId;
        }

        @Override
        public String toString() {
            return "OrderformData{" +
                    "setoffId=" + setoffId +
                    ", booker='" + booker + '\'' +
                    ", bookerPhone='" + bookerPhone + '\'' +
                    ", bookerAddress='" + bookerAddress + '\'' +
                    ", angencyId=" + angencyId +
                    '}';
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> test(@RequestBody CreateOrderformController.OrderformData orderformData){
        System.out.println(orderformData);
        Map<String,String> map = new HashMap<String, String>();
        try{
            Orderform orderform = new Orderform();
            orderform.setBooker(orderformData.getBooker());
            orderform.setBookerAddress(orderformData.getBookerAddress());
            orderform.setBookerPhone(orderformData.getBookerPhone());
            orderform.setBookTime(new Timestamp(new Date().getTime()));
            orderform.setBuyerId(orderformData.getAngencyId());
            orderform.setComment("");
            orderform.setConfirmListBuyer("documents\\default.pdf");
            orderform.setConfirmListSupplier("documents\\default.pdf");
            orderform.setConfirmTime(new Timestamp(new Date().getTime()));
            orderform.setContractBuyer("documents\\default.pdf");
            orderform.setContractSupplier("documents\\default.pdf");
            orderform.setCost(0);
            orderform.setDeposit(0);
            orderform.setInvoice("documents\\default.pdf");
            orderform.setRemark(0);
            orderform.setState(1);
            orderform.setTripNotice("documents\\default.pdf");
            orderform.setTripSetoffId(orderformData.getSetoffId());
            System.out.println(orderform);
            createOrderformService.createOrderform(orderform);

            map.put("res","succeed");
            return map;
        }catch(RuntimeException re){
            re.printStackTrace();
            map.put("res", "failed");
            return null;
        }

    }
}
