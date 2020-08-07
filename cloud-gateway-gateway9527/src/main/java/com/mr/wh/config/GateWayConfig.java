package com.mr.wh.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu1",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        routes.route("path_route_baidu2",//路由id唯一
                r->r.path("/guonei") //断言路径
                        .uri("http://news.baidu.com/guonei")).build(); //映射地址

        return routes.build();
    }
}
