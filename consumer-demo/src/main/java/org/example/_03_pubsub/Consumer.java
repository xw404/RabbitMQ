package org.example._03_pubsub;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author 小吴
 * @Date 2023/04/04 17:16
 * @Version 1.0
 */
public class Consumer {
    private final static String EXCHANGE_NAME = "03_pubsub";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建一个连接工厂
        ConnectionFactory connectionFactory =new ConnectionFactory();
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
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind( queue,EXCHANGE_NAME,"");

        //使用channel取消息消费
        /*
        参数1 对列名称
        参数2 是否自动签收
        参数3 回调函数
         */
        channel.basicConsume(queue, true,
        new DeliverCallback() {
            /**
             * 消息mq中取出来会回调这个方法
             * 消费者消费消息就在handle中处理
             */
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                System.out.println("消费者1：消息为："+new String(delivery.getBody()));
            }
        }, new CancelCallback() {
            /**
             * 消息取消了会回调这个方法
             * 消费者消费消息就在handle中处理
             */
            @Override
            public void handle(String s) throws IOException {
                System.out.println("消息取消了");
            }
        });
    }
}
