package com.zkx.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zkx.house.entity.HouseMsg;
import com.zkx.house.entity.HouseMsgExample;
@Mapper
public interface HouseMsgMapper {
    int countByExample(HouseMsgExample example);

    int deleteByExample(HouseMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseMsg record);

    int insertSelective(HouseMsg record);

    List<HouseMsg> selectByExample(HouseMsgExample example);

    HouseMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseMsg record, @Param("example") HouseMsgExample example);

    int updateByExample(@Param("record") HouseMsg record, @Param("example") HouseMsgExample example);

    int updateByPrimaryKeySelective(HouseMsg record);

    int updateByPrimaryKey(HouseMsg record);
}