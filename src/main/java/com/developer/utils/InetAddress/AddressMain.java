package com.developer.utils.InetAddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by xiao.lai on 16/1/18.
 */
public class AddressMain {
    public static void main(String[] args){
        try {
            InetAddress address = InetAddress.getByName("http://www.upc.edu.cn/");
            if (address.isAnyLocalAddress()) {
                System.out.println("is anylocaladdress");
            }
            if (address.isLoopbackAddress()) {
                System.out.println("is loopbackaddress");
            }
            if (address.isMulticastAddress()) {
                System.out.println("is multicastaddress");
            }


            System.out.println(address);
            InetAddress addressLocal = InetAddress.getLocalHost();
            System.out.println( addressLocal.getCanonicalHostName());
            System.out.println( addressLocal.getHostName());
            System.out.println( addressLocal.getHostName());
            System.out.println( addressLocal.getAddress());
            System.out.println( addressLocal.getAddress().length);


            NetworkInterface netWork = NetworkInterface.getByName("lo0");
            System.out.println("netWork:"+netWork);


            NetworkInterface netWork1 = NetworkInterface.getByInetAddress(addressLocal);
            System.out.println("netWork:"+netWork1);


            Enumeration<NetworkInterface> enums = NetworkInterface.getNetworkInterfaces();
            while (enums.hasMoreElements()) {
                System.out.println("enums-----:"+enums.nextElement());
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
