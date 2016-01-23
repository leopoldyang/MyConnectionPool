package com.leopold.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/10/23.
 */
public class DbUtils {
    private static final String url="jdbc:mysql://localhost:3306/db_shop";
    private static final String uname="root";
    private static final String pwd="123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,uname,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeSource(Connection conn,PreparedStatement ps){
        try {
            if(null!=ps) {
                ps.close();
            }
            if(null!=conn){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
