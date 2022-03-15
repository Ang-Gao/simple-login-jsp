package com.project.test;

import com.project.entity.User;
import com.project.mapper.UserMapper;
import com.project.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
//测试连通性
public class Test01 {
    public static void main(String[] args) {
        SqlSession session = GetSqlSession.createSqlSession();
        System.out.println(session);
        //get mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        System.out.println(userMapper);
        User user = userMapper.queryUserByName("admin");
        System.out.println(user.getUserPassword());
    }
}
