package com.developer.utils.thread.salt;

/**
 * Created by xiao.lai on 16/1/11.
 */
public class ProduceSalt implements Runnable{
    private SaltThreadPool saltThreadPool;
    private int produceNum=10;
    private int minCustomNum=10;

    public ProduceSalt(SaltThreadPool saltThreadPool, int produceNum, int minCustomNum){
        this.saltThreadPool = saltThreadPool;
        this.produceNum=produceNum;
        this.minCustomNum=minCustomNum;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saltThreadPool.addSalt(produceNum, minCustomNum);
        }
    }
}
