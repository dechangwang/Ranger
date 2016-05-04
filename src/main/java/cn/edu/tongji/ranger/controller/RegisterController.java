package cn.edu.tongji.ranger.controller;
import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.service.AngencyService;
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
    @RequestMapping(value = "register",method = RequestMethod.POST )
    @ResponseBody
    public Map<String,String> angencyRegister(@RequestBody Angency angency){

        Map<String,String> map = new HashMap<String,String>();
        String fileDir = UploadFileController.getDir();
        if(fileDir != null || !"".equals(fileDir)){
            angency.setCertificate(fileDir);
            System.out.println(angency.getCname());
            List<Angency> list = angencyService.findExistAngency(angency.getCname());
            System.out.println(list);

            if(angencyService.findExistAngency(angency.getCname()).size() == 0){
                angencyService.create(angency);
            }else {
                System.out.println("已经注册");
                map.put("error","已注册");
                return map;
            }

        }
        System.out.println(angency);
        map.put("succ","SUCCEED");
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