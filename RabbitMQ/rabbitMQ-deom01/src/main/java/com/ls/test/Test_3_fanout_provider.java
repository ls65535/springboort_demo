package com.ls.test;

import com.ls.utils.RabbitMQUtil;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

/**
 * Created by ls on 2019/7/23.
 * 订阅模式
 */
public class Test_3_fanout_provider {
    @Test
    public void  provider() throws Exception{
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "E1";
        // fanout 订阅模式
        // direct 路由模式
        // topic 主题模式
        channel.exchangeDeclare(exchangeName,"fanout");
        // 4,写消息
        boolean isRunning = true;

        String msg = "msg 03";
        String routingKey = "";
        BasicProperties properties = null;
        channel.basicPublish(exchangeName, routingKey, properties, msg.getBytes());

        // 5,关闭连接
        channel.close();
        connection.close();

    }

}
