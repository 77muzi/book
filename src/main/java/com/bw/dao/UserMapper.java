package com.bw.dao;

import com.bw.pojo.User;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:04 2017/8/16
 */
public interface  UserMapper {
    //登录
    public User userLogin(User user);

    //查询姓名
    public List<User> getUserName();

    //查询个人资料
    public User getMyMsg(int id);

    //修改个人资料
    public void updateUser(User user);

    //注册
    public void regUser(User user);

    //验证姓名
    public int checkName(String name);
}
