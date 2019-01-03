package com.chilam.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilam.store.mapper.GoodsMapper;
import com.chilam.store.po.Goods;
import com.chilam.store.service.GoodsInfoService;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
	@Autowired
	GoodsMapper goodsMapper;

	@Override
	public List<Goods> getGoodsInfoByName(String name) {
		return goodsMapper.getGoodsInfoByName(name);
	}

	@Override
	public List<Goods> getGoodsInfoByNo(String no) {
		return goodsMapper.getGoodsInfoByNo(no);
	}

	@Override
	public List<Goods> getGoodsInfoByPrice(float price) {
		return goodsMapper.getGoodsInfoByPrice(price);
	}

	@Override
	public List<Goods> getGoodsInfoAll() {
		return goodsMapper.getGoodsInfoAll();
	}

	@Override
	public void deleteGoodsByNo(String no) {
		goodsMapper.deleteGoodsByNo(no);
	}

	@Override
	public void addGoods(String name, float price, int quantity, String no) {
		goodsMapper.addGoods(name, price, quantity, no);
	}

	@Override
	public void updateGoods(String name, float price, int quantity, String no, int id) {
		goodsMapper.updateGoods(name, price, quantity, no, id);
	}

}
