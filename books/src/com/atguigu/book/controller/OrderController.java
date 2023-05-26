package com.atguigu.book.controller;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.service.OrderService;

import java.util.Date;
import java.util.UUID;

public class OrderController {
    private OrderService orderService;
    public String checkout(){
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        int year = now.getYear();
        orderBean.getOrderNo(UUID.randomUUID().toString());


        orderService.addOrderBean(orderBean);

        return "index";
    }
}
