package com.mr.wh.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description:
 * @ClassName: AccountService
 * @Author: User
 * @date: 2020.08.25 15:29
 * @version: 1.0
 */

public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
