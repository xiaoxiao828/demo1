package com.developer.utils.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xiao.lai on 16/1/14.
 */
public class ClientOutputThread extends Thread
{
    private Socket socket;

    public ClientOutputThread(Socket socket)
    {
        super();
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {

            OutputStream os = socket.getOutputStream();

            while (true)
            {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                String line = reader.readLine();

                os.write(line.getBytes());
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}