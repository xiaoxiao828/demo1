package com.developer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by xiao.lai on 15/12/22.
 */
public class TestLog4j {
    private static Logger logger = Logger.getLogger(TestLog4j.class);

    public static void  main(String[] args)  {
        // System.out.println("This is println message.");

        System.setProperty("log4j.configuration", "log4j.xml");

        TestLog4j.logger.debug("test start...");

        TestLog4j.logger.error("test error...");

        // 记录debug级别的信息
        //logger.debug("This is debug message.");
        // 记录info级别的信息
       // logger.info("This is info message.");
        // 记录error级别的信息
        //logger.error("This is error message.");

    }
}
