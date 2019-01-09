package com.chilam.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chilam.store.po.Guests;

public interface GuestsMapper {
	public List<Guests> getGuestsInfoAll();
	
	public List<Guests> getGuestsInfoByRank(int rank);
	
	public void deleteGuestById(int id);
	
	public void addGuests(@Param("name") String name, @Param("rank") int rank);
	
	public void updateGoods(@Param("name") String name, @Param("rank") int rank,
			@Param("id") int id);

}
