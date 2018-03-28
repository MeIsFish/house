package com.zkx.house.houseserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zkx.house.houseserver.common.LimitOffset;
import com.zkx.house.houseserver.model.Community;
import com.zkx.house.houseserver.model.House;
import com.zkx.house.houseserver.model.HouseUser;
import com.zkx.house.houseserver.model.UserMsg;


@Mapper
public interface HouseMapper {

  int insert(House house);
  
  List<House> selectHouse(@Param("house") House query,@Param("pageParams") LimitOffset limitOffset);
  
  Long selectHouseCount(@Param("house") House query);
  
  List<Community> selectCommunity(Community community);
  
  int insertUserMsg(UserMsg userMsg);
  
  int updateHouse(House house);
  
  HouseUser selectHouseUser(@Param("userId") long userID,@Param("id") long id,@Param("type") int type);
  
  HouseUser selectHouseUserById(@Param("id") long id,@Param("type") int type);
  
  int insertHouseUser(HouseUser houseUser);
  
  int delete(Long id);
  
  int downHouse(Long id);
  
  int deleteHouseUser(@Param("id") Long id,@Param("userId") Long userId,@Param("type") Integer type);
  
  
}

