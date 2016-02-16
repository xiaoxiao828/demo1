package com.developer.utils.stream;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class MainTest {
    public static void main(String[] args){
        args = new String[]{"aa", "sf", "sdks"};


        for(String filename:args){
            ReturnDiest dr = new ReturnDiest(filename);
            dr.start();

            StringBuilder result = new StringBuilder(filename);
            result.append(":");
            byte[] digest = dr.getDigest();
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
    }
}
