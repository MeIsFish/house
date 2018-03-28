package com.zkx.house.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zkx.house.user.model.User;


@Mapper
public interface UserMapper {
  
  User selectById(Long id);
  
  List<User> select(User user);
  
  int update(User user);
  
  int insert(User account);
  
  int delete(String email);
  
  User selectByEmail(String email);

}
