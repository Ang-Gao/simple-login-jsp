package com.project.mapper;

import com.project.entity.User;

/*
* 用户接口类
* */
public interface UserMapper {
    public User queryUserByName(String userName);
}
