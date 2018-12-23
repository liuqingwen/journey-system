package com.journey;

import com.journey.dao.TaskMapper;
import com.journey.entity.Task;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liuqingwen
 * @date 2018/12/23.
 */
public class MapperMain {

    public static void main(String[] args) {

        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
            Task task = taskMapper.getTask(1);
            System.out.println(task);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
