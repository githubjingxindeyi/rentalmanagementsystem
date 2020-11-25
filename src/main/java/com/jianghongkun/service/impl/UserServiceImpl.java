package com.jianghongkun.service.impl;


import com.jianghongkun.mapper.UserMapper;
import com.jianghongkun.pojo.User;
import com.jianghongkun.pojo.UserExample;
import com.jianghongkun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
//事务的注解
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUserByNamePassword(String cardId, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (cardId!=null && cardId.length()>0){
            criteria.andCardIdEqualTo(cardId);
        }
        if (password!=null && password.length()>0){
            criteria.andPasswordEqualTo(password);
        }
        List<User> users = userMapper.selectByExample(example);
        if (users!=null && users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean registUser(User user) {
        int i = userMapper.insertSelective(user);
        return i>0?true:false;
    }

    @Override
    public User selectByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (name!=null && name.length()>0){
            criteria.andNameEqualTo(name);
        }
        List<User> users = userMapper.selectByExample(example);
        if (users!=null&& users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
