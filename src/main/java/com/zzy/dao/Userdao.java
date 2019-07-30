package com.zzy.dao;

import com.zzy.domain.User;
import com.zzy.domain.User1;
import com.zzy.domain.queryVO;

import java.util.List;

public interface Userdao {
    public List<User> findAll();

    public void  insertUser();

    public void  deleteUser(int id);

    public  void  updateUser(User user);

   public void   saveUser(User user);

    public User  findUserById(int id);

    public List<User> findByName(String username);
    public List<User> findByName2(String username);

    public int countUser();

   public  List<User> findByQueryVoName(queryVO queryVO);

   public List<User1> findAllbyDifferentName();
}
