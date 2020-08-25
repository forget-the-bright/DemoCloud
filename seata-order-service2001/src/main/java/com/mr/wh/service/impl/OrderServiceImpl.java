package com.mr.wh.service.impl;

import com.mr.wh.dao.OrderDao;
import com.mr.wh.domain.Order;
import com.mr.wh.service.AccountService;
import com.mr.wh.service.OrderService;
import com.mr.wh.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: OrderServiceImpl
 * @Author: User
 * @date: 2020.08.23 22:02
 * @version: 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao dao;
    @Resource
    private StorageService sservice;
    @Resource
    private AccountService aservice;


    @Override
    @GlobalTransactional(name = "fsz-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------>开始新建订单");
        dao.create(order);
        log.info("------>订单微服务开始调用库存，扣减count");
        sservice.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务开始调用库存，扣减end");
        log.info("------>订单微服务开始调用账户，扣减money");
        aservice.decrease(order.getUserId(), order.getMoney());
        log.info("------>订单微服务开始调用账户，扣减end");
        log.info("------>开始修改订单状态");
        dao.update(order.getUserId(), 0);
        log.info("------>修改订单状态完毕");
        log.info("------>下单完毕");
    }
}
