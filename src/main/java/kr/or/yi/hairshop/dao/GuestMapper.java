package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Guest;

public interface GuestMapper {
	public List<Guest> selectGuestByAll();
	public int insertGuest(Guest guest);
	public int updateGuest(Guest guest);
	public int deleteGuest(Guest guest);
	public void deleteGuest(int getgNo);
}
