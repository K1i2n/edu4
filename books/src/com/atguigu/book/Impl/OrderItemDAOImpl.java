package com.atguigu.book.Impl;

import com.atguigu.book.DAO.OrderItemDAO;
import com.atguigu.book.myssm.BaseDao;
import com.atguigu.book.pojo.OrderItem;

public class OrderItemDAOImpl extends BaseDao implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        //super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }
}
