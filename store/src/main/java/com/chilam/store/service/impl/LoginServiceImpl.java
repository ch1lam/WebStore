package com.chilam.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilam.store.mapper.UserMapper;
import com.chilam.store.po.User;
import com.chilam.store.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> ShowUserInfo() {
		return userMapper.getUserInfoAll();
	}

	@Override
	public Boolean LoginVerify(String username,String password) {
		User guest=userMapper.getUserInfoByUsername(username);
		if(username.equals(guest.getUsername())) {
			if(password.equals(guest.getPassword())) {
				System.out.println("success");
				return true;
			}
			else {
				System.out.println("fail");
				return false;
			}
		}else {
			System.out.println("用户名不存在");
			return false;
		}
	}

}
