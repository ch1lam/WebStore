package com.chilam.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chilam.store.po.User;

public interface UserMapper {
	public List<User> getUserInfoAll();

	public User getUserInfoByUsername(String username);

	public void insertUserInfo(@Param("username") String username, @Param("password") String password);

}
