package com.bw.service;

import com.bw.pojo.User;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:05 2017/8/16
 */
public interface IUserService {
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
    public String checkName(String name);
}
