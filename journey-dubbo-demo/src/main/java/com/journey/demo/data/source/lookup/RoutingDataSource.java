package com.journey.demo.data.source.lookup;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();
        connection.prepareStatement("set names utf8mb4").executeQuery();
        return connection;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceHolder.getDataSourceLookupKey();
    }
}
