package com.bw.service.serviceimpl;

import com.bw.dao.UserMapper;
import com.bw.pojo.User;
import com.bw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:06 2017/8/16
 */
@Service
@Transactional
public class UserServiceimpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public List<User> getUserName() {
        return userMapper.getUserName();
    }

    @Override
    public User getMyMsg(int id) {
        return userMapper.getMyMsg(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void regUser(User user) {
        userMapper.regUser(user);
    }

    @Override
    public String checkName(String name) {
       if(userMapper.checkName(name)>0){
           return "true";
       }
        return "false";
    }
}
