package com.guo.rpc.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.guo.rpc.serialize.Serialize;
import com.guo.rpc.serialize.SerializerAlogrithm;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 10:39
 * @Description:
 */
public class FastJSONSerializer implements Serialize {
    /**
     * 获取序列化类型
     * @return
     */
    public SerializerAlogrithm getSerializerAlogrithm() {
        return new FastJsonSerializeAlogrithm();
    }

    /**
     * 序列化数据
     * @param object
     * @return
     */
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    /**
     * 反序列化数据
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
