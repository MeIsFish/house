package com.zkx.house.houseserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zkx.house.houseserver.model.City;


@Mapper
public interface CityMapper {
  
  public List<City> selectCitys(City city);

}
