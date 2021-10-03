package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.model.entity.Category;
import com.jinxinkeji.comm.group.model.entity.Result;
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
 * @create 2021-10-01 20:31
 */
@RestController
@RequestMapping("/product")
@Api(value = "商品", tags = "商品相关的接口", description = "商品相关的接口")
public class ProductController {

    @Autowired
    private IProductService productService;

    @CrossOrigin
    @PostMapping("/categories.json")
    @ApiOperation(value = "所有商品类目", notes = "所有商品类目")
    public Result<List<Category>> categories(){
        try {
            return productService.categories();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增订单异常");
        }
    }


    @CrossOrigin
    @PostMapping("/goodsList.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryCode", value = "商品类目码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "分页查询的页数", required = true, dataType = "long")
    })
    @ApiOperation(value = "商品列表", notes = "商品列表")
    public Result<String> goodsList(@RequestParam("pageNum") long pageNum,
                                    @RequestParam("categoryCode") String categoryCode){
        try {
            return productService.goodsList(pageNum, categoryCode);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增订单异常");
        }
    }

}
