package com.bw.controller;

import com.bw.pojo.Message;
import com.bw.pojo.User;
import com.bw.service.IMessageService;
import com.bw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:10 2017/8/16
 */
@Controller
@RequestMapping("message")
public class MessageContoller {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    //查询所有信息
    @RequestMapping("/queryMessages")
    public String queryMessage(Model model) {
        List<Message> messages = messageService.getMessages();
        List<User> name = userService.getUserName();
        model.addAttribute("messages", messages);
        model.addAttribute("names", name);
        return "readMsg";
    }

    //删除信息
    @RequestMapping("deleteMessage")
    @ResponseBody
    public String deleteMessage(int mid) {
        String flag = messageService.deleteMessage(mid);
        return flag;
    }

    //添加信息
    @RequestMapping(value = "/addMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addMessage(String msg, String argent, String ids) throws Exception {
       // msg = URLDecoder.decode(msg, "UTF-8"); //解决中文乱码
        //argent= URLDecoder.decode(argent,"UTF-8");

        List<Message> list= new ArrayList<Message>();
        Map<String,Object> map=new HashMap<String,Object>();

        String[] ids1 = ids.split(",");

        for (String id : ids1) {
            User user = new User();
            Message m = new Message();
            m.setContent(msg);

            user.setId(Integer.parseInt(id));

            m.setArgent( Integer.parseInt(argent));

            Date date = new Date();
            m.setCreatetime(date);

            m.setUser(user);

            list.add(m);
        }
        messageService.addMessage(list);
        int count=1;
        map.put("result",count);
        return map;
    }

    //根据id查询信息
    @RequestMapping("/queryById")
    @ResponseBody
    public List<Message> queryById( int id) {
       return  messageService.queryById(id);
    }

    //批量删除
    @RequestMapping("deleteByIds")
    @ResponseBody
    public String deleteByIds(String ids){
        String flag = messageService.deleteByIds(ids);
        return flag;
    }

    //模糊查询
    @RequestMapping("getMsgByName")
    public String getMsgNyName(String userName,Model model){
        List<Message> msg = messageService.getMsgByName(userName);
        model.addAttribute("messages",msg);
        List<User> names = userService.getUserName();
        model.addAttribute("names", names);
        return "readMsg";
    }
}
