package com.zkx.house.api1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zkx.house.api1.dao.UserDao;
import com.zkx.house.api1.model.House;
import com.zkx.house.api1.service.HouseService;


@Controller
public class HomepageController {
  
  @Autowired
  private HouseService houseService;
  
  @Autowired
  private DiscoveryClient discoveryClient;
  
  @Autowired
  private UserDao userDao;
  
  @RequestMapping("index")
  public String accountsRegister(ModelMap modelMap){
    List<House> houses =  houseService.getLastest();
    modelMap.put("recomHouses", houses);
    return "/homepage/index";
  }

  @RequestMapping("")
  public String index(ModelMap modelMap){
    return "redirect:/index";
  }
}
