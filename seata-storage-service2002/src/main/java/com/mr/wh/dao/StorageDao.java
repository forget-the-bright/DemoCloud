package com.mr.wh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @ClassName: StorageDao
 * @Author: User
 * @date: 2020.08.25 15:02
 * @version: 1.0
 */
@Mapper
public interface StorageDao {
    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
