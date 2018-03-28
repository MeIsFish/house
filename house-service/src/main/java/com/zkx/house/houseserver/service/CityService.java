package com.zkx.house.houseserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkx.house.houseserver.mapper.CityMapper;
import com.zkx.house.houseserver.model.City;


@Service
public class CityService {
  
  @Autowired
  private CityMapper cityMapper;
  
  public List<City> getAllCitys(){
    City query = new City();
    return cityMapper.selectCitys(query);
  }

}
