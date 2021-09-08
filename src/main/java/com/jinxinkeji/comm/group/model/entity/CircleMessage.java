package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 同城圈信息实体类
 * @author changyl
 * @create 2021-09-03 11:17
 */
@ApiModel
public class CircleMessage {

    @ApiModelProperty(value = "消息ID")
    private String messageId;
    @ApiModelProperty(value = "发消息的人的openId")
    private String openId;
    @ApiModelProperty(value = "发消息的人的头像")
    private String headImageUrl;
    @ApiModelProperty(value = "发消息的人的昵称")
    private String nickName;
    @ApiModelProperty(value = "消息标题")
    private String title;
    @ApiModelProperty(value = "消息内容")
    private String content;
    @ApiModelProperty(value = "发布时间")
    private Date publishDate;

    @ApiModelProperty(value = "信息类别（美食，旅游，房产等）")
    private String themeCode;
    @ApiModelProperty(value = "是否置顶")
    private int isUp;
    @ApiModelProperty(value = "是否优质商家")
    private int isHigtQualityMart;

    @ApiModelProperty(value = "同城圈消息文件列表")
    private List<MessageFile> fileList;
    @ApiModelProperty(value = "同城圈消息评论列表")
    private List<MessageComment> commentList;
    @ApiModelProperty(value = "同城圈点赞消息列表")
    private List<MessageThumbUp> thumbUpList;

    public List<MessageFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<MessageFile> fileList) {
        this.fileList = fileList;
    }

    public List<MessageComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<MessageComment> commentList) {
        this.commentList = commentList;
    }

    public List<MessageThumbUp> getThumbUpList() {
        return thumbUpList;
    }

    public void setThumbUpList(List<MessageThumbUp> thumbUpList) {
        this.thumbUpList = thumbUpList;
    }

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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
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
}
