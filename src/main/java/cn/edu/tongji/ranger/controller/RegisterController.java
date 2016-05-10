package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Guide;
import cn.edu.tongji.ranger.model.GuideInfo;
import cn.edu.tongji.ranger.service.AngencyService;
import cn.edu.tongji.ranger.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdechang on 2016/4/26.
 */
@Controller
@RequestMapping("/angency")
public class RegisterController {
    @Autowired
    private AngencyService angencyService;

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> angencyRegister(@RequestBody Angency angency) {
//    public Map<String,String> angencyRegister(@RequestBody Angency angency){

        Map<String, String> map = new HashMap<String, String>();
        String fileDir = UploadFileController.getDir();
        if (fileDir != null || !"".equals(fileDir)) {
            angency.setCertificate(fileDir);
            System.out.println(angency.getCname());
            List<Angency> list = angencyService.findExistAngency(angency.getCname());
            System.out.println(list);

            if (angencyService.findExistAngency(angency.getCname()).size() == 0) {
                angencyService.create(angency);
                UploadFileController.setDir("");
                System.out.println("可以注册");
            } else {
                System.out.println("has registered");
                map.put("res", "has registered");
                return map;
            }
            map.put("res", "registered successfully");
        } else {
            map.put("res", "no certificate picture ");
        }
        System.out.println(angency);

        return map;
    }

    @RequestMapping(value = "/guideregister", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> guideRegister(@RequestBody GuideInfo guideInfo) {
        Map<String, String> map = new HashMap<String, String>();
        List<Angency> list = angencyService.findExistAngency(guideInfo.getCname());
        if (list.size() == 0) {
            map.put("res", "the company doesn't exist");
            return map;
        }
        Guide guide = new Guide();
        guide.setName(guideInfo.getName());
        if ("male".equals(guideInfo.getGender())) {
            guide.setGender(true);
        } else {
            guide.setGender(false);
        }
        guide.setPhone(guideInfo.getPhone());
        guide.setEmail(guideInfo.getEmail());
        guide.setAddress(guideInfo.getAddress());
        guide.setAngency_id(list.get(0).getId());
        guideService.create(guide);
        System.out.println(guideInfo);

        map.put("res", "succeed");
        return map;
    }
   /* @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String angencyRegister(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "type") String type,
                                  @RequestParam(value = "number") String registerBrief,
                                  @RequestParam(value = "phone") String phone,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "address") String address,
                                  @RequestParam(value = "certificate") MultipartFile certificate,
                                  @RequestParam(value = "brief") String brief, Model model) {
        System.out.println(certificate.getOriginalFilename());
        try {
            String encodePass = Keys.EncodeAES(password,Keys.key);
            Angency angency = new Angency(1, name, type, registerBrief, phone, email, address, certificate.getOriginalFilename(), 0, brief, encodePass);
            accountService.create(angency);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }*/
}