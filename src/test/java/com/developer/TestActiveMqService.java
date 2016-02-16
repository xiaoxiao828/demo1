package com.developer;

import com.alibaba.fastjson.JSON;
import com.developer.dao.model.UserInfo;
import com.developer.service.activemq.ConsumerService;
import com.developer.service.activemq.ProducerService;
import com.developer.service.activemq.TopicProviderService;
import com.developer.service.business.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import java.util.List;

/**
 * Created by xiao.lai on 15/12/22.
 */
/**
 * 测试Spring JMS
 *
 * 1.测试生产者发送消息
 *
 * 2. 测试消费者接受消息
 *
 * 3. 测试消息监听
 *
 * 4.测试主题监听
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring/spring-activemq-queue.xml",
"classpath:spring/spring-activemq-topic.xml"})
public class TestActiveMqService {


    /**
     * 队列名queue1
     */
    @Qualifier("queueDestinationTest")
    @Autowired
    private Destination queueDestination1;

    /**
     * 队列名queue2
     */
    @Qualifier("queueDestinationTest")
    @Autowired
    private Destination queueDestination2;

    /**
     * 主题 guo_topic
     */
    @Autowired
    @Qualifier("topicDestination")
    private Destination topic;

    /**
     * 主题消息发布者
     */
    @Autowired
    private TopicProviderService topicProvider;

    /**
     * 队列消息生产者
     */
    @Autowired
    @Qualifier("producerService")
    private ProducerService producer;

    /**
     * 队列消息生产者
     */
    @Autowired
    @Qualifier("consumerService")
    private ConsumerService consumer;

    /**
     * 测试生产者向queue1发送消息
     */
   /* @Test
    public void testProduce() {
        String msg = "Hello world!";
        producer.sendMessage(msg);
    }*/

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * 测试消费者从queue1接受消息
     */
    @Test
    public void testConsume() {
        //consumer.receive(queueDestination2);
        //consumer.receiveDefaultMsg();
    }

    /**
     * 测试消息监听
     *
     * 1.生产者向队列queue2发送消息
     *
     * 2.ConsumerMessageListener监听队列，并消费消息
     */
    @Test
    public void testSend() {
      //  producer.sendMessage(queueDestination2, "Hello China~~~~~~~~~~~~~~~");
    }

    /**
     * 测试主题监听
     *
     * 1.生产者向主题发布消息
     *
     * 2.ConsumerMessageListener监听主题，并消费消息
     */
    @Test
    public void testTopic() throws Exception {
        //topicProvider.publish(topic, "Hello T-To-Top-Topi-Topic!");
    }

}
