package com.fleexy.dubbo.gmall.service.stub;

import cn.hutool.core.util.StrUtil;
import com.fleexy.dubbo.gmall.bean.UserAddress;
import com.fleexy.dubbo.gmall.service.UserService;

import java.util.List;

/**
 * UserService本地存根实现
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    /**
     * 默认写法：定义一个接口的final对象，并实现带该对象的有参构造函数
     * dubbo会将userService的远程代理对象传入过来
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub.......");
        if(StrUtil.isNotBlank(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
