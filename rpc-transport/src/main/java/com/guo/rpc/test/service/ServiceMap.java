package com.guo.rpc.test.service;

import com.guo.rpc.service.util.MethodInfo;
import com.guo.rpc.service.util.ServiceInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:31
 * @Description:
 */
public class ServiceMap {

    public static ServiceMap INSTANCE = new ServiceMap();

    Map<String, ServiceInfo> serviceMap = new HashMap<>();

    public ServiceMap() {

        ServiceInfo serviceInfo = this.getServiceInfo(new HelloServiceImpl());

        serviceMap.put(serviceInfo.getServiceName(), serviceInfo);
    }

    public ServiceInfo getServiceInfo(Object service) {
        // 获取class对象
        Class<?> clazz = service.getClass();
        // 获取服务名称
        String serviceName = clazz.getSimpleName();

//        clazz.getInterfaces()

        // 获取所有的方法
        Method[] methods = clazz.getMethods();
        Map<String, MethodInfo> methodInfoMap = new HashMap<>();
        for (Method method : methods) {
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();

            MethodInfo methodInfo = new MethodInfo();
            methodInfo.setMethodName(methodName);
            methodInfo.setParameterTypes(parameterTypes);

            methodInfoMap.put(methodName, methodInfo);
        }

        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setServiceName(serviceName);
        serviceInfo.setMethodInfos(methodInfoMap);
        serviceInfo.setServiceInstance(service);

        return serviceInfo;
    }
    public ServiceInfo getService(String key) {
        return serviceMap.get(key);
    }
}
