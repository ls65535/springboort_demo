package com.ls.test;

import com.ls.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import java.util.HashMap;
import org.junit.Test;

/**
 * Created by ls on 2019/7/23.
 * 实现消费者
 */
public class Test_1_simple_consumer {
    @Test
    public void consumer() throws Exception {
        //1.创建连接
        Connection connection = RabbitMQUtil.getConnection();
        //2.得到管道channel
        Channel channel = connection.createChannel();
        //3
        String queueName = "orderQueue1";
        // p2:durable true 持久化，保存到硬盘
        boolean durable = false;
        // p3:exclusive false 别的程序也能访问
        boolean exclusive = false;
        // p4:autoDelete false 队列中的消息处理完了，不删队列
        boolean autoDelete = false;
        // p5:arguments 队列的配置信息
        HashMap<String, Object> argments = null;
        channel.queueDeclare(queueName, durable, exclusive, autoDelete, argments);

        // 4,创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // autoAck:自动回复消息
        boolean autoAck=true;
        channel.basicConsume(queueName, autoAck, consumer);
        // 5,取消息
        while (true) {
            Delivery delivery = consumer.nextDelivery();
            byte[] data = delivery.getBody();
            String mString = new String(data);
            System.out.println("消费者取到：" + mString);
        }

      /*  // 6,连接关
        channel.close();
         connection.close();
         System.out.println("end");*/

    }

    }
