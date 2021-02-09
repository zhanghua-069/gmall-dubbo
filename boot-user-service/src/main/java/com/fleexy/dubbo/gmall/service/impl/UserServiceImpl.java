package com.fleexy.dubbo.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fleexy.dubbo.gmall.bean.UserAddress;
import com.fleexy.dubbo.gmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Component
public class UserServiceImpl implements UserService {

    @Value("${serviceimpl.num}")
    private String num;

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        log.info("UserServiceImpl....." + num + "...");
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
        /*try {
            TimeUnit.SECONDS.sleep(2L);// 设置服务请求超时，模拟服务容错场景
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if(Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1,address2);
    }
}
