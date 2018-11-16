package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.UserEntity;
import com.fruitsalesplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/findUserDemo")
	private String findUser(UserEntity user, Model model){
		List<UserEntity> userList=testService.get(user);
		model.addAttribute("userList",userList);
		model.addAttribute("name","测试一下显示");
		return "/demo.jsp";
	}
	
}
