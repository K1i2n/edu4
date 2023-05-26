package com.atguigu.book.DAO;

import com.atguigu.book.pojo.Book;

import java.util.List;

public interface BookDAO {
    //List<Book> getBookList(Integer minPrice,Integer maxPrice,Integer pageNo);
    List<Book> getBookList();
    Book getBook(Integer id);
}
