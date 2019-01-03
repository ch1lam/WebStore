package com.chilam.store.mapper;

import java.util.List;

import com.chilam.store.po.Guests;

public interface GuestsMapper {
	public List<Guests> getGuestsInfoAll();
	public List<Guests> getGuestsInfoByRank(int rank);
	
}
