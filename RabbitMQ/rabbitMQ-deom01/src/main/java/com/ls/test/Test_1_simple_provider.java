package com.ls.test;


import com.ls.utils.RabbitMQUtil;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.util.HashMap;
import org.junit.Test;

/**
 * Created by ls on 2019/7/23. RabbitMQ的简单模式模拟
 */
public class Test_1_simple_provider {

    @Test
    public void provider() throws Exception {

        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        //3,定义队列
        //p1:队列名称
        String queueName = "orderQueue1";
        //p2:durable true 持久化，保存到硬盘
        boolean durable = false;
        //p3:exclusive false 别的程序也能访问
        boolean exclusive = false;
        //p4:autoDelete false 队列中的消息处理完了，不删队列
        boolean autoDelete = false;
        //p5:arguments 队列的配置信息
        HashMap<String, Object> argments = null;
        channel.queueDeclare(queueName, durable, exclusive,
            autoDelete, argments);
        //4,写消息
        //p1:exchange 给"",使用的是default exchange
        String exchange = "";
        //p2:routing 路由 key关键字，决定消息放到那个队列
        String routingKey = queueName;
        //p3:props 是property
        //com.rabbitmq.client.AMQP.BasicProperties
        BasicProperties properties = null;

        byte[] body = "msg1".getBytes();

        //p4:body是消息内容
        channel.basicPublish(exchange, routingKey,
            properties, body);

        //5,关闭连接
        channel.close();
        connection.close();
        //System.out.println("发送了"+msg);
    }


}


