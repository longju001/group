package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-03 21:04
 */
@ApiModel
public class MessageCommentVo {

    @ApiModelProperty(value = "同城消息的ID")
    private long messageId;
    @ApiModelProperty(value = "评论人的openId")
    private String openId;
    @ApiModelProperty(value = "评论内容-删除评论时可不填")
    private String commentText;

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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
