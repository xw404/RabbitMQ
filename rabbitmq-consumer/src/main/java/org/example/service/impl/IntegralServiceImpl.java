package org.example.service.impl;

import org.example.domain.OperateIntergralVo;
import org.example.mapper.UsableIntegralMapper;
import org.example.service.IIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lanxw
 */
@Service
public class IntegralServiceImpl implements IIntegralService {
    @Autowired
    private UsableIntegralMapper usableIntegralMapper;
    @Override
    @Transactional
    public void incrIntergral(OperateIntergralVo operateIntergralVo) {
        usableIntegralMapper.addIntergral(operateIntergralVo.getUserId(),operateIntergralVo.getValue());
    }
}
