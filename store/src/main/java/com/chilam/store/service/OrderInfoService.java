package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.Order;

public interface OrderInfoService {
	public List<Order> getOrderInfoAll();
	public void deleteOrderById(String id);
	public void addOrders(String goods_name, String goods_no, int guest_id);
	public void updateOrders(String goods_name, String goods_no, int guest_id, int id);
}
