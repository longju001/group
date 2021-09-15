package com.jinxinkeji.comm.group.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.model.vo.ProjectKeysVo;
import com.jinxinkeji.comm.group.service.IWeChatUserService;
import io.swagger.annotations.*;
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
    @ApiImplicitParam(name = "wechatUser", value = "新增用户数据")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result<String> addUser(@RequestBody WechatUser wechatUser){
        try {
            return weChatUserService.addUser(wechatUser);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("添加新用户异常");
        }
    }



    @Value("${aliyun.oss.file.endpoint}")
    private static String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private static String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private static String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private static String bucketname;

    @Value("${weixinAppID}")
    private static String weixinAppID;
    @Value("${weixinAppSecret}")
    private static String weixinAppSecret;

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
            String token_url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + weixinAppID + "&secret=" +
                    weixinAppSecret + "&js_code=" + code + "&grant_type=authorization_code";
            String result = restTemplate.getForObject(token_url, String.class);
            if(StringUtils.isEmpty(result)){
                result = new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                JSONObject jsonObject = JSON.parseObject(result);
                if("0".equals(jsonObject.getString("errcode"))){
                    String openId = jsonObject.getString("openid");
                    String unionid = jsonObject.getString("unionid");
                    WechatUser user = new WechatUser();
                    user.setOpenId(openId);
                    user.setUnionid(unionid);
                    return weChatUserService.addUser(user);
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
    @PostMapping("/aa.json")
    public Result<String> aa(){
        return Result.failed("添加新用户异常");
    }


}
