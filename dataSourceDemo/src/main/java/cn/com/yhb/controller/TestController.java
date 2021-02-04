package cn.com.yhb.controller;

import cn.com.yhb.service.FileUploadService;
import cn.com.yhb.utils.LocUpdateImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("uploadFBX")
    public String uploadFBX(@RequestParam(value = "files", required = false) MultipartFile[] multipartFiles) throws IOException {
        if (multipartFiles.length == 0) {
            return "请上传压缩文件!";
        } else {
            for (MultipartFile multipartFile: multipartFiles) {
                System.out.println(fileUploadService.uploadFBX(multipartFile));
            }
        }
        return "上传成功！";
    }

    @PostMapping("uploadFile")
    public String uploadFile(@RequestParam(value = "files", required = false) MultipartFile[] multipartFiles) {
        if (multipartFiles.length == 0) {
            return "请上传文件!";
        } else {
            for (MultipartFile multipartFile: multipartFiles) {
                System.out.println(fileUploadService.uploadFile(multipartFile));
            }
        }
        return "上传成功！";
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("nginxTest")
    public String nginxTest() {
        return port;
    }

}
