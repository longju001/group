package com.jinxinkeji.comm.group.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author changyl
 * @create 2021-09-02 14:44
 */
@ApiModel
public class Result<T> {

    @ApiModelProperty(value = "接口成功与否：true，false")
    private String message;
    @ApiModelProperty(value = "借口返回的消息描述")
    private String success;
    @ApiModelProperty(value = "接口返回的主体内容")
    private T result;

    public static final String STATUS_SUCCESS = "true";
    public static final String STATUS_FAILED = "false";

    public Result(String message, String success, T result) {
        this.message = message;
        this.success = success;
        this.result = result;
    }

    public Result() {
    }

    public static <T> Result<T>  success(String message, T t){
        return new Result<>(Result.STATUS_SUCCESS, message, t);
    }

    public static <T> Result<T>  failed(String message){
        return new Result<>(Result.STATUS_FAILED, message, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", success='" + success + '\'' +
                ", result=" + result +
                '}';
    }
}
