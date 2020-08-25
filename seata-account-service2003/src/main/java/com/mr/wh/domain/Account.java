package com.mr.wh.domain;


import lombok.*;

import java.math.BigDecimal;

/**
 * @Description:
 * @ClassName: Account
 * @Author: User
 * @date: 2020.08.25 15:21
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
