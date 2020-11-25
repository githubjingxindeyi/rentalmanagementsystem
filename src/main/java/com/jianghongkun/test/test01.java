package com.jianghongkun.test;

import com.jianghongkun.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-11-25 16:45
 */

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class test01 {
    @Resource
    UserService userService;
    @Test
    public void test01(){
        int i = userService.addUser("166622227777265365", "小花", "123456");
        System.out.println(i);
    }
}
