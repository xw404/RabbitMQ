package org.example.service;


import org.example.domain.OperateIntergralVo;

/**
 * Created by lanxw
 */
public interface IIntegralService {
    /**
     * 增加积分
     * @param operateIntergralVo
     * @return 变化后的用户积分
     */
    void incrIntergral(OperateIntergralVo operateIntergralVo);
}
