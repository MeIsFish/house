package com.zkx.house.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.zkx.house.api.feign.UserFeign;
import com.zkx.house.api.model.User;

@Controller
public class UserController {
	//@Autowired
	private RestTemplate template;
	@Autowired
	private UserFeign userFeign;

	//@RequestMapping("/user/list")
	//@ResponseBody
//	public String getUsers(){
//		ResponseEntity<String> response = template.getForEntity("http://127.0.0.1:8083/user/list", String.class);
//		return response.getBody();
//	}
	// feign
	@RequestMapping("/user/list")
	@ResponseBody
	public List<User> getUsers(){
		return userFeign.getUsers();
	}
	
	@GetMapping("/user/add")
	public User addUsers(User user) {
		return userFeign.addUsers(user);
	}
}
