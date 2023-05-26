package com.atguigu.book.service;


import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    //拿到book的详细信息
    List<CartItem> getCartItemList(User user);
    Cart getCart(User user);
    void delCartItem(CartItem cartItem);
}
