package com.developer.utils.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xiao.lai on 16/1/14.
 */
public class ServerOutputThread extends Thread{
    private Socket socket;

    public ServerOutputThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            OutputStream stream = socket.getOutputStream();
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                stream.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
