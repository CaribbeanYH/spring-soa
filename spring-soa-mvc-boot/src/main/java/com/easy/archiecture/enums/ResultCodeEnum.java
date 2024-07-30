package com.easy.archiecture.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/29 15:06
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    /**
     * 返回编码
     */
    SUCCESS(0, "响应成功"),
    SYSTEM_ERROR(500, "系统错误"),

    // 参数错误
    PARAMS_IS_NULL(10001, "参数为空"),
    ;
    /**
     * 编码
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String message;
}
