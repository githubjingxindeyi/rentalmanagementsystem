package com.jianghongkun.service;


import com.jianghongkun.pojo.User;

public interface UserService {
    //登录
    User getUserByNamePassword(String cardId, String password);
    //注册
    public int addUser(String cardId, String name, String password);
    //根据name查询
    public User selectByName(String name);
}
