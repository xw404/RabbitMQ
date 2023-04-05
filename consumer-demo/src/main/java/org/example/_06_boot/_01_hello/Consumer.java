package org.example._06_boot._01_hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author 小吴
 * @Date 2023/04/05 11:33
 * @Version 1.0
 */
@Component
public class Consumer {
    private static final String QUEUE_NAME="boot_hello";
    @RabbitListener(queuesToDeclare = @Queue(QUEUE_NAME))    //监听指定队列的消息
    public void consumer(String msg){
        System.out.println("消息为："+msg);
    }
}
