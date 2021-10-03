package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-10-01 20:29
 */
@ApiModel
public class ShopApplyVo {

    @ApiModelProperty(value = "商家名称")
    private String shopName;

    @ApiModelProperty(value = "商家地址")
    private String shopAddress;

    @ApiModelProperty(value = "联系人姓名")
    private String contactPersonName;

    @ApiModelProperty(value = "联系人电话")
    private String contactPersonPhone;

    @ApiModelProperty(value = "营业执照照片url")
    private String fileUrl;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
