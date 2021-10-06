package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-03 21:01
 */
@ApiModel
public class ThumbUpVo {

    @ApiModelProperty(value = "同城消息的ID")
    private long messageId;
    @ApiModelProperty(value = "点赞人的openId")
    private String openId;
    @ApiModelProperty(value = "1：点赞，0取消点赞")
    private int isThumbUp;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getIsThumbUp() {
        return isThumbUp;
    }

    public void setIsThumbUp(int isThumbUp) {
        this.isThumbUp = isThumbUp;
    }
}
