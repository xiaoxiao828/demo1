package com.developer.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StopWatch;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestEval {
    static String host = "localhost"; 
    static int honBaoCount = 100000;
       
    static int threadCount = 20;
       
    static String hongBaoList = "hongBaoList";   //将大红包拆分成小红包按list存放到redis中
    static String hongBaoConsumedList = "hongBaoConsumedList"; // 红包消费list集合（list存放）
    static String hongBaoConsumedMap = "hongBaoConsumedMap";   //用户抢红包list集合（map存放）
       
    static Random random = new Random();
       
//  -- 函数：尝试获得红包，如果成功，则返回json字符串，如果不成功，则返回空 
//  -- 参数：红包队列名， 已消费的队列名，去重的Map名，用户ID 
//  -- 返回值：nil 或者 json字符串，包含用户ID：userId，红包ID：id，红包金额：money 
    static String tryGetHongBaoScript =
            "if redis.call('hexists', KEYS[3], KEYS[4]) ~= 0 then\n" 
            + "return nil\n" 
            + "else\n" 
            + "local hongBao = redis.call('rpop', KEYS[1]);\n" 
//          + "print('hongBao:', hongBao);\n" 
            + "if hongBao then\n" 
            + "local x = cjson.decode(hongBao);\n" 
            + "x['userId'] = KEYS[4];\n" 
            + "local re = cjson.encode(x);\n" 
            + "redis.call('hset', KEYS[3], KEYS[4], x['money']);\n"
            + "redis.call('lpush', KEYS[2], re);\n" 
            + "return re;\n" 
            + "end\n" 
            + "end\n" 
            + "return nil"; 
    static StopWatch watch = new StopWatch();
       
    public static void main(String[] args) throws InterruptedException { 
//      testEval(); 
        generateTestData2();
//        testTryGetHongBao();
    }

    static public void generateTestData2() {
        Jedis jedis = new Jedis(host);
        jedis.flushAll();
        long max = 100;
        long min = 0;
        long[] result = NormalSchool.generate(100, 8, max, min);

                    for(int j=0,len=result.length; j < len; j++) {
                        JSONObject object = new JSONObject();
                        object.put("id", j);
                        object.put("money", result[j]);
                        jedis.lpush(hongBaoList, object.toJSONString());
                    }
    }
       
    static public void generateTestData() throws InterruptedException { 
        Jedis jedis = new Jedis(host); 
        jedis.flushAll(); 
        final CountDownLatch latch = new CountDownLatch(threadCount);
        for(int i = 0; i < threadCount; ++i) { 
            final int temp = i; 
            Thread thread = new Thread() { 
                public void run() { 
                    Jedis jedis = new Jedis(host); 
                    int per = honBaoCount/threadCount; 
                    JSONObject object = new JSONObject();
                    for(int j = temp * per; j < (temp+1) * per; j++) { 
                        object.put("id", j); 
                        object.put("money", j); 
                        jedis.lpush(hongBaoList, object.toJSONString()); 
                    } 
                    latch.countDown(); 
                } 
            }; 
            thread.start(); 
        } 
        latch.await(); 
    } 
       
    static public void testTryGetHongBao() throws InterruptedException { 
        final CountDownLatch latch = new CountDownLatch(threadCount); 
        System.err.println("start:" + System.currentTimeMillis()/1000); 
        watch.start(); 
        for(int i = 0; i < threadCount; ++i) { 
            final int temp = i; 
            Thread thread = new Thread() { 
                public void run() { 
                    Jedis jedis = new Jedis(host);
//                    String sha = jedis.scriptLoad(tryGetHongBaoScript);
                    int j = honBaoCount/threadCount * temp; 
                    while(true) { 
                        Object object = jedis.eval(tryGetHongBaoScript, 4, hongBaoList, hongBaoConsumedList, hongBaoConsumedMap, "" + j); 
                        j++; 
                        if (object != null) { 
                             System.out.println("get hongBao:" + object);
                        }else { 
                            //已经取完了 
                            if(jedis.llen(hongBaoList) == 0) 
                                break; 
                        } 
                    } 
                    latch.countDown(); 
                } 
            }; 
            thread.start(); 
        } 
           
        latch.await(); 
        watch.stop(); 
           
        System.err.println("time:" + watch.getTotalTimeSeconds()); 
        System.err.println("speed:" + honBaoCount/watch.getTotalTimeSeconds()); 
        System.err.println("end:" + System.currentTimeMillis()/1000); 
    } 
}
