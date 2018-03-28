package com.zkx.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zkx.house.entity.HouseUser;
import com.zkx.house.entity.HouseUserExample;
@Mapper
public interface HouseUserMapper {
    int countByExample(HouseUserExample example);

    int deleteByExample(HouseUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseUser record);

    int insertSelective(HouseUser record);

    List<HouseUser> selectByExample(HouseUserExample example);

    HouseUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseUser record, @Param("example") HouseUserExample example);

    int updateByExample(@Param("record") HouseUser record, @Param("example") HouseUserExample example);

    int updateByPrimaryKeySelective(HouseUser record);

    int updateByPrimaryKey(HouseUser record);
}