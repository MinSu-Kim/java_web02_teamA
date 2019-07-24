package kr.or.yi.hairshop.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	private String eName;
	private Date eStartDay;
	private Date eEndDay;
	private int eSale;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eName, Date eStartDay, Date eEndDay, int eSale) {
		this.eName = eName;
		this.eStartDay = eStartDay;
		this.eEndDay = eEndDay;
		this.eSale = eSale;
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

	@Override
	public String toString() {
		return String.format("Event [eName=%s, eStartDay=%s, eEndDay=%s, eSale=%s]", eName, eStartDay, eEndDay, eSale);
	}

	public Object[] toArray() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] { eName, date.format(eStartDay), date.format(eEndDay), eSale };
	}

}
