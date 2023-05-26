package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.CartItemService;

import javax.servlet.http.HttpSession;

public class CartController {
    private CartItemService cartItemService;
    public String index(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";

    }

    public String addCart(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(1,new Book(bookId),user);
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());

        return "redirect:cart.do";
    }
}
