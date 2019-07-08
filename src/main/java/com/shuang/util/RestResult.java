package com.rograndec.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;

/**
 * 结果
 *
 * @param <T>
 *            结果数据类型
 */
@ApiModel(value = "RestResult")
public class RestResult<T> {
    @ApiModelProperty(value = "返回结果")
    private T       result;

    @ApiModelProperty(value = "业务状态码,0代表业务成功")
    private Integer code    = 0;

    @ApiModelProperty(value = "业务提示信息")
    private String  message = "";

    /**
     * 默认构造函数
     */
    public RestResult() {

    }

    /**
     * 生成成功结果对象
     *
     * @return 成功结果对象
     */
    private static <T> RestResult<T> genSuccessResult() {
        RestResult<T> restResult = new RestResult<T>();
        restResult.result = (T) new HashMap<Object, Object>(0);
        return restResult;
    }

    /**
     * 生成成功结果对象
     *
     * @param successMsg 成功信息
     * @param data 返回数据对象
     * @return 成功结果对象
     */
    public static <T> RestResult<T> genSuccessResult(String successMsg, T data) {
        RestResult<T> restResult = new RestResult<T>();
        restResult.message = successMsg;
        if (data == null) {
            restResult.result = (T) new HashMap<Object, Object>(0);
        } else {
            restResult.result = data;
        }
        return restResult;
    }

    /**
     * 生成成功结果对象
     *
     * @param data 返回数据对象
     * @return 成功结果对象
     */
    public static <T> RestResult<T> genSuccessResult(T data) {
        RestResult<T> restResult = new RestResult<T>();
        restResult.message = "";
        if (data == null) {
            restResult.result = (T) new HashMap<Object, Object>(0);
        } else {
            restResult.result = data;
        }
        return restResult;
    }

    /**
     * 生成错误结果对象
     *
     * @param errorMsg 错误信息
     * @return 错误结果对象
     */
    public static <T> RestResult<T> genErrorResult(String errorMsg) {
        RestResult<T> restResult = new RestResult<T>();
        restResult.code = -1;
        restResult.result = (T) new HashMap<Object, Object>(0);
        restResult.message = errorMsg;
        return restResult;
    }

    /**
     * 生成错误结果对象
     *
     * @param errorMsg 错误信息
     * @param data 返回数据对象
     * @return 错误结果对象
     */
    public static <T> RestResult<T> genErrorResult(String errorMsg, T data) {
        RestResult<T> restResult = new RestResult<T>();
        restResult.code = -1;
        restResult.message = errorMsg;
        if (data == null) {
            restResult.result = (T) new HashMap<Object, Object>(0);
        } else {
            restResult.result = data;
        }
        return restResult;
    }

    /**
     * 构造函数
     * 
     * @param result
     *            结果
     */
    public RestResult(T result) {
        this(result, 0, "");
    }

    /**
     * 构造函数
     * 
     * @param result
     *            结果
     * @param message
     *            信息
     */
    public RestResult(T result, int code, String message) {
        if (result == null) {
            this.result = (T) new HashMap<Object, Object>(0);
        } else {
            this.result = result;
        }
        this.message = message;
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param result
     *            结果
     * @param message
     *            信息
     */
    public RestResult(T result, String message) {
        this.result = result;
        this.code = 0;
        this.message = message;
    }

    /**
     * <描述>
     *
     * @Author: Zhengbin.jin 金正斌
     * @Email: Zhengbin.jin@rograndec.com
     * @2018/7/16 15:29
     */
    public RestResult(String message) {
        this.result = (T) new HashMap<Object, Object>(0);
        this.code = -1;
        this.message = message;
    }

    /**
     * 获取结果
     * 
     * @return 结果
     */
    public T getResult() {
        return result;
    }

    /**
     * 设置结果
     * 
     * @param result
     *            结果
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 获取消息
     * 
     * @return 消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置消息
     * 
     * @param message
     *            消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
