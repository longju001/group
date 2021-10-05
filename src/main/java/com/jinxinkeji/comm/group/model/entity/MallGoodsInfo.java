package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-04 20:47
 */
@ApiModel
public class MallGoodsInfo extends MallGoods{

    @ApiModelProperty(value = "商品下面的货品")
    private List<ProductForOrder> productList;

    public List<ProductForOrder> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductForOrder> productList) {
        this.productList = productList;
    }
}
