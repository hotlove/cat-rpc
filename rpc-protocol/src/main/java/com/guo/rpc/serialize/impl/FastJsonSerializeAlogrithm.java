package com.guo.rpc.serialize.impl;

import com.guo.rpc.serialize.SerializerAlogrithm;
import com.guo.rpc.serialize.SerializerAlogrithmType;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 10:40
 * @Description:
 */
public class FastJsonSerializeAlogrithm implements SerializerAlogrithm {
    public Byte getSerializerAlogrithm() {
        return SerializerAlogrithmType.FAST_JSON;
    }
}
