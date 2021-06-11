package com.ls.test;

import com.ls.utils.RabbitMQUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.util.HashMap;
import org.junit.Test;

/**
 * Created by ls on 2019/7/23.
 * 工作模式
 */
public class Test_2_work_provider {
    @Test
    public void provider() throws Exception {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        // 3,定义队列
        // p1:队列名称
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
        // 4,写消息
        // p1:exchange 给"",使用的是default exchange
        String exchange = "";
        // p2:routing 路由 key关键字，决定消息放到那个队列
        String routingKey = queueName;
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        // 消息持久化
        builder.deliveryMode(2);
        AMQP.BasicProperties properties = builder.build();
        for (int i = 0; i < 10; i++) {
            byte[] body = ("msg" + i).getBytes();

            // p4:body是消息内容
            channel.basicPublish(exchange, routingKey, properties, body);
        }
        // while(true){
        //
        // }
        // 5,关闭连接
        channel.close();
        connection.close();
        // System.out.println("发送了"+msg);
    }


}



