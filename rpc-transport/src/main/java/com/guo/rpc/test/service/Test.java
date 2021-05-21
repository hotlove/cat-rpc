package com.guo.rpc.test.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object service = ServiceMap.INSTANCE.getService("helloServiceImpl");
        Method method = service.getClass().getMethod("getHelloStr", String.class);
//        method.getpa
        Object test = method.invoke(service, "test");
        System.out.println(test);
    }
}
