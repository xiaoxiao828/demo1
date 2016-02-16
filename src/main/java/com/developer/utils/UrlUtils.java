package com.developer.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class UrlUtils {
    public static void main(String[] args){
        try {
            URL myURL = new URL("http://app.quncaotech.com");

            String protocal = myURL.getProtocol();
            String host = myURL.getHost();
            String file = myURL.getFile();
            int port = myURL.getPort();
            String ref = myURL.getRef();

            System.out.println(protocal + ", " + host + ", " + file + ", "
                    + port + ", " + ref);


            URLConnection conn = myURL.openConnection();

            // 得到输入流
            InputStream is = conn.getInputStream();

            // 关于IO流的用法和写法一定要熟悉
            OutputStream os = new FileOutputStream("/infomation/Test/1.txt");

            byte[] buffer = new byte[2048];
            int length = 0;

            while (-1 != (length = is.read(buffer, 0, buffer.length)))
            {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
