package com.chilam.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilam.store.mapper.OrderMapper;
import com.chilam.store.po.Order;
import com.chilam.store.service.OrderInfoService;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public List<Order> getOrderInfoAll() {
		return orderMapper.getOrderInfoAll();
	}

	@Override
	public void deleteOrderById(String id) {
		orderMapper.deleteOrderById(id);
		
	}

	@Override
	public void addOrders(String goods_name, String goods_no, int guest_id) {
		orderMapper.addOrders(goods_name, goods_no, guest_id);
		
	}

	@Override
	public void updateOrders(String goods_name, String goods_no, int guest_id, int id) {
		orderMapper.updateOrders(goods_name, goods_no, guest_id, id);
		
	}

}
