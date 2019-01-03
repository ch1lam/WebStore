package com.chilam.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chilam.store.po.Goods;

public interface GoodsMapper {
	public List<Goods> getGoodsInfoByName(String name);

	public List<Goods> getGoodsInfoByNo(String no);

	public List<Goods> getGoodsInfoByPrice(float price);

	public List<Goods> getGoodsInfoAll();

	public void deleteGoodsByNo(String no);

	public void addGoods(@Param("name") String name, @Param("price") float price,
			@Param("quantity") int quantity, @Param("no") String no);

	public void updateGoods(@Param("name") String name, @Param("price") float price,
			@Param("quantity") int quantity, @Param("no") String no, @Param("id") int id);
}
