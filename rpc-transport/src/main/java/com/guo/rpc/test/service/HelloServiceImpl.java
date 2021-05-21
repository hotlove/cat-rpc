package com.guo.rpc.test.service;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:28
 * @Description:
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String getHelloStr(String str) {
        return "hello "+ str + "rpc";
    }
}
