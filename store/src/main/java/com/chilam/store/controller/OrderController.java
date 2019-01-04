package com.chilam.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chilam.store.po.Order;
import com.chilam.store.service.OrderInfoService;

@RestController
public class OrderController {
	@Autowired
	OrderInfoService orderInfoService;

	@ResponseBody
	@RequestMapping(value = "/searchOrders", method = RequestMethod.GET)
	public List<Order> searchOrders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		return orderInfoService.getOrderInfoAll();
	}
}
