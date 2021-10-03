package com.jinxinkeji.comm.group.model.enums;

/**
 * @author changyl
 * @create 2021-10-02 21:34
 */
public enum OrderStatusEnum {

    S0(0, "待付款"),
    S1(1, "已付款"),
    S2(2, "待取货"),
    S3(3, "配送中"),
    S4(4, "已完成"),
    S5(5, "取消清单待退款"),
    S6(6, "已退款订单删除");


    OrderStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    private int code;
    private String value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(Integer code) {
        for (OrderStatusEnum ele : values()) {
            if(ele.getCode() == code) {
                return ele.getValue();
            }
        }
        return null;
    }
}
