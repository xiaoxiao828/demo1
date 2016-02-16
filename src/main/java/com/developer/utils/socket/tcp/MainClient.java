package com.developer.utils.socket.tcp;

import java.net.Socket;

/**
 * Created by xiao.lai on 16/1/14.
 */
public class MainClient {
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("127.0.0.1", 4000);

        new ClientInputThread(socket).start();
        new ClientOutputThread(socket).start();

    }
}
