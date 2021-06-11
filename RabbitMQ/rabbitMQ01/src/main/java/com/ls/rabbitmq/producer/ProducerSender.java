package com.ls.rabbitmq.producer;

import com.ls.common.exce.ServiceException;
import com.ls.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by ls on 2019/7/24.
 */
@Component
public class ProducerSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param uuid
     * @param message  消息
     */
    public void sendMessage(String uuid,Object message) {
        if(StringUtils.isEmpty(message)){
            throw new ServiceException("","message不能我为空");
        }
        CorrelationData correlationId = new CorrelationData(uuid);
        /**
         * RabbitMqConfig.EXCHANGE  指定消息交换机
         * RabbitMqConfig.ROUTINGKEY2  指定队列key2
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY1,
            message, correlationId);
    }

}
