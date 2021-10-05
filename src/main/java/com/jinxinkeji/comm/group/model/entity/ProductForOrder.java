package com.jinxinkeji.comm.group.model.entity;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品货品对象 mall_goods_product
 * 
 * @author cyl
 * @date 2021-09-26
 */
@ApiModel
public class ProductForOrder {

    @ApiModelProperty(value = "货品主键")
    private Long id;

    @ApiModelProperty(value = "商家id")
    private Long shopId;

    @ApiModelProperty(value = "商家名称")
    private String shopName;

    @ApiModelProperty(value = "商品表的商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "货品规格值，采用JSON数组格式")
    private String specifications;

    @ApiModelProperty(value = "货品货品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "货品货品图片")
    private String url;

    @ApiModelProperty(value = "商品数量")
    private Long number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
