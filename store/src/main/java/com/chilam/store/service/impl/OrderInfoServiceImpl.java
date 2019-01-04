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

}
