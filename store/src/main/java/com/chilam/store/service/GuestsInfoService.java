package com.chilam.store.service;

import java.util.List;

import com.chilam.store.po.Guests;

public interface GuestsInfoService {
	public List<Guests> getGuestsInfoAll();
	public List<Guests> getGuestsInfoByRank(int rank);
}
