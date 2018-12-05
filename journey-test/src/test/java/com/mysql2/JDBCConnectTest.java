package com.mysql2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liuqingwen
 * @date 2018/12/1.
 */
public class JDBCConnectTest {

    @Test
    public void test() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/test");
            connection.prepareStatement("set names utf8mb4").executeQuery();
            ResultSet resultSet = connection.prepareStatement("select * from t_user").executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getObject("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
