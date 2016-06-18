package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Guide;
import cn.edu.tongji.ranger.model.GuideInfo;
import cn.edu.tongji.ranger.service.AngencyService;
import cn.edu.tongji.ranger.service.GuideService;
import com.sun.xml.internal.ws.encoding.HasEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(
            @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        System.out.println("用户名" + username + "密码" + password);

        Map<String, Object> map = new HashMap<String, Object>();
        Angency angency = null;
        angency = angencyService.findByPhone(username);
        if (angency != null) {
            if (angency.getPassword().equals(password)) {
                map.put("result", "success");
                map.put("angency", angency);
                System.out.println("登录成功");
                getSession().setAttribute("angency", angency);
                return map;
            } else {
                map.put("result", "fail");
                return map;
            }
        } else {
            angency = angencyService.findByEmail(username);
            if (angency != null) {
                if (angency.getPassword().equals(password)) {
                    map.put("result", "success");
                    map.put("angency", angency);
                    System.out.println("登录成功");
                    getSession().setAttribute("angency", angency);
                    return map;
                } else {
                    map.put("result", "fail");
                    return map;
                }
            } else {
                map.put("result", "fail");
                return map;
            }
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> angencyRegister(@RequestBody Angency angency) {

        Map<String, String> map = new HashMap<String, String>();

        angency.setCertificate("");
        System.out.println(angency.getCname());
        List<Angency> list = angencyService.findExistAngency(angency.getCname());
        System.out.println(list);

        if (angencyService.findExistAngency(angency.getCname()).size() == 0) {
            long angency_id = angencyService.create(angency);
            UploadFileController.setDir("");
            System.out.println("可以注册");
            map.put("id", angency_id + "");
        } else {
            System.out.println("has registered");
            map.put("res", "has registered");
            return map;
        }
        map.put("res", "permit");
        System.out.println(angency);

        return map;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public List<Angency> angencyInfos(@RequestParam("id")String id) {
        Angency angency = angencyService.findById(Long.parseLong(id));
        System.out.println(angency);
        List<Angency> angencyList = new ArrayList<Angency>();
        angencyList.add(angency);
        return angencyList;
    }

    @RequestMapping(value = "/detail/{aid}", method = RequestMethod.GET)
    @ResponseBody
    public Angency getAngencyDetail(@PathVariable("aid") Long aid) {
        return angencyService.findById(aid);
    }

    @RequestMapping(value = "/editangency", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateAngencyInfo(@RequestBody Angency angency) {
        Map<String, String> map = new HashMap<String, String>();
        angencyService.updateAngency(angency);
        map.put("res", "succeed");
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

    @RequestMapping(value = "/guideinfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> guideInfo() {
        Map<String, String> mapGuide = new HashMap<String, String>();
        Guide guide = guideService.findById(2L);
        if (guide != null) {
            angencyService.findById(guide.getAngency_id());
            mapGuide.put("name", guide.getName());
            if (guide.isGender()) {
                mapGuide.put("gender", "male");
            } else {
                mapGuide.put("gender", "female");
            }

            mapGuide.put("email", guide.getEmail());
            mapGuide.put("id", guide.getId() + "");
            mapGuide.put("address", guide.getAddress());
            mapGuide.put("phone", guide.getPhone());
            Angency angency = angencyService.findById(guide.getAngency_id());
            mapGuide.put("cname", angency.getName());
            mapGuide.put("res", "ok");
        } else {
            mapGuide.put("res", "error");
        }
        return mapGuide;
    }

    @RequestMapping(value = "/guideList",method = RequestMethod.POST)
    @ResponseBody
    public List<Guide> getGuideList(@RequestParam("id")String id){
        List<Guide> guideList = new ArrayList<>();
        guideList = guideService.findByAngencyID(Long.parseLong(id));
        return guideList;
    }
    @RequestMapping(value = "/editguide", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateGuide(@RequestParam(value = "id") String id,
                                           @RequestParam(value = "name") String name,
                                           @RequestParam(value = "gender") String gender,
                                           @RequestParam(value = "phone") String phone,
                                           @RequestParam(value = "email") String email,
                                           @RequestParam(value = "address") String address,
                                           @RequestParam(value = "cname") String cname,
                                           Model model) {

        Map<String, String> guideMap = new HashMap<String, String>();
        List<Angency> angencyList = angencyService.findExistAngency(cname);
        if (angencyList.size() == 0) {
            guideMap.put("res", "no");
            return guideMap;
        }
        Guide guide = new Guide();
        guide.setName(name);
        if ("male".equals(gender)) {
            guide.setGender(true);
        } else {
            guide.setGender(false);
        }
        guide.setPhone(phone);
        guide.setEmail(email);
        guide.setAddress(address);
        guide.setAngency_id(angencyList.get(0).getId());
        guide.setId(Long.parseLong(id));
        guideService.updateGuide(guide);
        guideMap.put("res", "succeed");
        return guideMap;
    }
    @RequestMapping(value = "/editGuideByAency", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateGuideByAngency(@RequestParam(value = "id") String id,
                                           @RequestParam(value = "name") String name,
                                           @RequestParam(value = "gender") String gender,
                                           @RequestParam(value = "phone") String phone,
                                           @RequestParam(value = "email") String email,
                                           @RequestParam(value = "address") String address,
                                           Model model) {

        Map<String, String> guideMap = new HashMap<String, String>();
        Guide guide = guideService.findById(Long.parseLong(id));
        guide.setName(name);
        guide.setPhone(phone);
        guide.setEmail(email);
        guide.setAddress(address);
        guideService.updateGuide(guide);
        guideMap.put("res", "succeed");
        return guideMap;
    }

    @RequestMapping(value = "/deleteGuideByAency",method = RequestMethod.POST)
    public Map<String,String> deleteGuide(@RequestParam("id")String id){
        Map<String,String> map = new HashMap<>();

        Guide guide = guideService.findById(Long.parseLong(id));
        guideService.delteGuide(guide);
        map.put("res","SUCCEED");
        return  map;
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

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

}