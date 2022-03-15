package com.project.service;

import com.project.entity.User;
import com.project.entity.valueObject.MessageModel;
import com.project.mapper.UserMapper;
import com.project.util.GetSqlSession;
import com.project.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/*
* 业务逻辑
* */
public class UserService {
    public MessageModel userLogin(String uname, String pwd) {
        MessageModel messageModel = new MessageModel();
        User user = new User();
        user.setUserName(uname);
        user.setUserPassword(pwd);
        messageModel.setObject(user);
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(pwd)){
            messageModel.setCode(0);
            messageModel.setMsg("用户和密码不能为空");
            return messageModel;
        }

        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        user = userMapper.queryUserByName(uname);

        if (user == null){
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在");
            return messageModel;
        }

        if (!user.getUserPassword().equals(pwd)){
            messageModel.setCode(0);
            messageModel.setMsg("密码错误");
            user.setUserName(uname);
            user.setUserPassword(pwd);
            return messageModel;
        }
        messageModel.setMsg("登录成功");
        messageModel.setCode(1);
        return messageModel;
    }
}
