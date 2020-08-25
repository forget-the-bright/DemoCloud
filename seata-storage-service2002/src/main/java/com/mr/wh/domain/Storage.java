package com.mr.wh.domain;

import lombok.Data;

/**
 * @Description:
 * @ClassName: Storage
 * @Author: User
 * @date: 2020.08.25 15:00
 * @version: 1.0
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

