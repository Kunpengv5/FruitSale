package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.UserEntity;
import com.fruitsalesplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        map.put("username",user.getName());
        map.put("password",user.getPassword());

        List<UserEntity> userList = userService.find(map);
        if (userList!=null&& userList.size()>0){
            request.getSession().setAttribute("user",userList.get(0));
            return "/home.jsp";
        }
        model.addAttribute("errMessage","登录失败，账号或者密码错误");
        return "/login.jsp";
    }
}
