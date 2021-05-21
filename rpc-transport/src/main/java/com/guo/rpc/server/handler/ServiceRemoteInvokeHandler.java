package com.guo.rpc.server.handler;

import com.guo.rpc.codec.ServiceRemoteInvokeRequest;
import com.guo.rpc.service.util.MethodInfo;
import com.guo.rpc.service.util.ServiceInfo;
import com.guo.rpc.test.service.ServiceMap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 22:13
 * @Description:
 */
@ChannelHandler.Sharable
public class ServiceRemoteInvokeHandler extends SimpleChannelInboundHandler<ServiceRemoteInvokeRequest> {

    public static ServiceRemoteInvokeHandler INSTANCE = new ServiceRemoteInvokeHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ServiceRemoteInvokeRequest msg) throws Exception {
        String serviceName = msg.getServiceName();

        ServiceInfo serviceInfo = ServiceMap.INSTANCE.getService(serviceName);
        MethodInfo methodInfo = serviceInfo.getMethodInfos().get(msg.getMethodName());

        Method methodInvoker = serviceInfo.getServiceInstance().getClass().getMethod(methodInfo.getMethodName(), methodInfo.getParameterTypes());

        Object invoke = methodInvoker.invoke(serviceInfo.getServiceInstance(), msg.getArgs());

        ctx.writeAndFlush(invoke);
    }
}
