package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Guest;

public interface GuestMapper {
	List<Guest> selectGuestByAll();
	int insertGuest(Guest guest);
	int updateGuest(Guest guest);
	int deleteGuest(Guest guest);
	void deleteGuest(int getgNo);
}
