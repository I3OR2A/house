package com.mooc.house.biz.mapper;

import java.util.List;


import com.mooc.house.common.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public List<User>  selectUsers();

	public int insert(User account);
}
