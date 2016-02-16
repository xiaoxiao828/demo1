package com.developer.utils.thread.countNum;

import java.util.concurrent.Callable;

/**
 * Created by xiao.lai on 16/1/15.
 */
public class FindMaxTask implements Callable<Integer>{

    private int start;
    private int end;
    private int[] data;

    public FindMaxTask(int[] data,int start,int end){
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for(int i=start;i<end;i++) {
            if (data[i]>max) max = data[i];
        }
        return max;
    }
}
