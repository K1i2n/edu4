package com.atguigu.book.myssm;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {



    public static void beginTran() throws SQLException {
        ConnUtil.getConn().setAutoCommit(false);
    }

    public static void commit() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        ConnUtil.closeConn();

    }

    public static void rollback() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        ConnUtil.closeConn();
    }


}
