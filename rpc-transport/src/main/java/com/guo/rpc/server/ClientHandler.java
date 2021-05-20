package com.guo.rpc.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/1 11:20
 * @Description:
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {




    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端激活");
        ctx.channel().writeAndFlush("hello server");
    }

    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("收到服务端消息"+msg);
    }
}
