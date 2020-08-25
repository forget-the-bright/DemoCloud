package com.mr.wh.dao;

import com.mr.wh.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @ClassName: OrderDao
 * @Author: User
 * @date: 2020.08.23 22:02
 * @version: 1.0
 */
@Mapper
public interface OrderDao {
    //1新建订单
    void create(Order order);

    //2修改订单状态,从零改到一
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
