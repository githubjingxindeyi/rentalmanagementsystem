package com.jianghongkun.service.impl;

import com.jianghongkun.mapper.UserMapper;
import com.jianghongkun.pojo.User;
import com.jianghongkun.pojo.UserExample;
import com.jianghongkun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-11-25 16:29
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int addUser(String cardId, String name, String password) {
        String str=cardId.toString().substring(16,17);
        Integer gender=null;
        if(str.equals("1")||str.equals("3")||str.equals("5")||str.equals("7")||str.equals("9")){
            gender=0;
        }else if(str.equals("2")||str.equals("4")||str.equals("6")||str.equals("8")||str.equals("0")){
            gender=1;
        }
        User user=new User(cardId,name,gender,new Date(),password,1);
        int i = userMapper.insertSelective(user);
        return i;
    }
}
