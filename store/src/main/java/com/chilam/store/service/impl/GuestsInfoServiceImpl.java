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

	@Override
	public void deleteGuestById(int id) {
		guestsMapper.deleteGuestById(id);
	}

	@Override
	public void addGuests(String name, int rank) {
		guestsMapper.addGuests(name, rank);
	}

	@Override
	public void updateGoods(String name, int rank, int id) {
		guestsMapper.updateGoods(name, rank, id);
	}

}
