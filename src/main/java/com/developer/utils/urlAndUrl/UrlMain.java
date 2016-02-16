package com.developer.utils.urlAndUrl;

import java.io.*;
import java.net.*;

/**
 * Created by xiao.lai on 16/1/18.
 */
public class UrlMain {
    public static void main(String[] args) throws MalformedURLException {
        URL u1 = new URL("http://www.baidu.com/test/2.html");
        System.out.println("url:"+u1.getFile());
        URL u2 = new URL(u1, "1.html");
        System.out.println("url:"+u2.getFile());

        URL myURL = new URL("http://app.quncaotech.com");
        System.out.println("url encode is"+URLEncoder.encode("http://www.baidu.com"));

        System.out.println("url encode is"+URLEncoder.encode("http://&&&***$$###@@^^^~~~"));

        System.out.println("url encode is" + URLDecoder.decode(URLEncoder.encode("http://&&&***$$###@@^^^~~~")));




        InputStream in=null;
        try{
            in = myURL.openStream();
            in = new BufferedInputStream(in);
            Reader r =new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(r);
            int c;
            while ((c=br.read())!=-1){
                System.out.print((char) c);
            }

            String protocal = myURL.getProtocol();
            String host = myURL.getHost();
            String file = myURL.getFile();
            int port = myURL.getPort();
            String ref = myURL.getRef();

            System.out.println(protocal + ", " + host + ", " + file + ", "
                    + port + ", " + ref);


            URLConnection conn = myURL.openConnection();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
