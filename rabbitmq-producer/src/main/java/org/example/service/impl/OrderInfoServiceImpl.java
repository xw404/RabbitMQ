package org.example.service.impl;


import com.alibaba.fastjson.JSON;
import org.example.domain.OperateIntergralVo;
import org.example.domain.OrderInfo;
import org.example.mapper.OrderInfoMapper;
import org.example.service.IOrderInfoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lanxw
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private OrderInfoMapper orderInfoMapper;

    private static final String QUEUE_NAME="refund_queue";
    @Override
    @Transactional
    public String refund(String orderNo) {
        OrderInfo orderInfo = orderInfoMapper.select(orderNo);

        OperateIntergralVo vo = new OperateIntergralVo();
        vo.setUserId(orderInfo.getUserId());
        vo.setValue(orderInfo.getIntergral());

        //发送消息
        rabbitTemplate.convertAndSend("",QUEUE_NAME,JSON.toJSONString(vo));

        //修改退款状态
        orderInfoMapper.changeRefundStatus(orderNo,OrderInfo.STATUS_REFUND);
        return "退款成功";
    }
}
