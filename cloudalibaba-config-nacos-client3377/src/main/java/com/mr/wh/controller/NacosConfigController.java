package com.mr.wh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: NacosConfigController
 * @Author: User
 * @date: 2020.08.13 10:41
 * @version: 1.0
 */
@RestController
@RefreshScope //SpringCloud原生注解 支持Nacos的动态刷新功能
public class NacosConfigController {
     @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
