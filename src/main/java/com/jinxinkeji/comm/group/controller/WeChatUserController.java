package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.service.IWeChatUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
