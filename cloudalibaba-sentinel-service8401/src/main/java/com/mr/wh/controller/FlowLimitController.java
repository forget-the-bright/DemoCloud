package com.mr.wh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
       System.out.println("testA");
       return  "--------testA";
   }
   @GetMapping("/testB")
   public String testB(){
       System.out.println("testB");
       return  "--------testB";
   }
   @GetMapping("/testC")
   public String testC(){
       try {
           TimeUnit.SECONDS.sleep(1);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("testC");
       return  "--------testC";
   }
   @GetMapping("/testD")
   @SentinelResource(value = "hotkey_TestD",blockHandler = "hotKey_Method")
   public String testD(@RequestParam(value = "p1" ,required = false) String p1,
                       @RequestParam(value = "p2" ,required = false) String p2){
       System.out.println("testD");
       return  "--------testD";
   }
   public String hotKey_Method(String p1, String p2, BlockException exc){
       return "d=====(￣▽￣*)b没错，你出错了！！！";
   }
}
