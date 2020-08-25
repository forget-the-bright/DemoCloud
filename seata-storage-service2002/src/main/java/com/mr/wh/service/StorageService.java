package com.mr.wh.service;

/**
 * @Description:
 * @ClassName: StorageService
 * @Author: User
 * @date: 2020.08.25 15:06
 * @version: 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
