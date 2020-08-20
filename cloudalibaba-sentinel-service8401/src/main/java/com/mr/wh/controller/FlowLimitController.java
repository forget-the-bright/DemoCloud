package com.mr.wh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: FlowLimitController
 * @Author: User
 * @date: 2020.08.19 20:58
 * @version: 1.0
 */
@RestController
public class FlowLimitController {
   @GetMapping("/testA")
   public String testA(){
       return  "--------testA";
   }
   @GetMapping("/testB")
   public String testB(){
       return  "--------testB";
   }
}
