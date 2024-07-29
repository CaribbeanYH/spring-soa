package com.easy.archiecture.bean.response;


import lombok.Data;

import java.io.Serializable;

/**
 * @author yanghai10
 * @ClassName ResultDTO
 * @Description 统一的返回结构
 * @date 2023/09/12 18:30
 */
@Data
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 6718084765563812021L;

    private static final Integer SUCCESS_CODE = 0;

    private static final String SUCCESS_MESSAGE = "成功";

    /**
     * 状态码（0-表示成功，非0-表示失败）
     */
    private Integer code;

    /**
     * 返回码:true 表示成功，false表示失败
     */
    private boolean success;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * 返回体
     */
    private T data;

    /**
     * 请求的链路ID
     */
    private Object requestId;

    public ResultDTO() {
    }

    public ResultDTO(T data, boolean success, Integer code, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultDTO<T> build(boolean success, Integer code, String msg) {
        return new ResultDTO<>(null, success, code, msg);
    }

    public static <T> ResultDTO<T> build(T data, boolean success, Integer code, String msg) {
        return new ResultDTO<>(data, success, code, msg);
    }

    public static <T> ResultDTO<T> buildSuccess(T data) {
        return build(data, true, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> ResultDTO<T> buildSuccessWithOutData() {
        return build(true, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> ResultDTO<T> buildFail(Integer code, String msg) {
        return build(false, code, msg);
    }
}
