package com.leopold.main;

import com.leopold.util.DbUtils;
import com.leopold.util.RoundUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/10/23.
 */
public class InsertData {
    public static void main(String[] args) {
        SimpleDateFormat saf=new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        System.out.println("执行开始时间"+saf.format(new Date()));
        for(int i=0;i<1000;i++) {
            Connection conn = DbUtils.getConn();
            PreparedStatement ps = null;
            try {
                String sql = "insert into tb_user(user_no,real_name,user_name,user_pwd,age,sex," +
                        "tel,qq,address,create_time,modify_time) values(?,?,?,?,?,?,?,?,?,NOW(),NOW())";
                ps = conn.prepareStatement(sql);
                ps.setString(1, RoundUtils.getNo());
                ps.setString(2, RoundUtils.getHanzi(3));
                ps.setString(3, RoundUtils.getUname());
                ps.setString(4, RoundUtils.getNum(8));
                ps.setInt(5, Integer.parseInt(RoundUtils.getNum(2)));
                ps.setInt(6, RoundUtils.getSex());
                ps.setString(7, RoundUtils.getNum(11));
                ps.setInt(8, Integer.parseInt(RoundUtils.getNum(9)));
                ps.setString(9, RoundUtils.getHanzi(15));
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbUtils.closeSource(conn, ps);
            }
        }
        System.out.println("执行结束时间"+saf.format(new Date()));
    }
}
