package com.fleexy.dubbo.gmall;

import com.fleexy.dubbo.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = ioc.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("服务调用完成...");
        System.in.read();
    }
}
