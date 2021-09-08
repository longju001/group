package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 同城圈消息评论实体
 * @author changyl
 * @create 2021-09-03 14:59
 */
@ApiModel
public class MessageComment {

    @ApiModelProperty(value = "评论ID")
    private String commentId;
    @ApiModelProperty(value = "所评论的消息ID")
    private String messageId;
    @ApiModelProperty(value = "评论人openId")
    private String openId;
    @ApiModelProperty(value = "评论人头像地址")
    private String headImageUrl;
    @ApiModelProperty(value = "评论人昵称")
    private String nickName;
    @ApiModelProperty(value = "评论内容")
    private String commentText;
    @ApiModelProperty(value = "评论人时间")
    private Date commentDate;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
