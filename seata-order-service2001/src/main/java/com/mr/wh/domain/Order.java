package com.mr.wh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description:
 * @ClassName: Order
 * @Author: User
 * @date: 2020.08.23 21:59
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;

    /*
        订单状态： 0：创建中；1：已完成；
     */
    private Integer status;
}
