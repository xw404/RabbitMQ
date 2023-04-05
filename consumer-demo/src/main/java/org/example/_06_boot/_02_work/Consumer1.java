package org.example._06_boot._02_work;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @Author 小吴
 * @Date 2023/04/05 11:33
 * @Version 1.0
 */
@Component
public class Consumer1 {
    private static final String QUEUE_NAME="boot_work";
    @RabbitListener(queuesToDeclare = @Queue(QUEUE_NAME))   //监听指定队列的消息
    public void consumer(String msg,
                         @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                         Channel channel) throws Exception {
        Thread.sleep(2000);
        System.out.println("消费者1： 消息为："+msg);
        channel.basicAck(deliveryTag,true);
    }
}
