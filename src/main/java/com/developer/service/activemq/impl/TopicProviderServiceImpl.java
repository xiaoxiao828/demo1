package com.developer.service.activemq.impl;

import com.developer.service.activemq.TopicProviderService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by xiao.lai on 15/12/28.
 */
public class TopicProviderServiceImpl implements TopicProviderService{

    private JmsTemplate topicJmsTemplate;

    public void publish(final Destination topic, final String msg) {
        topicJmsTemplate.send(topic, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                System.out.println("topic name 是" + topic.toString()
                        + "，发布消息内容为:\t" + msg);
                return session.createTextMessage(msg);
            }
        });
    }

    public void setTopicJmsTemplate(JmsTemplate topicJmsTemplate) {
        this.topicJmsTemplate = topicJmsTemplate;
    }
}
