package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-05 16:42
 */
@ApiModel
public class MessageTheme {

    @ApiModelProperty(value = "话题编码")
    private String themeCode;

    @ApiModelProperty(value = "话题")
    private String themeName;

    @ApiModelProperty(value = "话题描述")
    private String themeDesc;

    @ApiModelProperty(value = "展示排序")
    private String themeSort;

    @ApiModelProperty(value = "话题热度")
    private long heatFlow;

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeDesc() {
        return themeDesc;
    }

    public void setThemeDesc(String themeDesc) {
        this.themeDesc = themeDesc;
    }

    public String getThemeSort() {
        return themeSort;
    }

    public void setThemeSort(String themeSort) {
        this.themeSort = themeSort;
    }

    public long getHeatFlow() {
        return heatFlow;
    }

    public void setHeatFlow(long heatFlow) {
        this.heatFlow = heatFlow;
    }
}
