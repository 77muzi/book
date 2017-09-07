package com.bw.service.serviceimpl;

import com.bw.dao.MessageMapper;
import com.bw.pojo.Message;
import com.bw.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:09 2017/8/16
 */
@Service
@Transactional
public class MessageServiceimpl implements IMessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMessages() {
        return messageMapper.getMessages();
    }

    @Override
    public String deleteMessage(int id) {
          messageMapper.deleteMessage(id);
          return "true";
    }

    @Override
    public void addMessage(List list) {
        messageMapper.addMessage(list);
    }


    @Override
    public List<Message> queryById(int id) {
        return messageMapper.queryById(id);
    }

    @Override
    public String deleteByIds(String ids) {
          messageMapper.deleteByIds(ids);
          return "true";
    }

    @Override
    public List<Message> getMsgByName(String name) {
        return messageMapper.getMsgByName(name);
    }
}
