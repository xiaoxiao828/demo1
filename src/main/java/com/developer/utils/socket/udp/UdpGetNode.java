package com.developer.utils.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class UdpGetNode {
    public static void main(String[] args){
        try (DatagramSocket socket=new DatagramSocket(7000)){


            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 1024);

            socket.receive(packet);

            // 输出
            System.out.println(new String(buffer, 0, packet.getLength()));

            // 返回信息
            String str = "Welcome!";
            DatagramPacket packet2 = new DatagramPacket(str.getBytes(),
                    str.length(), packet.getAddress(), packet.getPort());// 这里填入发送方的信息

            socket.send(packet2);

            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
