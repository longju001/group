package com.jinxinkeji.comm.group.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinxinkeji.comm.group.model.entity.*;
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
            return Result.failed("查询所有商品类目异常");
        }
    }


    @CrossOrigin
    @PostMapping("/goodsList.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "商品Id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "pageNum", value = "分页查询的页数", required = true, dataType = "long"),
            @ApiImplicitParam(name = "sortType", value = "排序方式， 01:价格升序，02:价格降序, 03:销量升序，04:销量降序", required = true, dataType = "String"),
            @ApiImplicitParam(name = "keywords", value = "搜索关键字", required = true, dataType = "String")
    })
    @ApiOperation(value = "商品列表", notes = "商品列表")
    public Result<IPage<MallGoods>> goodsList(@RequestParam("pageNum") long pageNum,
                                              @RequestParam("categoryId") long categoryId,
                                              @RequestParam("sortType") String sortType,
                                              @RequestParam("keywords") String keywords){
        try {
            return productService.goodsList(pageNum, categoryId, sortType, keywords);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询商品列表异常");
        }
    }

    @CrossOrigin
    @PostMapping("/goodsInfo.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品Id", required = true, dataType = "long")
    })
    @ApiOperation(value = "商品详情", notes = "商品详情")
    public Result<MallGoodsInfo> goodsInfo(@RequestParam("goodsId") long goodsId){
        try {
            return productService.goodsInfo(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增订单异常");
        }
    }

    @CrossOrigin
    @PostMapping("/goodsCommentListFirst.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品Id", required = true, dataType = "long")
    })
    @ApiOperation(value = "初次查询商品评价默认查两条", notes = "初次查询商品评价")
    public Result<List<MallGoodsComment>> goodsCommentListFirst(@RequestParam("goodsId") long goodsId){
        try {
            return productService.goodsCommentListFirst(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("初次查询商品评价异常");
        }
    }

    @CrossOrigin
    @PostMapping("/goodsCommentList.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品Id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "pageNum", value = "分页查询的页数", required = true, dataType = "long")
    })
    @ApiOperation(value = "点击查看更多查询商品评价", notes = "点击查看更多查询商品评价")
    public Result<IPage<MallGoodsComment>> goodsCommentList(@RequestParam("goodsId") long goodsId,
                                                     @RequestParam("pageNum") long pageNum){
        try {
            return productService.goodsCommentList(goodsId, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("点击查看更多查询商品评价异常");
        }
    }

}
