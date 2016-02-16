package com.developer.utils.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

/**
 * Created by xiao.lai on 16/1/28.
 */
public class DayThread extends Thread {

    private Socket conn;

    public DayThread(Socket conn){
        this.conn = conn;
    }

    public void run(){
        try {
            Writer out = new OutputStreamWriter(conn.getOutputStream());
            Date date = new Date();
            out.write(date.toString() +"  by xiao.lai" + "\r\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
