package org.example.mapper;

import org.apache.ibatis.annotations.Param;

public interface UsableIntegralMapper {
    void addIntergral(@Param("userId") Long userId, @Param("amount") Long amount);
}
