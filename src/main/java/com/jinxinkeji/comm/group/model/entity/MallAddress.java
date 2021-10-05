package com.jinxinkeji.comm.group.model.entity;

import com.jinxinkeji.comm.group.model.vo.AddressVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-10-05 11:56
 */
@ApiModel
public class MallAddress extends AddressVo {

    @ApiModelProperty(value = "用户openId，前端不用传递")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
