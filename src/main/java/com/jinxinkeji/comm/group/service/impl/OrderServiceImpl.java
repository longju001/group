package com.jinxinkeji.comm.group.service.impl;

import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.mapper.OrderMapper;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.enums.OrderStatusEnum;
import com.jinxinkeji.comm.group.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author changyl
 * @create 2021-10-02 20:03
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result<OrderInfo> orderInfo(String orderId) {
        if(StringUtils.isEmpty(orderId)){
            return Result.failed("订单id为空");
        }
        OrderInfo o = orderMapper.selectMallOrderById(orderId);
        if(null == o){
            return Result.failed("订单不存在");
        }
        String productIds = o.getProductIds();
        List<ProductForOrder> productList = new ArrayList<>();
        if(!StringUtils.isEmpty(productIds)){
            productList = orderMapper.getProductListByIds(Arrays.asList(productIds.split(",")));
            o.setProductList(productList);
        }
        o.setOrderStatusName(OrderStatusEnum.getValue(o.getOrderStatus()));
        return Result.success("查询订单成功", o);
    }

    @Override
    public Result<String> createOrder(CreateOrder co) {
        WechatUser user = UserThreadLocal.getUser();
        co.setUserId(user.getOpenId());
        co.setOrderSn(getOrderCode());
        co.setOrderStatus(OrderStatusEnum.S0.getCode());
        co.setAddTime(new Date());
        orderMapper.insertMallOrder(co);
        return Result.success("新增订单完成", null);
    }

    @Override
    public Result<String> orderPay(String orderId, String payId) {
        orderMapper.orderPay(orderId, payId);
        return Result.success("回调成功", null);
    }

    private synchronized String getOrderCode() {
        return String.valueOf(System.currentTimeMillis());
    }


}
