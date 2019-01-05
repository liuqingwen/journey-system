package com.journey.core;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author liuqingwen
 * @date 2018/6/14.
 */
public class MySqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3307/book-system");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("x757578255");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("dev", transactionFactory, pooledDataSource);

        Configuration configuration = new Configuration(environment);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
