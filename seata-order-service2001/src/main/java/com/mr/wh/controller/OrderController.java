package com.mr.wh.controller;

import com.mr.wh.domain.CommonResult;
import com.mr.wh.domain.Order;
import com.mr.wh.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: OrderController
 * @Author: User
 * @date: 2020.08.24 20:21
 * @version: 1.0
 */
@RestController
public class OrderController {
  @Resource
  private OrderService service;
  @GetMapping("/order/create")
  public CommonResult create(Order order){
      service.create(order);
      return new CommonResult(200, "订单创建成功");
  }
}
