package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author changyl
 * @create 2021-09-04 15:36
 */
@ApiModel
public class BatchFileVo {

    @ApiModelProperty(value = "批量保存的文件的id集合")
    private List<String> fileIds;
    @ApiModelProperty(value = "文件所属的同城圈消息")
    private String messageId;

    public List<String> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<String> fileIds) {
        this.fileIds = fileIds;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
