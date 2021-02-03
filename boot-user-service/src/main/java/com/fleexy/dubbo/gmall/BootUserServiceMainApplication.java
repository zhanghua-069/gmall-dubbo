package com.fleexy.dubbo.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo// 开启基于注解的dubbo服务
@SpringBootApplication
public class BootUserServiceMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceMainApplication.class, args);
    }
}
