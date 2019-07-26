package kr.or.yi.hairshop.dao;

import java.util.List;

import kr.or.yi.hairshop.dto.WorkDialog;

public interface WorkDialogMapper {
	public List<WorkDialog> selectDListByNo(int dNo);
	public List<WorkDialog> selectByAll();
	public List<WorkDialog> selectByfivejoinMap();
	public List<WorkDialog> selectWDGECPjoinByNo(int no);
}