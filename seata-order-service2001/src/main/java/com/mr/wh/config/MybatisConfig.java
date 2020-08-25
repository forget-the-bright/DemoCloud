package com.mr.wh.config;

/**
 * @Description:
 * @ClassName: MybatisConfig
 * @Author: User
 * @date: 2020.08.24 20:27
 * @version: 1.0
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.mr.wh.dao"})
public class MybatisConfig {

}
