package com.guo.rpc.codec;

import com.guo.rpc.serialize.SerializerAlogrithm;
import com.guo.rpc.serialize.impl.FastJsonSerializeAlogrithm;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 11:03
 * @Description:
 */
public class ServiceRemoteInvokeRequest extends Packet{
    /**
     * 服务版本
     */
    private String version;

    /**
     * 服务名称
     */
    private String serviceName;


    SerializerAlogrithm getSerializer() {
        return new FastJsonSerializeAlogrithm();
    }

    Byte getCommand() {
        return Commnad.SERVICE_INVOKE;
    }
}
