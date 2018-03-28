package com.zkx.house.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zkx.house.user.common.PageParams;
import com.zkx.house.user.model.Agency;
import com.zkx.house.user.model.User;

@Mapper
public interface AgencyMapper {

  List<Agency> select(Agency agency);
  
  int insert(Agency agency);
  
  List<User> selectAgent(@Param("user") User user,@Param("pageParams") PageParams pageParams);
  
  Long selectAgentCount(@Param("user") User user);
}
