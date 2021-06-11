package com.ls.config.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;

public class MsgSendConfirmCallBack implements ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息确认成功cause"+cause);
        } else {
            //处理丢失的消息
            System.out.println("消息确认失败:"+correlationData.getId()+"#cause"+cause);
        }
    }


}
