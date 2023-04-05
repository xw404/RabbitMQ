package org.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lanxw
 * 用户积分表
 */
@Data
public class UsableIntegral implements Serializable {
    private Long userId;//用户id
    private Date gmtCreated;//创建时间
    private Date gmtModified;//更新时间
    private Long amount;//目前可用积分
    private Long freezedAmount;//冻结金额
    public Long getUsableAmount(){
        return amount-freezedAmount;
    }
}
