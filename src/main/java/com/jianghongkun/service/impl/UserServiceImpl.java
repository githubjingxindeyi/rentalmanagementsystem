package com.jianghongkun.service.impl;
import com.jianghongkun.mapper.UserMapper;
import com.jianghongkun.pojo.User;
import com.jianghongkun.pojo.UserExample;
import com.jianghongkun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
    public User selectByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (name != null && name.length() > 0) {
            criteria.andNameEqualTo(name);
        }
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
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
