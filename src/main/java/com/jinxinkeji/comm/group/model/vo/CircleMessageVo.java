package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-03 20:53
 */
@ApiModel
public class CircleMessageVo {
    @ApiModelProperty(value = "发布消息的用户openId")
    private String openId;
    @ApiModelProperty(value = "发布消息的主题")
    private String title;
    @ApiModelProperty(value = "发布消息的内容")
    private String content;
    @ApiModelProperty(value = "发布消息的话题（美食，旅游，房产等）")
    private String themeCode;

    @ApiModelProperty(value = "是否置顶 默认0：不置顶，1：置顶")
    private int isUp;
    @ApiModelProperty(value = "是否优质商家 默认0：不是，1：是")
    private int isHigtQualityMart;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsUp() {
        return isUp;
    }

    public void setIsUp(int isUp) {
        this.isUp = isUp;
    }

    public int getIsHigtQualityMart() {
        return isHigtQualityMart;
    }

    public void setIsHigtQualityMart(int isHigtQualityMart) {
        this.isHigtQualityMart = isHigtQualityMart;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }
}
