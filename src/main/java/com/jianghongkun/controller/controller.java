package com.jianghongkun.controller;

import com.github.pagehelper.PageInfo;
import com.jianghongkun.pojo.RealEstate;
import com.jianghongkun.pojo.User;
import com.jianghongkun.service.RealEstateService;
import com.jianghongkun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;


@Controller
public class controller {

    @Resource
    RealEstateService realEstateService;
    @Resource
    UserService userService;

    @RequestMapping("selectAll.do")
    public String selectAll(String realEs, Integer card, Integer pageNum, Integer pageSize, Model model){
        Integer pageNum1 = 1;
        if (pageNum!=null&&pageNum>0){
            pageNum1 = pageNum;
        }
        if (realEs!=null && realEs.length()>0){
            model.addAttribute("realEs",realEs);
        }
        String name = null;
        String cardId=null;
        if (card!=null && card>0){
            model.addAttribute("card",card);
            if (card==1){
                name = realEs;
                User user = userService.selectByName(name);
                String cardId1 = user.getCardId();
                cardId = cardId1;
            }
            if (card ==2){
                cardId = realEs;
            }
        }
        Integer pageSize1=2;
        if (pageSize!=null&&pageSize>0){
            pageSize1 = pageSize;
        }
        PageInfo<RealEstate> pageInfo = realEstateService.selectByName(cardId, pageNum1, pageSize1);
        model.addAttribute("pageInfo",pageInfo);
        return "selectAll";
    }
}
