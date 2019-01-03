package com.chilam.store.po;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Order {
	private int id; // 订单id
	private String goods_no; // 商品编号
	private String goods_name; // 商品名称
	private int guest_id; // 用户id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGuest_id() {
		return guest_id;
	}
	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

}
