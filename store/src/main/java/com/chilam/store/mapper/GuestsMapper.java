package com.chilam.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chilam.store.po.Guests;

public interface GuestsMapper {
	public List<Guests> getGuestsInfoAll();
	public List<Guests> getGuestsInfoByRank(int rank);
	public List<Guests> deleteGuestById(int id);
	public List<Guests> addGuests(@Param("nmae") String name, @Param("rank") int rank);
	public List<Guests> updateGoods(@Param("nmae") String name, @Param("rank") int rank,
			@Param("id") int id);

}
