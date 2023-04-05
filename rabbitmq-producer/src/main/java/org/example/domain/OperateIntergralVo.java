package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OperateIntergralVo implements Serializable {
    private Long value;//此次积分变动数值
    private Long userId;//用户ID
}
