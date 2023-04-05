package org.example.mapper;

import org.example.domain.AccountLog;

public interface AccountLogMapper {
    /**
     * 插入日志
     * @param accountLog
     */
    void insert(AccountLog accountLog);
}
