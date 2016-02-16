package com.developer.utils.thread.countNum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class MaxFinder {
    public static void main(String[] args){
        int[] data = {1,2,3,44,343,3,556,33,2232121,343434343,2};
        long startTime = System.currentTimeMillis();
        try {
            System.out.println("max number is:"+max(0,data.length,data));

           // System.out.println("max number is:"+maxTemp(0,data.length,data));


            long endTime = System.currentTimeMillis();
            System.out.println("cost time:"+ (endTime-startTime));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int max(int start,int end,int[] data) throws ExecutionException, InterruptedException {
        if (data.length==1) {
            return data[0];
        }else if(data.length==0){
            throw new IllegalArgumentException();
        }

        FindMaxTask findMaxTask1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask findMaxTask2 = new FindMaxTask(data, data.length/2, data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(findMaxTask1);
        Future<Integer> future2 = service.submit(findMaxTask2);

        if (future1.isDone()){
            System.out.println("sds");
        }


        return Math.max(future1.get(), future2.get());

    }

    public static int maxTemp(int start,int end,int[] data) throws ExecutionException, InterruptedException {
        if (data.length==1) {
            return data[0];
        }else if(data.length==0){
            throw new IllegalArgumentException();
        }

        FindMaxTask findMaxTask1 = new FindMaxTask(data, 0, data.length/2);

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> future1 = service.submit(findMaxTask1);

        return future1.get();

    }
}
