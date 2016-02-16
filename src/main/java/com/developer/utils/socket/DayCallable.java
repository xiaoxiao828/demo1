package com.developer.utils.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by xiao.lai on 16/1/28.
 */
public class DayCallable implements Callable{
    public Socket conn;

    public DayCallable(Socket conn){
        this.conn = conn;
    }


    @Override
    public Object call() throws Exception {
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
        return null;
    }
}
