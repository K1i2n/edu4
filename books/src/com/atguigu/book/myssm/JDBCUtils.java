package com.atguigu.book.myssm;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static{


        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            //System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static Connection getConnection(){
        Connection conn = conns.get();
        if(conn==null){
            try {
                conn = dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
//    public static void close(Connection conn){
//        if(conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void commitAndClose(){
        Connection conn = conns.get();
        if(conn!=null){
            try {
                conn.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if(conn!=null){
            try {
                conn.rollback();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }

}
