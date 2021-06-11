package com.ls.rabbitmq.consumer;

import com.ls.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class SecondConsumer {

    @RabbitListener(queues = {RabbitMQConfig.QUEUE_NAME1, RabbitMQConfig.QUEUE_NAME2})
    public void handleMessage(Message message) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :" + message);
    }
}