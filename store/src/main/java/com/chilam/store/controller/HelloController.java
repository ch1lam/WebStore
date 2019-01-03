package com.chilam.store.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
        return "hello,Spring Boot";
    }
}

