package com.developer.service.activemq;

import javax.jms.Destination;

/**
 * Created by xiao.lai on 15/12/28.
 */
public interface TopicProviderService {
    /**
     * 向指定的topic发布消息
     *
     * @param topic
     * @param msg
     */
    void publish(final Destination topic, final String msg);
}
