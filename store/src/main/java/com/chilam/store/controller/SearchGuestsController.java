package com.chilam.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chilam.store.po.Guests;
import com.chilam.store.service.GuestsInfoService;

@RestController
public class SearchGuestsController {
	@Autowired
	GuestsInfoService guestsInfoService;

	@ResponseBody
	@RequestMapping(value = "/searchGuests", method = RequestMethod.GET)
	public List<Guests> SearchGuests(HttpServletResponse response,String data, int type) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		if (data == null) {
			return guestsInfoService.getGuestsInfoAll();
		} else {
			switch (type) {
			case 1:

				return guestsInfoService.getGuestsInfoByRank(Integer.parseInt(data));

			default:
				return guestsInfoService.getGuestsInfoAll();
			}

		}
	}
}
