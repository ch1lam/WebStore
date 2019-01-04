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
	public List<Guests> deleteGuestById(int id) {
		return guestsMapper.deleteGuestById(id);
	}

	@Override
	public List<Guests> addGuests(String name, int rank) {
		return guestsMapper.addGuests(name, rank);
	}

	@Override
	public List<Guests> updateGoods(String name, int rank, int id) {
		return guestsMapper.updateGoods(name, rank, id);
	}

}
