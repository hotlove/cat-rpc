package com.guo.rpc.codec;

import com.guo.rpc.serialize.Serialize;
import com.guo.rpc.serialize.SerializerAlogrithm;
import com.guo.rpc.serialize.SerializerAlogrithmType;
import com.guo.rpc.serialize.impl.FastJSONSerializer;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2021/5/21 16:20
 * @Description:
 */
public class PacketCodeC {

    public static PacketCodeC INSTANCE = new PacketCodeC();

    public static final int MAGIC_NUMBER = 0x123456; // int = 4byte

    Map<Byte, Serialize> serializeMap = new HashMap<Byte, Serialize>();
    Map<Byte, Class<? extends Packet>> packetMap = new HashMap<Byte, Class<? extends Packet>>();

    public PacketCodeC() {
        serializeMap.put(SerializerAlogrithmType.FAST_JSON, new FastJSONSerializer());

        packetMap.put(Commnad.SERVICE_INVOKE, ServiceRemoteInvokeRequest.class);
    }

    /**
     * 编码
     * @param byteBuf
     * @param packet
     */
    public void encode(ByteBuf byteBuf, Packet packet) {

        // 获取序列化算法类型
        SerializerAlogrithm serializerAlogrithm = packet.getSerializer();
        // 找到序列化器
        Serialize serialize = serializeMap.get(serializerAlogrithm.getSerializerAlogrithm());
        // 序列化内容
        byte[] packetSerialize = serialize.serialize(packet);

        // 1byte 魔数| 1byte 协议版本号 | 1byte 序列化算法 | 1byte 协议指令 | 4byte 内容长度 | nbyte 实际内容
        byteBuf.writeInt(MAGIC_NUMBER); // 4个字节魔数
        byteBuf.writeByte(packet.version); // 1字节版本号
        byteBuf.writeByte(serializerAlogrithm.getSerializerAlogrithm());  // 1字节算法类型
        byteBuf.writeByte(packet.getCommand());  // 1字节的指令类型
        byteBuf.writeInt(packetSerialize.length); // 4字节的长度
        byteBuf.writeBytes(packetSerialize); // n字节的长度内容
    }

    /**
     * 解码
     * @param byteBuf
     * @return
     */
    public Packet decode(ByteBuf byteBuf) {

        byteBuf.skipBytes(4); // 跳过魔数
        byteBuf.skipBytes(1); // 跳过版本好

        byte serializerAlogrithm = byteBuf.readByte(); // 序列化算法
        byte command = byteBuf.readByte(); // 指令类型
        int contentLength = byteBuf.readInt(); // 内容长度

        byte[] content = new byte[contentLength]; // 缓冲池
        byteBuf.readBytes(content); // 将内容读取到缓冲池里

        // 拿到序列化器
        Serialize serialize = serializeMap.get(serializerAlogrithm);

        // 目标包类型
        Class<? extends Packet> packetClazz = packetMap.get(command);

        if (serialize != null && packetClazz != null) {
            return serialize.deserialize(packetClazz, content);
        }

        return null;
    }
}
