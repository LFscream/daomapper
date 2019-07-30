package com.zzy.test;

import com.zzy.dao.Userdao;
import com.zzy.domain.User;
import com.zzy.domain.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.jgss.GSSUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import com.zzy.domain.queryVO;

public class TestMybatismapper {



   InputStream resourceAsStream;

    SqlSession sqlSession;

    Userdao proxyUserDao;



    // 在测试前进行,init初始
    @Before
    public void init() throws IOException {

        //1.读取配置文件,io文件输入流
        resourceAsStream = Resources.getResourceAsStream("sqlmybatisconfig.xml");
        //2.读取文件输入流构建工厂类sqlsessionFactory
        //先得到一个工厂建造流
        SqlSessionFactoryBuilder sff = new SqlSessionFactoryBuilder();

        SqlSessionFactory buildsession = sff.build(resourceAsStream);
        //3.使用sqlsessionFactory类创建sqlsession


         sqlSession = buildsession.openSession();


        //4.使用sqlsession构建Dao的代理对象,使用代理
         proxyUserDao = sqlSession.getMapper(Userdao.class);











    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        resourceAsStream.close();
    }

    //查询所有
    @Test
    public void testdemo1() throws IOException {


        //5.执行sql方法
        List<User> list = proxyUserDao.findAll();
        //6.遍历结果集
        for (User user:
             list) {
            System.out.println(user);
        }




    }
    //增加记录
    @Test
    public  void  testdemo02(){
        proxyUserDao.insertUser();
    }
    //删除记录
    @Test
    public  void  testdemo03(){
        proxyUserDao.deleteUser(72);
    }
    //改
    @Test
    public  void  testdemo04(){
        User user=new User();
        user.setUsername("渣渣辉");
        user.setAddress("斗罗大陆");
        user.setSex("神");
        user.setBirthday(new Date());
        user.setId(72);
        proxyUserDao.updateUser(user);
        System.out.println(user);
    }
    //保存用户,增
    @Test
    public  void  testdemo05(){
        User user = new User();
        user.setAddress("深圳大仲马会所");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("古天乐");
        System.out.println("保存操作之前："+user);
        proxyUserDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }
    //根据id,主键查询
    @Test
    public void  testDemo06(){
        User userById = proxyUserDao.findUserById(67);
        System.out.println(userById);

    }
    //模糊查询
    @Test
    public void  testDemo07(){
        List<User> byName = proxyUserDao.findByName("%王%");
        System.out.println(byName);

    }
    //模糊查询2
    @Test
    public void  testDemo08(){
        List<User> byName = proxyUserDao.findByName2("王");
        System.out.println(byName);

    }
    //聚合函数
    @Test
    public void  testDemo09(){
        int i = proxyUserDao.countUser();
        System.out.println(i);

    }
    //需求：根据用户名查询用户信息，查询条件放到QueryVo的user属性中
    @Test
    public void  testDemo10(){

        queryVO queryvO = new queryVO();


        User user = new User();
        user.setUsername("%王%");

        queryvO.setUser(user);







        List<User> byName = proxyUserDao.findByQueryVoName(queryvO);


        for (User user1:
             byName) {
            System.out.println(user1);
        }





    }
    //当数据库中名字跟dao中的名字不一致时查询所有
    @Test
    public void testdemo11() throws IOException {


        //5.执行sql方法
        List<User1> list = proxyUserDao.findAllbyDifferentName();
        //6.遍历结果集
        for (User1 user:
                list) {
            System.out.println(user);
        }




    }
}
