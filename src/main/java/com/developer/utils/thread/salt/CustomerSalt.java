package com.developer.utils.thread.salt;

/**
 * Created by xiao.lai on 16/1/11.
 */
public class CustomerSalt implements Runnable{
    private SaltThreadPool saltThreadPool;
    private int num=10;

    public CustomerSalt(SaltThreadPool saltThreadPool, int num){
        this.saltThreadPool = saltThreadPool;
        this.num = num;
    }


    public void run() {
        while (true) {
            saltThreadPool.subSalt(num);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
