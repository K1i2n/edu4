package com.atguigu.book.Impl;

import com.atguigu.book.DAO.OrderDAO;
import com.atguigu.book.myssm.BaseDao;
import com.atguigu.book.pojo.OrderBean;

public class OrderDAOImpl extends BaseDao implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {

        //int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        //自增列 需要赋值
        //orderBean.setId(orderBeanId);
    }
}
