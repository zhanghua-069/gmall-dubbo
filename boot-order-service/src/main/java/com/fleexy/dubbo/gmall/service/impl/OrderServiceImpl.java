package com.fleexy.dubbo.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fleexy.dubbo.gmall.bean.UserAddress;
import com.fleexy.dubbo.gmall.service.OrderService;
import com.fleexy.dubbo.gmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.0", stub = "com.fleexy.dubbo.gmall.service.stub.UserServiceStub")
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        log.info("用户id："+userId);
        //1、查询用户的收货地址
        return userService.getUserAddressList(userId);
    }
}
