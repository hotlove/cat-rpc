package com.guo.rpc.serialize;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 10:33
 * @Description:
 */
public interface Serialize {

    /**
     * 返回序列化类型
     * @return
     */
    SerializerAlogrithm getSerializerAlogrithm();

    /**
     * 序列化接口
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 反序列化
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
