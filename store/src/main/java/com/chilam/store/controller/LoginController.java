package com.chilam.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chilam.store.po.User;
import com.chilam.store.service.LoginService;
import com.chilam.store.service.RegisterService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> name(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return loginService.ShowUserInfo();
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Boolean loginVertify(HttpServletResponse response, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		if (loginService.LoginVerify(username, password)) {
			return true;
		} else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Boolean register(HttpServletResponse response, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		if (registerService.register(username, password)) {
			return true;
		} else {
			return false;
		}
	}
}
