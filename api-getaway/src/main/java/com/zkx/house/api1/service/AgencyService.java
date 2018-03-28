package com.zkx.house.api1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkx.house.api1.common.PageData;
import com.zkx.house.api1.common.PageParams;
import com.zkx.house.api1.dao.UserDao;
import com.zkx.house.api1.model.Agency;
import com.zkx.house.api1.model.ListResponse;
import com.zkx.house.api1.model.User;


@Service
public class AgencyService {
  
  @Autowired
  private UserDao userDao;
   
  
  public List<Agency> getAllAgency(){
    return userDao.getAllAgency();
  }

  public Agency getAgency(Integer id){
    return userDao.getAgencyById(id);
  }

  public void add(Agency agency) {
      userDao.addAgency(agency);
  }

  public PageData<User> getAllAgent(PageParams pageParams) {
    ListResponse<User> result =  userDao.getAgentList(pageParams.getLimit(),pageParams.getOffset());
                  Long  count  =  result.getCount();
    return PageData.<User>buildPage(result.getList(), count, pageParams.getPageSize(), pageParams.getPageNum());
  }

  
  
  public User getAgentDetail(Long id) {
    return userDao.getAgentById(id);
  }
  
  
  
  
}
