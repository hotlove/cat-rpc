package com.guo.rpc.test.service;

import com.guo.rpc.service.util.MethodInfo;
import com.guo.rpc.service.util.ServiceInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ServiceInfo serviceInfo = ServiceMap.INSTANCE.getService("HelloServiceImpl");

        MethodInfo methodInfo = serviceInfo.getMethodInfos().get("getHelloStr");

        Method methodInvoker = serviceInfo.getServiceInstance().getClass().getMethod(methodInfo.getMethodName(), methodInfo.getParameterTypes());

        Object invoke = methodInvoker.invoke(serviceInfo.getServiceInstance(), "test");
        System.out.println(invoke);
    }
}
