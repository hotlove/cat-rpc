package com.guo.rpc.codec;

import com.guo.rpc.serialize.Serialize;
import com.guo.rpc.serialize.SerializerAlogrithm;
import com.guo.rpc.serialize.impl.FastJSONSerializer;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 10:58
 * @Description:
 */
public abstract class Packet {
    /**
     * 协议版本
     */
    Byte version = 1;

    abstract SerializerAlogrithm getSerializer();

    abstract Byte getCommand();
}
