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

    /**
     * 调用方法名称
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 实际参数
     */
    private Object[] args;

    SerializerAlogrithm getSerializer() {
        return new FastJsonSerializeAlogrithm();
    }

    Byte getCommand() {
        return Commnad.SERVICE_INVOKE;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }
}
