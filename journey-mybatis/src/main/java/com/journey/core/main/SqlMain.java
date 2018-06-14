package com.journey.core.main;

import com.journey.core.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/6/14.
 */
public class SqlMain {

    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Object> objects = sqlSession.selectList("select * from books");
        System.out.println(objects);

    }

}
