package com.zzy.test;

import com.zzy.dao.Userdao;
import com.zzy.dao.userImp;
import com.zzy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserImp {
    InputStream in;

    Userdao userimp;

//    设置初始方法
    @Before
    public void init() throws IOException {
        //1.创建一个字节输入流读取resources里面的内容
         in = Resources.getResourceAsStream("sqlmybatisconfig.xml");
        //2.创建一个工厂建造类使用输入流创建sqlsession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= sqlSessionFactoryBuilder.build(in);

         userimp = new userImp(factory);

    }
    @After
    public void destroy() throws IOException {

        in.close();
    }
    @Test
    public void testdemo01(){
       // 执行findall查询
        List<User> all = userimp.findAll();

        for (User user:
             all) {
            System.out.println(user);
        }




    }














}
