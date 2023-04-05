package org.example._06_boot._04_routing;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
public class Consumer6 {
    private static final String EXCHANGE_NAME="routing";
    @RabbitListener(bindings =
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = EXCHANGE_NAME, type = "direct"),
                    key = {"trace","error"}  //指定路由规则
            ))    //监听指定队列的消息
    public void consumer(String msg,
                         @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                         Channel channel) throws Exception {
        Thread.sleep(1000);
        System.out.println("消费者2： 消息为："+msg);
        channel.basicAck(deliveryTag,true);
    }
}
