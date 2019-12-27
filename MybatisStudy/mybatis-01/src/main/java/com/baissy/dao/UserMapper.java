package com.baissy.dao;

import com.baissy.poio.User;

import java.util.List;

public interface UserMapper{
    List<User> getUserList();
    User getUserById(int id);
    int addUser(User user);
    int updataUser(User user);
    int deleteUser(int id);
}
