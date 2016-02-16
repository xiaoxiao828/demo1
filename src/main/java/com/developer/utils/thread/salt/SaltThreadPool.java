package com.developer.utils.thread.salt;

/**
 * Created by xiao.lai on 16/1/11.
 */
public class SaltThreadPool {
    private int saltNum = 0;

    /**
     * 消费模式，每次返回消费后的数据量大小
     *
     * */
    public synchronized int subSalt(int customNum) {
        while (saltNum<customNum) {
            System.out.println(Thread.currentThread().getName()+"进入等待生产中:");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        saltNum = saltNum - customNum;
        System.out.println(Thread.currentThread().getName()+"消费盐数量:"+customNum+",剩余数量:"+saltNum);
        return saltNum;
    }

    /**
     * 生产模式，每次返回生成后的数量
     *
     * */
    public synchronized int addSalt(int produceNum, int minCustomNum){
        while (saltNum>=minCustomNum) {
            System.out.println(Thread.currentThread().getName()+"进入等待消费中:");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        saltNum = saltNum + produceNum;
        System.out.println(Thread.currentThread().getName()+"买入盐数量:"+produceNum+",剩余数量:"+saltNum);
        return saltNum;
    }


}
