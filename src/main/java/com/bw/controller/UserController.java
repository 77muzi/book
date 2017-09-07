package com.bw.controller;

import com.bw.pojo.User;
import com.bw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:08 2017/8/16
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    //用户登录
    @RequestMapping(value = "userLogin",method = RequestMethod.POST)
    public String userLogin(User user, HttpSession session, Model model){
        User user1 = userService.userLogin(user);
        if(user1!=null){
            session.setAttribute("user",user1);
            return "main";
        }else{
            model.addAttribute("result","用户名或密码错误");
            return "../index";
        }
    }
    // 查询个人资料
    @RequestMapping("queryMyMsg")
    public String queryMyMsg(Model model,HttpSession session){
        User user=(User)  session.getAttribute("user");
        User myMsg = userService.getMyMsg(user.getId());
        model.addAttribute("myMsg",myMsg);
        return "myMsg";
    }

    //查询用户姓名
    @RequestMapping("/queryName")
    public ModelAndView queryName() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userName = userService.getUserName();
        modelAndView.addObject("names",userName);
        modelAndView.setViewName("send");
        return modelAndView;
    }

    //去修改页面
    @RequestMapping("toUpdate")
    public String toUpdate(Model model,HttpSession session){
        User user=(User)  session.getAttribute("user");
        User myMsg = userService.getMyMsg(user.getId());
        model.addAttribute("myMsg",myMsg);
        return "UserUpdate";
    }


    //修改个人资料
    @RequestMapping("updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/queryMyMsg.action";
    }

    @InitBinder
    public void initBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    //去注册页面
    @RequestMapping(value = "toReg",method = RequestMethod.GET)
    public String toReg(){
        return "reg";
    }

    //注册用户
    @RequestMapping(value = "userReg",method = RequestMethod.POST)
    public String userReg(User user,Model model){
        userService.regUser(user);
        return "../index";
    }

    //验证姓名
    @RequestMapping(value = "checkName",method = RequestMethod.GET)
    @ResponseBody
    public String checkName(String name) throws Exception {
        name=URLDecoder.decode(name,"utf-8");
        String flag = userService.checkName(name);
        return flag;
    }

}
