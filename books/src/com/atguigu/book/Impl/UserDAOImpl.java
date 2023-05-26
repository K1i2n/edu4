package com.atguigu.book.Impl;

import com.atguigu.book.DAO.UserDAO;
import com.atguigu.book.myssm.BaseDao;
import com.atguigu.book.pojo.User;

public class UserDAOImpl extends BaseDao implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return null;
        //return load("select * from t_user where uname like ? and pwd like ?",uname,pwd);
    }
}
