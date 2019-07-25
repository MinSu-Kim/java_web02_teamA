package kr.or.yi.hairshop.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Event {
	private String eName;
	private Date eStartDay;
	private Date eEndDay;
	private int eSale;
	private List<WorkDialog> workDialogList;

	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Event(String eName, Date eStartDay, Date eEndDay, int eSale, List<WorkDialog> workDialogList) {
		this.eName = eName;
		this.eStartDay = eStartDay;
		this.eEndDay = eEndDay;
		this.eSale = eSale;
		this.workDialogList = workDialogList;
	}

	
	
	public Object[] toArray() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] { eName, date.format(eStartDay), date.format(eEndDay), eSale };
	}

}
