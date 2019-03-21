package com.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class MybatisFirst {


    // 根据用户id查询用户信息
    @Test
    public void findUserById() throws IOException {
        // 全局配置文件
        String resource = "SqlMapConfig.xml";

        // 创建配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlsession操作数据库
        // 第一个参数：statemnet的id，是namespace+"."+statemnet的id
        // 第二个参数：输入 参数
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        // 关闭sqlsession
        sqlSession.close();

    }

    // 根据用户名称询用户信息
    @Test
    public void findUserByName() throws IOException {
        // 全局配置文件
        String resource = "SqlMapConfig.xml";

        // 创建配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlsession操作数据库
        // 第一个参数：statemnet的id，是namespace+"."+statemnet的id
        // 第二个参数：输入 参数
        List<User> list = sqlSession.selectList("test.findUserByName", "张");

        System.out.println(list);

        // 关闭sqlsession
        sqlSession.close();

    }

}
