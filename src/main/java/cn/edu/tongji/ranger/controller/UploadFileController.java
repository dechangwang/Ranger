package cn.edu.tongji.ranger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wangdechang on 2016/5/1.
 */

@Controller
@RequestMapping("/files")
public class UploadFileController {
    public static MultipartFile certificate;
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/fileUpload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {

        byte[] bytes;

        if (!file.isEmpty()) {
            bytes = file.getBytes();
            //store file in storage
        }
        certificate = file;
        System.out.println(file.getOriginalFilename());
       // System.out.println(String.format("receive %s from %s", file.getOriginalFilename()));
    }
}
