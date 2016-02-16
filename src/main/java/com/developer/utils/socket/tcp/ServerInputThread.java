package com.developer.utils.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by xiao.lai on 16/1/14.
 */
public class ServerInputThread extends Thread{
    private Socket socket;

    public ServerInputThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            InputStream stream = socket.getInputStream();
            while (true) {
                byte[] buffer = new byte[1024];
                int length = stream.read(buffer);
                String str = new String(buffer, 0, length);
                System.out.println("客户端输入："+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
