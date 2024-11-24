package com.wang.common;

import lombok.Getter;

/**
 * @author wangguangpeng
 * @date 2024/11/20 17:42
 **/
@Getter
public enum ResultCode {

    SUCCESS(200, "成功"),
    ERROR(400, "失败");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
