package com.developer.utils.stream;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class ReturnDiest extends Thread{

    private String fileName;
    private byte[] digest;

    public ReturnDiest(String fileName){
        this.fileName = fileName;
    }

    public void run(){
        try {
            FileInputStream in = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);

            while (din.read() != -1);
            din.close();
            digest=sha.digest();


            System.out.println(DatatypeConverter.printHexBinary(digest));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getDigest(){
        return this.digest;
    }
}
