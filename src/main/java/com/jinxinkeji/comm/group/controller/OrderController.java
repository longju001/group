package com.jinxinkeji.comm.group.controller;

import com.jinxinkeji.comm.group.model.entity.CreateOrder;
import com.jinxinkeji.comm.group.model.entity.OrderInfo;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.CreateOrderVo;
import com.jinxinkeji.comm.group.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author changyl
 * @create 2021-10-01 20:32
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单", tags = "订单相关的接口", description = "订单相关的接口")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @CrossOrigin
    @PostMapping("/orderInfo.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "String")
    })
    @ApiOperation(value = "订单详情", notes = "订单详情")
    public Result<OrderInfo> orderInfo(String orderId){
        try {
            return orderService.orderInfo(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("申请异常");
        }
    }

    //生成订单（待付款）
    @CrossOrigin
    @PostMapping("/createOrder.json")
    @ApiImplicitParam(name = "CreateOrderVo", value = "新增订单参数")
    @ApiOperation(value = "新增订单", notes = "新增订单")
    public Result<String> createOrder(@RequestBody CreateOrderVo vo){
        try {
            CreateOrder co = new CreateOrder();
            BeanUtils.copyProperties(vo, co);
            return orderService.createOrder(co);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增订单异常");
        }
    }

    //商家接收订单待取货（付款）
    @CrossOrigin
    @PostMapping("/orderPaycallBack.json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "payId", value = "微信支付Id", required = true, dataType = "String")
    })
    @ApiOperation(value = "订单支付成功", notes = "订单支付")
    public Result<String> orderPaycallBack(@RequestParam("orderId") String orderId,
                                   @RequestParam("payId") String payId){
        try {
            return orderService.orderPay(orderId, payId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("新增订单异常");
        }
    }
    //取货后配送订单
    //用户收货（已完成）

}
