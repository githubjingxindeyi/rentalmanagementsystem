package com.jianghongkun.controller;

import com.jianghongkun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-11-25 16:40
 */

@Controller
public class UserRegisterController {
    @Resource
    UserService userService;
    @RequestMapping("register.do")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "addUsers.do",method = RequestMethod.POST,produces="text/html;charset=utf-8")
    @ResponseBody
    public String addUsers(@RequestParam("cardid") String cardid, @RequestParam("name") String name, @RequestParam("password") String password){
        int i = userService.addUser(cardid, name, password);
        if(i>0){
            return "<script>var result=confirm('注册已成功,现在去登陆吗？');if(result==true){location.href='login.do';}else{location.href='register.do';}</script>";
        }else{
            return "<script>alert('注册失败！');location.href='register.do';</script>";
        }
    }
}
