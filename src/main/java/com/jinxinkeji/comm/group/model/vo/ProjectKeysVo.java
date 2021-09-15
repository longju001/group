package com.jinxinkeji.comm.group.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-08 19:31
 */
@ApiModel
public class ProjectKeysVo {

    @ApiModelProperty(value="用户名",example="LTAI5tDip2xm2TRZGwTswxpn")
    private String osskeyid;
    @ApiModelProperty(value="用户名",example="liHRVykfvH5v1Qo80dB17bqteaorNB")
    private String osskeysecret;
    @ApiModelProperty(value="用户名",example="group-test01")
    private String ossbucketname;
    @ApiModelProperty(value="用户名",example="oss-cn-beijing.aliyuncs.com")
    private String ossendpoint;
    @ApiModelProperty(value="用户名",example="wxc13ee1695afa235e")
    private String weixinAppID;
    @ApiModelProperty(value="用户名",example="2b1f903b7c99b7ad81d9eaa754862596")
    private String weixinAppSecret;

    public String getOsskeyid() {
        return osskeyid;
    }

    public void setOsskeyid(String osskeyid) {
        this.osskeyid = osskeyid;
    }

    public String getOsskeysecret() {
        return osskeysecret;
    }

    public void setOsskeysecret(String osskeysecret) {
        this.osskeysecret = osskeysecret;
    }

    public String getOssbucketname() {
        return ossbucketname;
    }

    public void setOssbucketname(String ossbucketname) {
        this.ossbucketname = ossbucketname;
    }

    public String getOssendpoint() {
        return ossendpoint;
    }

    public void setOssendpoint(String ossendpoint) {
        this.ossendpoint = ossendpoint;
    }

    public String getWeixinAppID() {
        return weixinAppID;
    }

    public void setWeixinAppID(String weixinAppID) {
        this.weixinAppID = weixinAppID;
    }

    public String getWeixinAppSecret() {
        return weixinAppSecret;
    }

    public void setWeixinAppSecret(String weixinAppSecret) {
        this.weixinAppSecret = weixinAppSecret;
    }
}
