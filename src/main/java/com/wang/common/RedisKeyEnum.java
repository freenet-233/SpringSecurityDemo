package com.wang.common;

import lombok.Getter;

@Getter
public enum RedisKeyEnum {

    LOGIN("login:", "登录用户");

    private final String key;
    private final String desc;

    RedisKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }
}
