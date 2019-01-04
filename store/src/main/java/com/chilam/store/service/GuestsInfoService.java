package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.Guests;

public interface GuestsInfoService {
	public List<Guests> getGuestsInfoAll();
	public List<Guests> getGuestsInfoByRank(int rank);
	public List<Guests> deleteGuestById(int id);
	public List<Guests> addGuests(String name, int rank);
	public List<Guests> updateGoods(String name, int rank, int id);
}
