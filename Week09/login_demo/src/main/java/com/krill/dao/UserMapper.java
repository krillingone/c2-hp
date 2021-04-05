package com.krill.dao;

import com.krill.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //用户注册
    void register(User user);

    //用户登录
    User login(@Param("mobile") String mobile, @Param("passwd") String password);

    //查询用户信息
    User findById(int id);

    // 根据手机号查询用户
    User findByMobile(String mobile);
}

