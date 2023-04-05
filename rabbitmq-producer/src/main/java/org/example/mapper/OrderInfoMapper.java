package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.domain.OrderInfo;

/**
 * Created by wolfcode-lanxw
 */
public interface OrderInfoMapper {
    OrderInfo select(String orderNo);
    int changeRefundStatus(@Param("orderNo") String orderNo,@Param("status") int status);
}
