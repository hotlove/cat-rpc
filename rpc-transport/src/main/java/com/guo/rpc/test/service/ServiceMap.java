package com.guo.rpc.test.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:31
 * @Description:
 */
public class ServiceMap {

    public static ServiceMap INSTANCE = new ServiceMap();

    Map<String, Object> serviceMap = new HashMap<>();

    public ServiceMap() {
        serviceMap.put("helloServiceImpl", new HelloServiceImpl());
    }

    public Object getService(String key) {
        return serviceMap.get(key);
    }
}
