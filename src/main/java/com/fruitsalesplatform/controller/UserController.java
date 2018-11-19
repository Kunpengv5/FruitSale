package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.UserEntity;
import com.fruitsalesplatform.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author dukunpeng
 * @date 2018/11/15 16:14
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        //转向登录页面
        return "/login.jsp";
    }

    @RequestMapping(value = "/login")
    public String login(UserEntity user, Model model, HttpServletRequest request){

        Map<String,String> map = new HashMap<String, String>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());

        List<UserEntity> userList = userService.find(map);
        if (userList!=null&& userList.size()>0){
            request.getSession().setAttribute("user",userList.get(0));
            return "/home.jsp";
        }
        model.addAttribute("errorMsg","登录失败，账号或者密码错误");
        return "/login.jsp";
    }



    @RequestMapping(value="/registerPage")
    public String toRegister(){
        //转向注册页面
        return "/register.jsp";
    }

    @RequestMapping(value = "/register")
    public String register(UserEntity user, Model model, HttpServletRequest request, HttpServletResponse response){
       /*   先判断提交的是否为空
            再判断提交的在系统中是否存在，若是存在提示：   若是不存在，则进行注册逻辑
            最后再返回注册的是否成功
        }*/
       if(user==null||StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())
       ||StringUtils.isBlank(user.getName())||StringUtils.isBlank(user.getTelphone())){
           System.out.println("注册用户测试断点");
           model.addAttribute("errorMsg","必填项输入为空，请检查后重新输入");
           return "/register.jsp";
       }else{
           //判断系统中是否存在要注册的用户
           Map<String,String> map = new HashMap<String, String>();
           map.put("username",user.getUsername());
           map.put("password",user.getPassword());

           List<UserEntity> userList = new ArrayList<UserEntity>();
           userList = userService.find(map);
           if (userList!=null&&userList.size()>0){
               //此处留有一个bug，相同的用户名，只要其他内容不同，都可以注册成功
               model.addAttribute("errorMsg","注册的用户在系统中已经存在了，请直接登录或者换一个账号注册吧~");
               return "/register.jsp";
           }else {
               user.setUserid(UUID.randomUUID().toString());
               userService.insert(user);
               model.addAttribute("noticeMsg","注册成功！请输入账户密码登录吧~");
               return "/login.jsp";
           }


       }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
//        request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        return "/login.jsp";
    }

}
