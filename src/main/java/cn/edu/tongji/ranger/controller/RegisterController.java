package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.encryption.Keys;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.model.Business;
import cn.edu.tongji.ranger.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdechang on 2016/4/26.
 */
@Controller
@RequestMapping("/angency")
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "register",method = RequestMethod.POST )
    @ResponseBody
    public Map<String,String> angencyRegister(@RequestBody Business business){
//        String brief = angency.getBrief();
//        String lincensePicture = angency.getLincensePicture();
//        System.out.println("brief content ->"+brief);
//        System.out.println("licence ->"+lincensePicture);
//        System.out.println(angency);
        System.out.println(business);
        MultipartFile file = UploadFileController.certificate;
        System.out.println(file.getOriginalFilename());

        Map<String,String> map = new HashMap<String,String>();
        map.put("succ","SUCCEED");
        return map;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadPicture(@RequestParam(value = "certificate") MultipartFile certificate,Model nodel){
        System.out.println(certificate.getOriginalFilename());
        return "http://localhost:8080/Ranger/#/home";
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
