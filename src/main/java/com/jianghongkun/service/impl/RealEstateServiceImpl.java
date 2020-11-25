package com.jianghongkun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianghongkun.mapper.RealEstateMapper;
import com.jianghongkun.pojo.RealEstate;
import com.jianghongkun.pojo.RealEstateExample;
import com.jianghongkun.service.RealEstateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RealEstateServiceImpl implements RealEstateService {
    @Resource
    RealEstateMapper realEstateMapper;
    @Override
    public PageInfo<RealEstate> selectByName(String cardId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id asc");
        RealEstateExample realEstateExample = new RealEstateExample();
        RealEstateExample.Criteria criteria = realEstateExample.createCriteria();
        if (cardId!=null){
            criteria.andCardIdEqualTo(cardId);
        }
        List<RealEstate> realEstates = realEstateMapper.selectByExample(realEstateExample);
        PageInfo<RealEstate> pageInfo = new PageInfo<>(realEstates);
        if (pageInfo !=null && pageInfo.getSize() >0 ){
            return pageInfo;
        }
        return null;
    }
}
