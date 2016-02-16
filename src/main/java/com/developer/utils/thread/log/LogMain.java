package com.developer.utils.thread.log;

import java.io.File;
import java.io.IOException;

/**
 * Created by xiao.lai on 16/1/18.
 */
public class LogMain {
    public static void main(String[] ats) throws IOException {
        File f = new File("/infomation/test.txt");



        LogFile logFile = new LogFile(f);
        for(int i=0;i<100;i++) {
            logFile.writeEntity("look-"+i);
        }
        logFile.close();

    }
}
