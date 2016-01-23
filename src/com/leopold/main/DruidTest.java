package com.leopold.main;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2016/1/17
 * Time:17:35
 */
public class DruidTest {
    private final static Logger logger= LoggerFactory.getLogger(DruidTest.class);
    public static void main(String[] args) {
        try {
            Properties properties=new Properties();
            properties.load(new FileInputStream("resource/db.properties"));
            DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
            Connection conn=dataSource.getConnection();
            logger.error(conn.toString());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
