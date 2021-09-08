package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 同城圈消息点赞实体
 * @author changyl
 * @create 2021-09-03 14:59
 */
@ApiModel
public class MessageThumbUp {

    @ApiModelProperty(value = "所点赞的消息ID")
    private String messageId;
    @ApiModelProperty(value = "点赞人openId")
    private String openId;
    @ApiModelProperty(value = "点赞人头像地址")
    private String headImageUrl;
    @ApiModelProperty(value = "点赞人昵称")
    private String nickName;
    @ApiModelProperty(value = "点赞日期")
    private Date thumbUpDate;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getThumbUpDate() {
        return thumbUpDate;
    }

    public void setThumbUpDate(Date thumbUpDate) {
        this.thumbUpDate = thumbUpDate;
    }
}
