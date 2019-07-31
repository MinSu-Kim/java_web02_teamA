package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Level;

public interface GuestMapper {
	public List<Guest> selectGuestByAll();
	public List<Guest> selectGuestBygName(String gName);
	public int insertGuest(Guest guest);
	public int updateGuest(Guest guest);
	public void deleteGuest(int getgNo);
	public int insertGuestByWorkMain(Guest guest);
}
