package com.chilam.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chilam.store.po.Order;

public interface OrderMapper {
	List<Order> getOrderInfoAll();
	public void deleteOrderById(String id);
	public void addOrders(@Param("goods_name") String goods_name,
			@Param("goods_no") String goods_no, @Param("guest_id") int guest_id);
	public void updateOrders(@Param("goods_name") String goods_name,
			@Param("goods_no") String goods_no, @Param("guest_id") int guest_id,
			@Param("id") int id);
}
