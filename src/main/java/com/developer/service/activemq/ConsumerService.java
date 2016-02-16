package com.developer.service.activemq;

import javax.jms.Destination;

/**
 * Created by xiao.lai on 15/12/28.
 */
public interface ConsumerService {

    /**
     * 接受消息
     */
    void receive(Destination destination);


    /**
     * 接受默认队列的消息
     */
    void receiveDefaultMsg();
}
