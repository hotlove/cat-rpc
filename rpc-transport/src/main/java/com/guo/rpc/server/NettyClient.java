package com.guo.rpc.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/1 10:50
 * @Description:
 */
public class NettyClient {
    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringDecoder())
                                .addLast(new ClientHandler())
                                .addLast(new StringEncoder());
                    }
                });
        bootstrap.connect("localhost", 8088);
//                .addListener(future -> {
//            if (future.isSuccess()) {
//
//                Channel channel = ((ChannelFuture) future).channel();
//                channel.writeAndFlush("hello, server");
//
//                System.out.println("连接成功");
//            } else {
//                System.out.println("连接失败");
//            }
//        });
    }
}
