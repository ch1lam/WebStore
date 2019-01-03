package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.User;

public interface LoginService {
	public List<User> ShowUserInfo();
	public Boolean LoginVerify(String username,String password);

}
