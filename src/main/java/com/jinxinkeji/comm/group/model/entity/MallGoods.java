package com.jinxinkeji.comm.group.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author changyl
 * @create 2021-10-04 18:47
 */
@ApiModel
public class MallGoods {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商家id")
    private Long shopId;

    @ApiModelProperty(value = "商品所属类目ID")
    private Long categoryId;

    @ApiModelProperty(value = "搜索关键字")
    private String keywords;

    @ApiModelProperty(value = "商品简介")
    private String brief;

    /** 是否上架 */
    @ApiModelProperty(value = "是否上架")
    private Integer isOnSale;

    @ApiModelProperty(value = "商品主图")
    private String picUrl;

    @ApiModelProperty(value = "是否人气推荐")
    private Integer isHot;

    @ApiModelProperty(value = "商品单位")
    private String unit;

    @ApiModelProperty(value = "零售价格")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "详细介绍")
    private String detail;

    @ApiModelProperty(value = "创建时间")
    private String addTime;

    private Integer deleted;


    private long salesNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setShopId(Long shopId)
    {
        this.shopId = shopId;
    }

    public Long getShopId()
    {
        return shopId;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
    }
    public void setBrief(String brief)
    {
        this.brief = brief;
    }

    public String getBrief()
    {
        return brief;
    }
    public void setIsOnSale(Integer isOnSale)
    {
        this.isOnSale = isOnSale;
    }

    public Integer getIsOnSale()
    {
        return isOnSale;
    }
    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl()
    {
        return picUrl;
    }
    public void setIsHot(Integer isHot)
    {
        this.isHot = isHot;
    }

    public Integer getIsHot()
    {
        return isHot;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setRetailPrice(BigDecimal retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRetailPrice()
    {
        return retailPrice;
    }
    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }
    public void setAddTime(String addTime)
    {
        this.addTime = addTime;
    }

    public String getAddTime()
    {
        return addTime;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }

}
