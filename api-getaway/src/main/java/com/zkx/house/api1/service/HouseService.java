package com.zkx.house.api1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Joiner;
import com.zkx.house.api1.common.PageData;
import com.zkx.house.api1.common.PageParams;
import com.zkx.house.api1.dao.HouseDao;
import com.zkx.house.api1.model.City;
import com.zkx.house.api1.model.Community;
import com.zkx.house.api1.model.House;
import com.zkx.house.api1.model.ListResponse;
import com.zkx.house.api1.model.User;
import com.zkx.house.api1.model.UserMsg;
import com.zkx.house.api1.utils.BeanHelper;

@Service
public class HouseService {
  
  
  
  @Autowired
  private FileService fileService;
  
  @Autowired
  private HouseDao houseDao;
  

  public void updateRating(Long id, Double rating) {
    houseDao.rating(id,rating);
  }

  public void addHouse(House house,User user) {
    if (house.getHouseFiles() != null && !house.getHouseFiles().isEmpty()) {
      List<MultipartFile> files = house.getHouseFiles();
      String imags = Joiner.on(",").join(fileService.getImgPaths(files));
      house.setImages(imags);
    }
    if (house.getFloorPlanFiles() != null && !house.getFloorPlanFiles().isEmpty()) {
      List<MultipartFile> files = house.getFloorPlanFiles();
      String floorPlans = Joiner.on(",").join(fileService.getImgPaths(files));
      house.setFloorPlan(floorPlans);
    }
    BeanHelper.setDefaultProp(house, House.class);
    BeanHelper.onInsert(house);
    house.setUserId(user.getId());
    houseDao.addHouse(house);
  }
  

  public List<Community> getAllCommunitys() {
    return houseDao.getAllCommunitys();
  }


  public List<City> getAllCitys() {
    return houseDao.getAllCitys();
  }


  public void addUserMsg(UserMsg userMsg) {
    houseDao.addUserMsg(userMsg);
  }


  public List<House> getLastest() {
    return houseDao.getLastest();
  }

  public PageData<House> queryHouse(House query, PageParams build) {
    ListResponse<House> result = houseDao.getHouses(query,build.getLimit(),build.getOffset());
    return PageData.<House>buildPage(result.getList(), result.getCount(), build.getPageSize(), build.getPageNum());
  }

  public List<House> getHotHouse(Integer recomSize) {
    List<House> list = houseDao.getHotHouse(recomSize);
    return list;
  }

  public House queryOneHouse(long id) {
    return houseDao.getOneHouse(id);
  }

  public void bindUser2House(Long houseId, Long userId, boolean bookmark) {
    houseDao.bindUser2House(houseId,userId,bookmark);
  }

  public void unbindUser2House(Long id, Long id2, boolean b) {
    houseDao.unbindUser2House(id,id2,b);
  }




}
