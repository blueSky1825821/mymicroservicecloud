package com.atguigu.springcloud;

import java.sql.*;

/**
 * Created by wm on 2018/9/8.
 */
public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://47.96.154.180:8806/cloudDB01?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sql = "select * from dept";
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
            }

            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
