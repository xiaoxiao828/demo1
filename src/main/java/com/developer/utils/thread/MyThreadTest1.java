package com.developer.utils.thread;

/**
 * Created by xiao.lai on 16/1/11.
 */
public class MyThreadTest1 {
    public static void main(String[] args) {
       /* ThreadTest mt1=new ThreadTest();
        ThreadTest mt2=new ThreadTest();
        ThreadTest mt3=new ThreadTest();
        mt1.start();//每个线程都各卖了10张，共卖了30张票
        mt2.start();//但实际只有10张票，每个线程都卖自己的票
        mt3.start();//没有达到资源共享*/


        RunableTest mt=new RunableTest();
        new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一
        new Thread(mt).start();//个实例化对象mt，就会出现异常
        new Thread(mt).start();//抢占时的多线程，来在线程池里执行有限的资源
    }
}

class ThreadTest extends Thread{
    private int ticket =10;
    public void run(){
        for(int i=0;i<100;i++) {
            if (this.ticket>0) {
                System.out.println("名称是："+Thread.currentThread().getName()+"----current ticket is"+this.ticket--);
            }
        }
    }
}

class RunableTest implements Runnable{
    private int ticket = 10;
    public void run() {
        for(int i=0;i<100;i++) {
            if (this.ticket>0) {
                System.out.println("名称是："+Thread.currentThread().getName()+"----current ticket is"+this.ticket--);
            }
        }
    }
}
