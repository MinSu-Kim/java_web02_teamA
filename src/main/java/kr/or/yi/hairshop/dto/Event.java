package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Event {
	private String e_name;
	private Date e_startDay;
	private Date e_endDay;
	private int e_sale;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String e_name, Date e_startDay, Date e_endDay, int e_sale) {
		this.e_name = e_name;
		this.e_startDay = e_startDay;
		this.e_endDay = e_endDay;
		this.e_sale = e_sale;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Date getE_startDay() {
		return e_startDay;
	}

	public void setE_startDay(Date e_startDay) {
		this.e_startDay = e_startDay;
	}

	public Date getE_endDay() {
		return e_endDay;
	}

	public void setE_endDay(Date e_endDay) {
		this.e_endDay = e_endDay;
	}

	public int getE_sale() {
		return e_sale;
	}

	public void setE_sale(int e_sale) {
		this.e_sale = e_sale;
	}

	@Override
	public String toString() {
		return String.format("Event [%s, %s, %s, %s]", e_name, e_startDay, e_endDay, e_sale);
	}

	public Object[] toArray() {
		return new Object[] { e_name, e_startDay, e_endDay, e_sale };
	}
}
