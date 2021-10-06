package com.jinxinkeji.comm.group.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.model.vo.ProjectKeysVo;
import com.jinxinkeji.comm.group.service.IWeChatUserService;
import io.swagger.annotations.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author changyl
 * @create 2021-09-02 14:41
 */
@RestController
@RequestMapping("/user")
@Api(value = "小程序微信用户", tags = "用户管理相关的接口", description = "用户管理相关的接口")
public class WeChatUserController {

    @Autowired
    private IWeChatUserService weChatUserService;

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin
    @PostMapping("/addUser.json")
    @ApiImplicitParam(name = "WechatUser", value = "新增用户数据")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result<String> addUser(@RequestBody WechatUser wechatUser){
        try {
            WechatUser user = UserThreadLocal.getUser();
            wechatUser.setOpenId(user.getOpenId());
            return weChatUserService.addUser(wechatUser);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("添加新用户异常");
        }
    }



    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;

    @Value("${weixinAppID}")
    private String weixinAppID;
    @Value("${weixinAppSecret}")
    private String weixinAppSecret;

    /**
     * 登陆接口
     */
    @GetMapping("/wxlogin")
    @ApiOperation(value = "小程序登录", notes = "小程序登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "", required = true, dataType = "String")
    })
    public Result<String> wxlogin(String code) {
        try {
            //微信登录
            String token_url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + weixinAppID + "&secret=" +
                    weixinAppSecret + "&js_code=" + code + "&grant_type=authorization_code";
            String result = restTemplate.getForObject(token_url, String.class);
            //result = "{\"session_key\":\"1DQHsEbcE0r1T6snVu9qIg==\",\"openid\":\"o7uR95B-YGKAQgretm1aiqZM3l9k\"}";
            if(!StringUtils.isEmpty(result)){
                result = new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                JSONObject jsonObject = JSON.parseObject(result);
                if(jsonObject.containsKey("openid")){
                    String openId = jsonObject.getString("openid");
                    WechatUser user = new WechatUser();
                    user.setOpenId(openId);
                    return weChatUserService.memoryUser(user);
                }
            }
            return Result.failed("登录异常");
        } catch (Exception e){
            e.printStackTrace();
            return Result.failed("登录异常");
        }
    }


    //todo 获取appId和secret
    /**
     * 小程序主要配置
     */
    @GetMapping("/proConfig")
    @ApiOperation(value = "小程序主要配置", notes = "小程序主要配置")
    public Result<String> proConfig() {
        try {
            ProjectKeysVo keysVo = new ProjectKeysVo();
            keysVo.setOssbucketname(bucketname);
            keysVo.setOssendpoint(endpoint);
            keysVo.setOsskeyid(keyId);
            keysVo.setOsskeysecret(keysecret);
            keysVo.setWeixinAppID(weixinAppID);
            keysVo.setWeixinAppSecret(weixinAppSecret);
            return Result.success("", "keysVo");
        } catch (Exception e){
            e.printStackTrace();
            return Result.success("查询异常", null);
        }
    }


    @CrossOrigin
    @PostMapping("/addTuan.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "联系电话", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "联系人姓名", required = true, dataType = "String")
    })
    @ApiOperation(value = "申请成为团长", notes = "申请成为团长")
    public Result<String> addTuan(String phone, String name){
        try {
            return weChatUserService.addTuan(phone, name);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("申请异常");
        }
    }


}
