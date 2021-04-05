package com.krill.service;

import com.krill.dao.UserMapper;
import com.krill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    //用户注册
    public boolean register(User user) {
        //调用 dao 层的方法
        User userSelect = userMapper.findByMobile(user.getMobile());
        if (userSelect != null)
            return false;
        userMapper.register(user);
        return true;
    }
    //用户登录
    public boolean login(String mobile, String password) {
        //调用 dao 层的方法
        User user = userMapper.login(mobile,password);
        if(user==null){ return false;
        }else {
            return true;
        }
    }
    //查询用户信息
    public User findById(int id) {
        //调用 dao 层的方法
        return userMapper.findById(id);
    }
}

