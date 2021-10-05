package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-10-04 20:38
 */
@ApiModel
public class MallGoodsComment {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "评价人openId")
    private String openId;

    @ApiModelProperty(value = "评价人头像地址")
    private String headUrl;

    @ApiModelProperty(value = "评价人name")
    private String name;

    @ApiModelProperty(value = "评价星数")
    private int star;

    @ApiModelProperty(value = "评价内容")
    private String content;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "评论时间")
    private String addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
