package com.jinxinkeji.comm.group.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.jinxinkeji.comm.group.oss.AliyunOSSClientUtil;
import com.jinxinkeji.comm.group.service.IOssService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Calendar;

/**
 * @author changyl
 * @create 2021-08-29 15:37
 */
@Service
public class OssServiceImpl implements IOssService {

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        //读取工具类的数据
        /*String endpoint = AliyunOSSClientUtil.;
        String accessKeyId = AliyunOSSClientUtil.ACCESS_KEY_ID;
        String accessKeySecret = AliyunOSSClientUtil.ACCESS_KEY_SECRET;
        String bucketName = AliyunOSSClientUtil.BUCKET_NAME;
        //连接oss客户端
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流
        InputStream inputStream = file.getInputStream();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        //自己看情况
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        //根据时间拼接url
        String url = year+"/"+month+"-"+date+"/"+file.getOriginalFilename();
        //上传
        ossClient.putObject(bucketName, url, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "https://"+bucketName+"."+endpoint+"/"+url;*/
        return "";

    }


}
