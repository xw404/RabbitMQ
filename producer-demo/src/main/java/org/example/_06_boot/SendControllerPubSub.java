package org.example._06_boot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 小吴
 * @Date 2023/04/05 11:08
 * @Version 1.0
 */
@RestController
public class SendControllerPubSub {
    @Resource
    private RabbitTemplate rabbitTemplate;    //工具类
    private String EXCHANGE_NAME="pubsub";
    @RequestMapping(value = "/sendMsgPubSub")
    public String sendMsg(@RequestParam String msg){
        rabbitTemplate.convertAndSend(EXCHANGE_NAME ,"",msg);
        return "发送成功pubsub";
    }

}
