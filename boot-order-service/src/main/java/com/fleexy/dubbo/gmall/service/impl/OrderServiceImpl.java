package com.fleexy.dubbo.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fleexy.dubbo.gmall.bean.UserAddress;
import com.fleexy.dubbo.gmall.service.OrderService;
import com.fleexy.dubbo.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

//    @Reference(version = "1.0.0", stub = "com.fleexy.dubbo.gmall.service.stub.UserServiceStub")
//    @Reference(url = "127.0.0.1:20880")// 直接dubbo服务
//    @Reference(loadbalance = "roundrobin")
    @Reference(timeout = 1000)
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        log.info("用户id："+userId);
        //1、查询用户的收货地址
        return userService.getUserAddressList(userId);
    }

    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }
}
