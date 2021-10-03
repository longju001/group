package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.ShopApplyVo;
import com.jinxinkeji.comm.group.service.IShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author changyl
 * @create 2021-10-01 20:08
 */
@RestController
@RequestMapping("/shop")
@Api(value = "店铺", tags = "店铺管理相关的接口", description = "店铺管理相关的接口")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @CrossOrigin
    @PostMapping("/shopApply.json")
    @ApiImplicitParam(name = "ShopApplyVo", value = "商家")
    @ApiOperation(value = "申请成为商家", notes = "申请成为商家")
    public Result<String> shopApply(@RequestBody ShopApplyVo shopApplyVo){
        try {
            return shopService.shopApply(shopApplyVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("申请异常");
        }
    }

}
