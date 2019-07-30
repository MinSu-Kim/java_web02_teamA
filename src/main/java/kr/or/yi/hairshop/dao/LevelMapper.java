package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Level;

public interface LevelMapper {
	public List<Level> selectLevelByAll();
	public int insertLevel(Level level);
	public int updateLevel(Level level);
	public void deleteLevel(String name);
}
