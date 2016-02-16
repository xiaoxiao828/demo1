package com.developer.utils.urlAndUrl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xiao.lai on 16/1/19.
 */
public class OpenDirectory {
    public static void main(String[] args){
        String destKey = "java";

        try {
            URL url = new URL("http://www.dmoz.org/search/?q="+destKey);
            try(InputStream in =new BufferedInputStream(url.openStream())){
                InputStreamReader reader = new InputStreamReader(in);
                int c;
                if ((c=reader.read())!=-1){
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
