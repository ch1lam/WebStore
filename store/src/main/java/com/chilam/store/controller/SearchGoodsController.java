package com.chilam.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chilam.store.po.Goods;
import com.chilam.store.service.GoodsInfoService;

@RestController
public class SearchGoodsController {
	@Autowired
	GoodsInfoService goodsInfoService;

	@ResponseBody
	@RequestMapping(value = "/searchGoods", method = RequestMethod.GET)
	public List<Goods> SearchGoods(HttpServletResponse response, String data, int type) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		if (data == null || data.equals("")) {
			return goodsInfoService.getGoodsInfoAll();
		} else {
			switch (type) {
				case 1 :
					return goodsInfoService.getGoodsInfoByName(data);
				case 2 :
					return goodsInfoService.getGoodsInfoByNo(data);
				case 3 :
					return goodsInfoService.getGoodsInfoByPrice(Float.parseFloat(data));
				default :
					return goodsInfoService.getGoodsInfoAll();
			}
		}
	}

	@RequestMapping(value = "/deleteGoods", method = RequestMethod.GET)
	public void deleteGoods(HttpServletResponse response, String no) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		goodsInfoService.deleteGoodsByNo(no);
	}

	@RequestMapping(value = "/addGoods", method = RequestMethod.GET)
	public void addGoods(HttpServletResponse response, String name, float price, int quantity,
			String no) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		goodsInfoService.addGoods(name, price, quantity, no);
	}

	@RequestMapping(value = "/updateGoods", method = RequestMethod.GET)
	public void updateGoods(HttpServletResponse response, String name, float price, int quantity,
			String no, int id) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		goodsInfoService.updateGoods(name, price, quantity, no, id);
	}
}
