package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.service.BookService;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;
import com.atguigu.book.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;
    //private BookService bookService;
    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);

        //List<Book> bookList = bookService.getBookList();
        if(user!=null){
            Cart cart = cartItemService.getCart(user);

            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }

        return "user/login";
    }
}
