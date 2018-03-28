package com.zkx.house.api1.controller;

import java.util.Map;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zkx.house.api1.common.ResultMsg;


public class ControllerHelper {
  
  public static void addFlashAttributes(RedirectAttributes redirectAttributes,Map<String, String> map){
    map.forEach((key,value)-> redirectAttributes.addFlashAttribute(key, value));
  }
  
  public static void addFlashAttributes(RedirectAttributes redirectAttributes,ResultMsg resultMsg){
     addFlashAttributes(redirectAttributes, resultMsg.asMap());
  }

}
