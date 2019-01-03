package com.chilam.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilam.store.mapper.UserMapper;
import com.chilam.store.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	UserMapper userMapper;

	@Override
	public Boolean register(String username, String password) {
		if (userMapper.getUserInfoByUsername(username) == null) {
			try {
				userMapper.insertUserInfo(username, password);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
