package com.ls.config.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;

public class MsgSendReturnCallback implements ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText,
        String exchange, String routingKey) {
        System.out.println("确认后回调return--message:"+new String(message.getBody())+",replyCode:"+replyCode+",replyText:"
            +replyText+",exchange:"+exchange+",routingKey:"+routingKey);
    }

}
