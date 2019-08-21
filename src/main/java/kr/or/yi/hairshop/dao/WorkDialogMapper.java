package kr.or.yi.hairshop.dao;

import java.util.Date;
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
	
	public int insertWorkDialogResWNoNoGuest(WorkDialog workDialog);
	public int insertChoice(Map<String, String> map);
	
	public int deleteChoice(int wNo);
	public int updateWorkDialog(WorkDialog workDialog);
	public int updateWorkDialogWorkTime(WorkDialog workDialog);
	public int deleteWorkDialog(int wNo);
	public List<WorkDialog> selectGuestBarChartPrice(Map<String, Date> map);
	public List<WorkDialog> selectGuestBarChartCount(Map<String, Date> map);

	public List<WorkDialog> selectTotalPriceByDesigner (int wDNo);

	public List<WorkDialog> selectByDName();
	public List<WorkDialog> selectByDateForChartMon(Map<String, String> map);
	public List<WorkDialog> selectReservDetailByDesignerName(String name);
	public List<WorkDialog> selectReservDetailByGuestName(String name);
	

}