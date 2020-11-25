package com.jianghongkun.service;

import com.jianghongkun.pojo.User;

/**
 * @author shkstart
 * @create 2020-11-25 16:17
 */
public interface UserService {
    //注册时增加
    int addUser(String cardId,String name,String password);
}
