package com.example.xcodemq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Kevin_Caesar
 * @date 2023/06/13
 */
@Component
@RocketMQMessageListener(topic = "${x.code.mq.rocketmq.topic}", consumerGroup = "${x.code.mq.rocketmq.consumer.group}", nameServer = "${x.code.mq.rocketmq.consumer.nameServer:}", enableMsgTrace = false)
public class SampleConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("msg:" + s);

    }
}
