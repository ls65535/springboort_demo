package com.ls.test;

import com.ls.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import java.util.HashMap;
import org.junit.Test;

/**
 * Created by ls on 2019/7/23.
 */
public class Test_2_work_consumerAck2 {

    @Test
    public void consumer() throws Exception {
        //1.建立连接
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName = "orderQueue5";
        // p2:durable true 持久化，保存到硬盘
        boolean durable = true;
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
        boolean autoAck=false;
        channel.basicConsume(queueName, autoAck, consumer);
        System.out.println("启动消费者2");
        // 5,取消息
        while (true) {
            Delivery delivery = consumer.nextDelivery();
            byte[] data = delivery.getBody();
            String mString = new String(data);
            System.out.println("消费者2取到：" + mString);
            try {

                long deliveryTag=delivery.getEnvelope().getDeliveryTag();
                System.out.println("deliveryTag="+deliveryTag);
                channel.basicAck(deliveryTag, true);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        // 6,连接关
        // channel.close();
        // connection.close();
        // System.out.println("end");
    }


}


