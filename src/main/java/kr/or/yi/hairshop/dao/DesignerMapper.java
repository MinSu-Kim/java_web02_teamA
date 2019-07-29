package kr.or.yi.hairshop.dao;

import java.util.Date;
import java.util.List;

import kr.or.yi.hairshop.dto.Designer;

public interface DesignerMapper {
	public List<Designer> selectDesignerByAll();
	public List<Designer> selectDesignerByNo(int dNo);
	
	public Designer selelctDesignerById(String id); // 로그인
	
	public int insertDesigner(Designer ds);
	public int deleteDesigner(int dNo);
	public int updateDesigner(Designer ds);
	List<Designer> selectDesignerByMgn();

}