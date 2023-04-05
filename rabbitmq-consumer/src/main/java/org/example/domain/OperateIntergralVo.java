package org.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by lanxw
 * 用户调用积分接口需要传输的数据对象
 */
@Data
public class OperateIntergralVo implements Serializable {
    private Long value;//此次积分变动数值
    private Long userId;//用户ID

    public OperateIntergralVo(Long value, Long userId) {
        this.value = value;
        this.userId = userId;
    }

    public OperateIntergralVo() {
    }
}
