package org.example._06_boot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 小吴
 * @Date 2023/04/05 11:08
 * @Version 1.0
 */
@RestController
public class SendController {
    @Resource
    private RabbitTemplate rabbitTemplate;    //工具类

    private String QUEUE_NAME="boot_hello";
    @RequestMapping(value = "/sendMsg")
    public String sendMsg(@RequestParam String msg){
        rabbitTemplate.convertAndSend("" ,QUEUE_NAME,msg);
        return "发送成功";
    }

}
