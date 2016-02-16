package com.developer.listener.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by xiao.lai on 15/12/28.
 */
public class TopicMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("TopicMessageListener \t" + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
