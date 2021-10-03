package com.jinxinkeji.comm.group.model.entity;

import com.jinxinkeji.comm.group.model.vo.CreateOrderVo;
import java.util.Date;

/**
 * @author changyl
 * @create 2021-10-02 22:06
 */
public class CreateOrder extends CreateOrderVo {

    private String userId;

    private String orderSn;

    private Integer orderStatus;

    private Date addTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
