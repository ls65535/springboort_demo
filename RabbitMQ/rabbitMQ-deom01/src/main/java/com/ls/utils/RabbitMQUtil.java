package com.ls.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

/**
 * Created by ls on 2019/7/23.
 */
public class RabbitMQUtil {
    public static Connection getConnection() throws IOException {
        ConnectionFactory factory =
            new ConnectionFactory();
        factory.setHost("192.168.226.128");
        //浏览器访问rabbitmq后台管理用的是15672
        //发消息用的的5672
        //一个服务器可以有多个端口号，访问15672,服务器返回的是网页
        //访问5672,可以发消息，也可以取消息
        factory.setPort(5672);
        factory.setUsername("lsadmin");
        factory.setPassword("lsadmin");
        factory.setVirtualHost("/ls");
        //2,得到channel
        //com.rabbitmq.client.connection
        return factory
            .newConnection();
    }

}
