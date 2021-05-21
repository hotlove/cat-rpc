package com.guo.rpc.service.util;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:55
 * @Description:
 */
public class ServiceInfo {

    private String serviceName;

    private Object serviceInstance;

    private Map<String, MethodInfo> methodInfos;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Map<String, MethodInfo> getMethodInfos() {
        return methodInfos;
    }

    public void setMethodInfos(Map<String, MethodInfo> methodInfos) {
        this.methodInfos = methodInfos;
    }

    public Object getServiceInstance() {
        return serviceInstance;
    }

    public void setServiceInstance(Object serviceInstance) {
        this.serviceInstance = serviceInstance;
    }
}
