package com.atguigu.book.Impl;

import com.atguigu.book.DAO.BookDAO;
import com.atguigu.book.myssm.BaseDao;
import com.atguigu.book.pojo.Book;

import java.util.List;

public class BookDAOImpl extends BaseDao implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return null;
        //return executeQuery("select * from t_book where bookStatus = 0");
    }

    @Override
    public Book getBook(Integer id) {
        return null;
        //return load("select * from t_book where id = ?",id);
    }
}
