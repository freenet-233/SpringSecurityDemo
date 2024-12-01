package com.wang.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author wangguangpeng
 * @date 2024/11/20 17:13
 **/
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {


    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;

    }

    @Override
    public byte[] serialize(T value) throws SerializationException {
        if (null == value) {
            return new byte[0];
        }
        return JSON.toJSONBytes(value);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return JSON.parseObject(bytes, clazz);
    }
}
