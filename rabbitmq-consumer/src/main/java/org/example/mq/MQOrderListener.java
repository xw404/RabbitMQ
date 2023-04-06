package org.example.mq;

import com.alibaba.fastjson.JSON;
import org.example.domain.OperateIntergralVo;
import org.example.service.IIntegralService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MQOrderListener  {
    @Resource
    private IIntegralService iIntegralService;
    //队列名
    private static final String QUEUE_NAME="refund_queue";

    /**
     * 异步操作
     * @param msg
     */
    @RabbitListener(queuesToDeclare = @Queue(QUEUE_NAME))
    public void IncreaseIntegral(String msg){
        System.out.println("接收到的消息为："+msg);
        OperateIntergralVo vo = JSON.parseObject(msg, OperateIntergralVo.class);
        //加积分操作
        iIntegralService.incrIntergral(vo);
    }
}
