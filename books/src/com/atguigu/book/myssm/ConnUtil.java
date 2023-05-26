package com.atguigu.book.myssm;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

//    public static  String DRIVER ;
//    public static  String URL ;
//    public static  String USER ;
//    public static  String PWD ;
    static Properties properties = new Properties();
    static {
        InputStream resourceAsStream = ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(resourceAsStream);
//            DRIVER = properties.getProperty("jdbc.driver");
//            URL = properties.getProperty("jdbc.url");
//            USER = properties.getProperty("jdbc.user");
//            PWD = properties.getProperty("jdbc.pwd");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConn(){
        try{
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            return dataSource.getConnection();


        }catch (SQLException  e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Connection getConn(){
        Connection conn = threadLocal.get();
        if(conn==null){
            conn = createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn==null){
            return ;
        }
        if(!conn.isClosed()){
            conn.close();
            threadLocal.set(null);
        }
    }
}
