package com.zzy.dao;

import com.zzy.domain.User;
import com.zzy.domain.User1;
import com.zzy.domain.queryVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
//创建Uerdao的子实现类
public class userImp implements Userdao{

    SqlSessionFactory sFactory;

    public userImp(SqlSessionFactory sqlSessionFactory) {
        this.sFactory = sqlSessionFactory;
    }







    public List<User> findAll() {

        SqlSession sqlSession = sFactory.openSession();

        //4.使用sqlSession执行查询

        List<User> list = sqlSession.selectList("com.zzy.dao.Userdao.findAll");



        sqlSession.close();
        return list;

    }

    public void insertUser() {

    }

    public void deleteUser(int id) {

    }

    public void updateUser(User user) {

    }

    public void saveUser(User user) {

    }

    public User findUserById(int id) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public List<User> findByName2(String username) {
        return null;
    }

    public int countUser() {
        return 0;
    }

    public List<User> findByQueryVoName(queryVO queryVO) {
        return null;
    }

    public List<User1> findAllbyDifferentName() {
        return null;
    }
}
