package com.mooc.house.biz.service;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mooc.house.biz.mapper.HouseMapper;
import com.mooc.house.common.model.House;
import com.mooc.house.common.page.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseMapper houseMapper;

    public void queryHouse(House query, PageParams pageParams) {

   }
}
