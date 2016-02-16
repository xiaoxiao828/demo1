package com.developer.service.activemq.impl;

import com.developer.service.activemq.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by xiao.lai on 15/12/28.
 */
public class ConsumerServiceImpl implements ConsumerService{

    private JmsTemplate jmsTemplate;

    public void receive(Destination destination) {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);

        try{
            if (textMessage!=null) {
                System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                        + textMessage.getText());
            }else {
                System.out.println("队列" + destination.toString() + "暂无消息\t");
            }
        }catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void receiveDefaultMsg() {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        try{
            if (textMessage!=null) {
                System.out.println("默认队列收到了消息：\t"
                        + textMessage.getText());
            }else {
                System.out.println("默认队列暂无消息\t");
            }
        }catch (JMSException e) {
            e.printStackTrace();
        }
    }


    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
