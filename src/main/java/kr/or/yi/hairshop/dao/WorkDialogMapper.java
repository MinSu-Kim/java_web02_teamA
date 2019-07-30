package kr.or.yi.hairshop.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.hairshop.dto.WorkDialog;

public interface WorkDialogMapper {
	public List<WorkDialog> selectDListByNo(int dNo);
	public List<WorkDialog> selectByAll();
	public List<WorkDialog> selectByfivejoinMap(int dNo);
	public List<WorkDialog> selectWDGECPjoinByNo(int no);
	
	public List<WorkDialog> selectReservDetail();
	public List<WorkDialog> selectWDGECPjoinByWNo(int wNo);
	public List<WorkDialog> selectWDGECPjoinByWDNoDate(Map<String, String> map);
	
	public List<WorkDialog> selectReservDetailByDate(Map<String, String> map);
}