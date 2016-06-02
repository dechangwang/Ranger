package cn.edu.tongji.ranger.controller;

import cn.edu.tongji.ranger.model.Angency;
import cn.edu.tongji.ranger.service.AngencyService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdechang on 2016/5/1.
 */

@Controller
@RequestMapping("/files")
public class UploadFileController {
    @Autowired
    private AngencyService angencyService;
    public static MultipartFile certificate;

    private static String dir;
    private static byte[] bytes;
    private boolean hasUpload = false;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/fileUpload")
    public void upload(@RequestParam("file") MultipartFile file,
                                     @RequestParam("id") String id, HttpServletRequest request) throws IOException {
        Angency angency = angencyService.findById(Long.parseLong(id));
        Map<String,String> map = new HashMap<>();
        map.put("res","");
                System.out.println("id -> " + id);
        String path = "/images";
        ServletContext sc = request.getSession().getServletContext();
        dir = sc.getRealPath(path);
        System.out.println("dir - " + dir);

        if (!file.isEmpty()) {
            bytes = file.getBytes();
            //store file in storage
            try {
                FileUtils.writeByteArrayToFile(new File(dir, id + "-" + file.getOriginalFilename()), bytes);
                dir = "images" + File.separator + id + "-" + file.getOriginalFilename();
                angency.setCertificate(dir);
                angencyService.updateAngency(angency);
                map.put("res","succeed");
                hasUpload = true;
                //FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/web/images/", System.currentTimeMillis() + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        certificate = file;
        System.out.println(file.getOriginalFilename());
       // return map;
    }

    public boolean isHasUpload() {
        return hasUpload;
    }

    public static String getDir() {
        return dir + "";
    }

    public static void setDir(String dir) {
        UploadFileController.dir = dir;
    }

    public static void uploadFile() throws IOException {
        if (!certificate.isEmpty()) {
            bytes = certificate.getBytes();
            //store file in storage
            try {
                String path = "/web/images/";

                // String dir = sc.getRealPath(path);
                FileUtils.writeByteArrayToFile(new File(dir, certificate.getOriginalFilename()), bytes);
                System.out.println("dir ->" + dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
