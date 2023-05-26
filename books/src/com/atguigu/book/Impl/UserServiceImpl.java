package com.atguigu.book.Impl;

import com.atguigu.book.DAO.UserDAO;
import com.atguigu.book.service.UserService;
import com.atguigu.book.pojo.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        //return null;
        return userDAO.getUser(uname,pwd);
    }
}
