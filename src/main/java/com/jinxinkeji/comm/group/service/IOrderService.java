package com.jinxinkeji.comm.group.service;

import com.jinxinkeji.comm.group.model.entity.CreateOrder;
import com.jinxinkeji.comm.group.model.entity.OrderInfo;
import com.jinxinkeji.comm.group.model.entity.Result;

/**
 * @author changyl
 * @create 2021-10-02 13:22
 */
public interface IOrderService {
    Result<OrderInfo> orderInfo(String orderId);

    Result<String> createOrder(CreateOrder co);

    Result<String> orderPay(String orderId, String payId);
}
