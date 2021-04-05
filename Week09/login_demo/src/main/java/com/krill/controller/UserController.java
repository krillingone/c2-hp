package com.krill.controller;

import com.krill.entity.User;
import com.krill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //用户注册
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("name") String name,
                           @RequestParam("mobile") String mobile,
                           @RequestParam("sex") String sex,
                           @RequestParam("birthday") String birthday)
            throws Exception {

        //调用业务层方法
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setMobile(mobile);
        user.setSex((sex.equals("male")) ? "1" : "0");
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        boolean regInfo = userService.register(user);
        if (regInfo) {
            return "注册成功！";
        } else {
            return "账号已存在！";
        }
    }
    //用户登录
    @RequestMapping("/login")
    public String login( @RequestParam("mobile") String mobile,
                         @RequestParam("password") String password) {
        //调用业务层方法
        boolean flag = userService.login(mobile,password);
        if(flag){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
    //查询用户信息
    @RequestMapping("/findById")
    public User findById(@RequestParam("id") int id){
        //调用业务层方法
        return userService.findById(id);
    }
}

