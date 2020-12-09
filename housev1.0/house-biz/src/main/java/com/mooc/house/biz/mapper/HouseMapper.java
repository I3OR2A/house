package com.mooc.house.biz.mapper;

import com.mooc.house.common.model.House;
import com.mooc.house.common.model.User;
import com.mooc.house.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public class HouseMapper {

    public List<House> selectPageHouses(@Param("house")House house, @Param("pageParams") PageParams pageParams);

    public int insert(User account);
}
