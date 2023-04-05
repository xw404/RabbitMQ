package org.example._02_work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author 小吴
 * @Date 2023/04/04 21:44
 * @Version 1.0
 */
public class Producer {
    private final static String QUEUE_NAME = "02_work";
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
         * 参数1 对列名称
         * 参数2 对列是否持久化
         * 参数3 是否排他性
         * 参数4 是否自动删除消息
         * 参数5 是否设置一些额外的东西
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //6 发送消息
        /*
         * 交换机名称
         * 路由器
         * 消息属性（例如消息持久化）
         * 消息内容
         */
        for (int i=0;i<20;i++){
            String message = "hello_rabbitmq"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        }
        //7 关闭资源
        channel.close();
        connection.close();
    }
}