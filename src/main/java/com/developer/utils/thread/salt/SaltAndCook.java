package com.developer.utils.thread.salt;

/**
 * Created by xiao.lai on 16/1/11.
 */
public class SaltAndCook {
    private static int minCustomNum = 12;


    public static void main(String[] args){
        SaltThreadPool salt = new SaltThreadPool();
        ProduceSalt p = new ProduceSalt(salt, 1, minCustomNum);
        CustomerSalt c = new CustomerSalt(salt, 12);


        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();


        System.out.println("当前线程的是："+p.hashCode());


        /*double a=17;
        double b=Math.round(a*10)/10.000;//保留四位小数
        System.out.println(b);*/
    }
}
