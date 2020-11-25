package com.jianghongkun.service;


import com.jianghongkun.pojo.User;

public interface UserService {
    //登录
    public User getUserByNamePassword(String cardId, String password);
    //注册
    public boolean registUser(User user);
    //根据name查询
    public User selectByName(String name);

}
