package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Event;

public interface EventMapper {

	public List<Event> selectEventByAll();
	
	public Event selectByName(String name);
	public int insert(Event event);
	public int deleteByName(String name);
	public int updateByName(Event event);
	
	
}
