package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 同城圈消息文件实体
 * @author changyl
 * @create 2021-09-03 14:58
 */
@ApiModel
public class MessageFile {

    @ApiModelProperty(value = "点赞数据ID")
    private String fileId;
    @ApiModelProperty(value = "文件所属的同城圈消息")
    private long messageId;
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
