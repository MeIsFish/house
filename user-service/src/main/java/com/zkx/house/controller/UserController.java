package com.zkx.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkx.house.entity.User;
import com.zkx.house.entity.UserExample;
import com.zkx.house.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	
	@RequestMapping("/user/list")
	@ResponseBody
	public List<User> getUsers(){
		return userMapper.selectByExample(new UserExample());
	}
	@RequestMapping("/user/add")
	@ResponseBody
	public User addUser(User user){
		return user;
	}
}
