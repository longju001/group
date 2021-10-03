package com.jinxinkeji.comm.group.mapper;

import com.jinxinkeji.comm.group.model.entity.CreateOrder;
import com.jinxinkeji.comm.group.model.entity.OrderInfo;
import com.jinxinkeji.comm.group.model.entity.ProductForOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-02 20:16
 */
@Mapper
public interface OrderMapper {

    OrderInfo selectMallOrderById(String orderId);

    List<ProductForOrder> getProductListByIds(List productIdList);

    void insertMallOrder(CreateOrder co);

    void orderPay(String orderId, String payId);
}
