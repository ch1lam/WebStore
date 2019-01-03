package com.chilam.store.po;

public class Cart {
	private String goods_no; // 商品编号
	private String guests_id; // 用户id
	private int goods_quantity; // 商品数量
	
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getGuests_id() {
		return guests_id;
	}
	public void setGuests_id(String guests_id) {
		this.guests_id = guests_id;
	}
	public int getGoods_quantity() {
		return goods_quantity;
	}
	public void setGoods_quantity(int goods_quantity) {
		this.goods_quantity = goods_quantity;
	}

}
