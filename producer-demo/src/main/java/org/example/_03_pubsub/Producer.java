package org.example._03_pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author 小吴
 * @Date 2023/04/04 21:44
 * @Version 1.0
 */
public class Producer {
    private final static String QUEUE_NAME = "03_pubsub";
    private final static String EXCHANGE_NAME = "03_pubsub";
    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置rabbitmq 的ip
        connectionFactory.setHost("192.168.101.138");
        connectionFactory.setUsername("itcast");
        connectionFactory.setPassword("123321");
        //3 创建Connection对象
        Connection connection = connectionFactory.newConnection();
        //4 创建Channel
        Channel channel = connection.createChannel();
        //5 设置对列属性
        /*
         * 参数1 交换机名称
         * 参数2 交换机类型
         */
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //6 发送消息
        /*
         * 交换机名称
         * 路由器
         * 消息属性（例如消息持久化）
         * 消息内容
         */
        String message = "hello_rabbitmq";
        channel.basicPublish(EXCHANGE_NAME,"", MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        //7 关闭资源
        channel.close();
        connection.close();
    }
}