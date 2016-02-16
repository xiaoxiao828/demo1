package com.developer.utils.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xiao.lai on 16/1/18.
 */
public class SpamCheck {

    private static String BLACKHOLE = "abl.spamhaus.org";

    public static void main(String[] args){
        args = new String[]{"61.135.169.125","61.12.111.232"};
        for(String arg : args) {
            if(isSpam(arg)) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

    public static boolean isSpam(String ip){
        try {
            InetAddress address = InetAddress.getByName(ip);
            byte[] bytes = address.getAddress();
            String query = BLACKHOLE;
            for (byte b:bytes) {
                int unsignedByte = b<0?256+b:b;
                query=unsignedByte+"."+query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

}
