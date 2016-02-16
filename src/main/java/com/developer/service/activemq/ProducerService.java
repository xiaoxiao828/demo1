package com.developer.service.activemq;

import javax.jms.Destination;

/**
 * Created by xiao.lai on 15/12/28.
 */
public interface ProducerService {

    /**
     * 向指定队列发送消息
     */
    void sendMessage(Destination destination, final String msg);

    /**
     * 向默认队列发送消息
     */
    void sendMessage(final String msg);
}
