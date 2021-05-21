package com.guo.rpc.service.util;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:56
 * @Description:
 */
public class MethodInfo {
    private String methodName;

    private Class<?>[] parameterTypes;

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
