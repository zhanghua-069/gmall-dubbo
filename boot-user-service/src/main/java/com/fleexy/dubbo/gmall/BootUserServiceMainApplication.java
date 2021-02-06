package com.fleexy.dubbo.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBoot与dubbo整合的三种方式：
 * 1）导入dubbo-starter，在application.properties配置属性，使用@Service暴露服务，使用@Reference调用服务
 * 2）保留dubbo xml配置文件；导入dubbo-starter，使用@ImportResource导入dubbo的配置文件
 *      （不需要添加@EnableDubbo注解，application.properties文件也不需要添加dubbo相关配置）
 * 3）使用注解API的方式：将每一个组件手动创建到容器中,让dubbo来扫描其他的组件
 *    dubbo扫描组件：@EnableDubbo，@DubboComponentScan(basePackages = "com.fleexy.dubbo.gmall")
 */
//@EnableDubbo// 开启基于注解的dubbo服务
//@ImportResource(locations = { "classpath:provider.xml" })
@DubboComponentScan(basePackages = "com.fleexy.dubbo.gmall")
@SpringBootApplication
public class BootUserServiceMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceMainApplication.class, args);
    }
}
