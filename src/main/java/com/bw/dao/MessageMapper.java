package com.bw.dao;

import com.bw.pojo.Message;

import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:05 2017/8/16
 */
public interface  MessageMapper {
    //查询所有信息
    public List<Message> getMessages();

    //删除信息
    public void deleteMessage(int id);

    //添加信息
    public void addMessage(List list);

    //根据id查询信息
    public List<Message> queryById(int id);

    //批量删除信息
    public void deleteByIds(String ids);

    //模糊查询
    public List<Message> getMsgByName(String name);
}
