package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author changyl
 * @create 2021-08-29 15:34
 */
@RestController
@RequestMapping("/upload")
public class OssController {

    @Autowired
    IOssService ossServiceImpl;

    /*@PostMapping("/uploadimg")
    public String uploadOssFile(MultipartFile file) throws Exception{
        String url =  ossServiceImpl.uploadFile(file);
        return url;
    }*/
}

