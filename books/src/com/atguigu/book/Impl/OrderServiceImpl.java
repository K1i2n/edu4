package com.atguigu.book.Impl;

import com.atguigu.book.DAO.OrderDAO;
import com.atguigu.book.DAO.OrderItemDAO;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.OrderItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemService cartItemService;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDAO.addOrderBean(orderBean);
        List<OrderItem> orderItemList = orderBean.getOrderItemList();
        for(OrderItem orderItem:orderItemList){
            orderItemDAO.addOrderItem(orderItem);
        }
        User user = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();
        for(CartItem cartItem:cartItemMap.values()){
            cartItemService.delCartItem(cartItem);
        }
    }
}
