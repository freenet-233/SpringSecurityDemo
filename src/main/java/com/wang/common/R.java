package com.wang.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangguangpeng
 * @date 2024/11/20 17:39
 **/
@Data
public class R {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private R() {}

    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage(ResultCode.SUCCESS.getMessage());
        return r;
    }


    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR.getCode());
        r.setMessage(ResultCode.ERROR.getMessage());
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
    public R data(Map<String, Object> data) {
        this.setData(data);
        return this;
    }

}
