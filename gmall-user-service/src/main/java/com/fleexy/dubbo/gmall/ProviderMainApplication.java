package com.fleexy.dubbo.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderMainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();

        System.in.read();// 阻塞进程，直到输入任意一个字符结束进程
    }
}
