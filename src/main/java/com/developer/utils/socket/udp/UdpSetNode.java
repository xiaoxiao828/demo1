package com.developer.utils.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class UdpSetNode {
    public static void main(String[] args) throws Exception
    {
        DatagramSocket datagramSocket = new DatagramSocket();

        // 构造数据报的包
        String str = "Hello World";

        // 用了public DatagramPacket(byte buf[], int length,InetAddress address,
        // int port)形式
        DatagramPacket packet = new DatagramPacket(str.getBytes(),
                str.length(), InetAddress.getByName("localhost"), 7000);

        // 发送数据包
        datagramSocket.send(packet);

        // 接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buffer, 100);
        datagramSocket.receive(packet2);
        // 输出接收到的数据
        System.out.println(new String(buffer, 0, packet2.getLength()));

        datagramSocket.close();

    }

}
