package org.example._02_work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author 小吴
 * @Date 2023/04/04 21:48
 * @Version 1.0
 */
public class Consumer1 {
    private final static String QUEUE_NAME = "02_work";
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
         * 参数1 对列名称
         * 参数2 对列是否持久化
         * 参数3 是否排他性
         * 参数4 是否自动删除消息 如果没有消费者连接就自动删除
         * 参数5 是否设置一些额外的东西
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicQos(1);   //一次取一个
        //使用channel取消息消费
        /*
        参数1 对列名称
        参数2 是否自动签收
        参数3 回调函数
         */
        channel.basicConsume(QUEUE_NAME, true,
                new DeliverCallback() {
                    /**
                     * 消息mq中取出来会回调这个方法
                     * 消费者消费消息就在handle中处理
                     */
                    @Override
                    public void handle(String s, Delivery delivery) throws IOException {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("消费者2：消息为："+new String(delivery.getBody()));
                        channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false );  //手动签收消息
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
