package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.model.entity.MallAddress;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.model.vo.AddressVo;
import com.jinxinkeji.comm.group.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-05 10:02
 */
@RestController
@RequestMapping("/address")
@Api(value = "商品", tags = "商品相关的接口", description = "商品相关的接口")
public class MallAddressController {

    @Autowired
    private IProductService productService;

    @CrossOrigin
    @PostMapping("/list.json")
    @ApiOperation(value = "查询我的收货地址", notes = "查询我的收货地址")
    public Result<List<MallAddress>> addressList(){
        try {
            WechatUser user = UserThreadLocal.getUser();
            return productService.addressList(user.getOpenId());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询我的收货地址异常");
        }
    }

    @CrossOrigin
    @PostMapping("/addAddress.json")
    @ApiImplicitParam(name = "AddressVo", value = "地址入参")
    @ApiOperation(value = "新增收货地址", notes = "新增收货地址")
    public Result<String> addAddress(@RequestBody AddressVo vo){
        try {
            WechatUser user = UserThreadLocal.getUser();
            vo.setOpenId(user.getOpenId());
            return productService.addAddress(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增收货地址异常");
        }
    }

    @CrossOrigin
    @PostMapping("/removeAddress.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressId", value = "地址Id", required = true, dataType = "long")
    })
    @ApiOperation(value = "删除收货地址", notes = "删除收货地址")
    public Result<String> removeAddress(long addressId){
        try {
            return productService.removeAddress(addressId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("删除收货地址异常");
        }
    }

    @CrossOrigin
    @PostMapping("/setDefault.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressId", value = "地址Id", required = true, dataType = "long")
    })
    @ApiOperation(value = "设置为默认地址", notes = "设置为默认地址")
    public Result<String> setDefault(long addressId){
        try {
            return productService.setDefault(addressId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("删除收货地址异常");
        }
    }

    @CrossOrigin
    @PostMapping("/setNotDefault.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressId", value = "地址Id", required = true, dataType = "long")
    })
    @ApiOperation(value = "设置非默认地址", notes = "设置非默认地址")
    public Result<String> setNotDefault(long addressId){
        try {
            return productService.setNotDefault(addressId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("设置非默认地址异常");
        }
    }

}
