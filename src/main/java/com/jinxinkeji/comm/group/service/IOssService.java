package com.jinxinkeji.comm.group.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * OSS上传文件
 * @author changyl
 * @create 2021-08-29 15:35
 */
public interface IOssService {

    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    String uploadFile (MultipartFile file) throws Exception;
}
