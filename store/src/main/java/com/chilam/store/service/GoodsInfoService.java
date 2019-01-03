package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.Goods;

public interface GoodsInfoService {
	public List<Goods> getGoodsInfoByName(String name);

	public List<Goods> getGoodsInfoByNo(String no);

	public List<Goods> getGoodsInfoByPrice(float price);

	public List<Goods> getGoodsInfoAll();

	public void deleteGoodsByNo(String no);

	public void addGoods(String name, float price, int quantity, String no);

	public void updateGoods(String name, float price, int quantity, String no, int id);
}
