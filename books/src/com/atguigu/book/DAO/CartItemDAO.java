package com.atguigu.book.DAO;

import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface CartItemDAO {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    List<CartItem> getCartItemList(User user);
    void delCartItem(CartItem cartItem);
}
