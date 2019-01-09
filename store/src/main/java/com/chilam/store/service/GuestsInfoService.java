package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.Guests;

public interface GuestsInfoService {
	public List<Guests> getGuestsInfoAll();
	public List<Guests> getGuestsInfoByRank(int rank);
	public void deleteGuestById(int id);
	public void addGuests(String name, int rank);
	public void updateGoods(String name, int rank, int id);
}
