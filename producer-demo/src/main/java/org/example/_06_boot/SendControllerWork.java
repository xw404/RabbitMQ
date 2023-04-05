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
public class SendControllerWork {
    @Resource
    private RabbitTemplate rabbitTemplate;    //工具类

    private String QUEUE_NAME="boot_work";
    @RequestMapping(value = "/sendMsgWork")
    public String sendMsg(@RequestParam String msg){
        for (int i  =0;i<20;i++){
            rabbitTemplate.convertAndSend("" ,QUEUE_NAME,msg);
        }
        return "发送成功work";
    }

}
