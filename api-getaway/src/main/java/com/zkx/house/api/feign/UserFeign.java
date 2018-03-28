package com.zkx.house.api.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zkx.house.api.model.User;

@FeignClient("user")
public interface UserFeign {
	
	//@RequestMapping(value="/user/list",method=RequestMethod.GET)
	@GetMapping("/user/list")
	List<User> getUsers();
	
	@GetMapping("/user/add")
	User addUsers(User user);
	
	
	
	
	
	
}
