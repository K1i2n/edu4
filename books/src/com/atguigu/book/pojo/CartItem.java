package com.atguigu.book.pojo;

public class CartItem {
    private Integer id;
    private Integer BuyCount;
    private Book book;
    private User userBean;

    public CartItem() {
    }

    public CartItem(Integer buyCount, Book book, User userBean) {
        BuyCount = buyCount;
        this.book = book;
        this.userBean = userBean;
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public Integer getBuyCount() {
        return BuyCount;
    }

    public void setBuyCount(Integer buyCount) {
        BuyCount = buyCount;
    }
}
