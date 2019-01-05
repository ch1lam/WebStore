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

	@ResponseBody
	@RequestMapping(value = "/deleteOrders", method = RequestMethod.GET)
	public void deleteOrders(HttpServletResponse response, String id) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		orderInfoService.deleteOrderById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/addOrders", method = RequestMethod.GET)
	public void addOrders(HttpServletResponse response, String goods_name, String goods_no,
			int guest_id) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		orderInfoService.addOrders(goods_name, goods_no, guest_id);
	}

	@ResponseBody
	@RequestMapping(value = "/updateOrders", method = RequestMethod.GET)
	public void updateOrders(HttpServletResponse response, String goods_name, String goods_no,
			int guest_id, int id) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		orderInfoService.updateOrders(goods_name, goods_no, guest_id, id);
	}
}
