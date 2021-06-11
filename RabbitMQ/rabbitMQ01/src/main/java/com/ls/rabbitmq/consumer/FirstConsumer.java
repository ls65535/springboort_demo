package com.ls.rabbitmq.consumer;

import com.ls.config.RabbitMQConfig;
import com.ls.mapper.ReptileMapper;
import com.ls.pojo.Reptile;
import com.rabbitmq.client.Channel;
import java.util.List;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;


@Component
public class FirstConsumer {

    @Autowired
    private ReptileMapper reptileMapper;

    /**
     * queues  指定从哪个队列（queue）订阅消息
     */
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_NAME1})
    public void handleMessage(List<Reptile> message,
        @Headers Map<String, Object> headers,
        Channel channel) throws Exception {
        System.out.println("----------收到消息，开始消费-----------");
        System.out.println("订单ID:" + message);
        for (Reptile jsonReptile : message) {

            reptileMapper.insert(jsonReptile);
        }
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        // channel.basicAck(deliveryTag, false);
        channel.basicAck(deliveryTag, true);//true,消费后删除队列的数据
    }
}
