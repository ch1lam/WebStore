package com.chilam.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilam.store.mapper.GuestsMapper;
import com.chilam.store.po.Guests;
import com.chilam.store.service.GuestsInfoService;

@Service
public class GuestsInfoServiceImpl implements GuestsInfoService {
	@Autowired
	GuestsMapper guestsMapper;

	@Override
	public List<Guests> getGuestsInfoAll() {
		return guestsMapper.getGuestsInfoAll();
	}

	@Override
	public List<Guests> getGuestsInfoByRank(int rank) {
		return getGuestsInfoByRank(rank);
	}

}
