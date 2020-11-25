package com.jianghongkun.service;


import com.jianghongkun.pojo.User;

public interface UserService {
    //注册
    public int addUser(String cardId, String name, String password);
    //根据name查询
    public User selectByName(String name);
}
