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

	public Event(String eName) {
		this.eName = eName;
	}

	public Event(String eName, Date eStartDay, Date eEndDay, int eSale) {
		this.eName = eName;
		this.eStartDay = eStartDay;
		this.eEndDay = eEndDay;
		this.eSale = eSale;
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
		String start="";
		String end="";
		if(eStartDay!=null)
			start=date.format(eStartDay);
		if(eEndDay!=null)
			end=date.format(eStartDay);
		return new Object[] { eName, start, end, eSale };
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Date geteStartDay() {
		return eStartDay;
	}

	public void seteStartDay(Date eStartDay) {
		this.eStartDay = eStartDay;
	}

	public Date geteEndDay() {
		return eEndDay;
	}

	public void seteEndDay(Date eEndDay) {
		this.eEndDay = eEndDay;
	}

	public int geteSale() {
		return eSale;
	}

	public void seteSale(int eSale) {
		this.eSale = eSale;
	}

	public List<WorkDialog> getWorkDialogList() {
		return workDialogList;
	}

	public void setWorkDialogList(List<WorkDialog> workDialogList) {
		this.workDialogList = workDialogList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s", eName);
	}

}
