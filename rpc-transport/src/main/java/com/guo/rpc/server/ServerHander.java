package com.guo.rpc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/1 11:19
 * @Description:
 */
public class ServerHander extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("接收到客户端消息:"+msg);
        ctx.channel().writeAndFlush("你好客户端");
    }
}
