package com.jianghongkun.service;

import com.github.pagehelper.PageInfo;
import com.jianghongkun.pojo.RealEstate;


public interface RealEstateService {
    //查询
    public PageInfo<RealEstate> selectByName(String cardId,Integer pageNum,Integer pageSize);
}

