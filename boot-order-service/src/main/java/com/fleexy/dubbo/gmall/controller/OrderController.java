package com.fleexy.dubbo.gmall.controller;

import com.fleexy.dubbo.gmall.bean.UserAddress;
import com.fleexy.dubbo.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("userId") String userId) {
        return orderService.initOrder(userId);
    }
}
