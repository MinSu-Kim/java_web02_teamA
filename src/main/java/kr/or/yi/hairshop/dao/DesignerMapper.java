package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.Designer;

public interface DesignerMapper {
	List<Designer> selectDesignerByAll();
	int insertDesigner(Designer ds);
	int deleteDesigner(int dNo);
	int updateDesigner(Designer ds);
	
}