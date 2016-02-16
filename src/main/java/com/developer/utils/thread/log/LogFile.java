package com.developer.utils.thread.log;


import java.io.*;

/**
 * Created by xiao.lai on 16/1/18.
 */
public class LogFile {
    private Writer out;

    public LogFile(File f) throws IOException {
        FileWriter writer = new FileWriter(f);
        this.out = new BufferedWriter(writer);
    }


    public void writeEntity(String msg) throws IOException {
        out.write(System.currentTimeMillis()+"----");
        out.write(msg);
        out.write("\r\n");

        /*synchronized(out){
            Data d=new Data();
            out.write(d.toString());
            out.write('\t');
            out.write(msg);
            out.write("\r\n");
        }*/
    }

    public void close() throws IOException {
        out.flush();
        out.close();
    }
}
