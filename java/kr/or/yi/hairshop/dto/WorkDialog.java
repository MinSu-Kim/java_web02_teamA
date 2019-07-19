package kr.or.yi.hairshop.dto;

import java.util.Date;

public class WorkDialog {
	private int wNo;
	private Date wWrokTime;
	private Date wReservTime;
	private String wEName;
	private int wDNo;
	private int wCNo;
	public WorkDialog() {
		// TODO Auto-generated constructor stub
	}
	public WorkDialog(int wNo, Date wWrokTime, Date wReservTime, String wEName, int wDNo, int wCNo) {
		this.wNo = wNo;
		this.wWrokTime = wWrokTime;
		this.wReservTime = wReservTime;
		this.wEName = wEName;
		this.wDNo = wDNo;
		this.wCNo = wCNo;
	}
	public int getwNo() {
		return wNo;
	}
	public void setwNo(int wNo) {
		this.wNo = wNo;
	}
	public Date getwWrokTime() {
		return wWrokTime;
	}
	public void setwWrokTime(Date wWrokTime) {
		this.wWrokTime = wWrokTime;
	}
	public Date getwReservTime() {
		return wReservTime;
	}
	public void setwReservTime(Date wReservTime) {
		this.wReservTime = wReservTime;
	}
	public String getwEName() {
		return wEName;
	}
	public void setwEName(String wEName) {
		this.wEName = wEName;
	}
	public int getwDNo() {
		return wDNo;
	}
	public void setwDNo(int wDNo) {
		this.wDNo = wDNo;
	}
	public int getwCNo() {
		return wCNo;
	}
	public void setwCNo(int wCNo) {
		this.wCNo = wCNo;
	}
	@Override
	public String toString() {
		return String.format("WorkDialog [wNo=%s, wWrokTime=%s, wReservTime=%s, wEName=%s, wDNo=%s, wCNo=%s]", wNo,
				wWrokTime, wReservTime, wEName, wDNo, wCNo);
	}
	
	
}
