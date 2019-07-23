package kr.or.yi.hairshop.dto;

import java.util.Date;

public class WorkDialog {
	private int wNo;
	private Date wWrokTime;
	private Date wReservTime;
	private Event wEName;
	private Designer wDNo;
	private Guest wGNo;

	public WorkDialog() {
		// TODO Auto-generated constructor stub
	}

	public WorkDialog(int wNo, Date wWrokTime, Date wReservTime, Event wEName, Designer wDNo, Guest wGNo) {
		this.wNo = wNo;
		this.wWrokTime = wWrokTime;
		this.wReservTime = wReservTime;
		this.wEName = wEName;
		this.wDNo = wDNo;
		this.wGNo = wGNo;
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

	public Event getwEName() {
		return wEName;
	}

	public void setwEName(Event wEName) {
		this.wEName = wEName;
	}

	public Designer getwDNo() {
		return wDNo;
	}

	public void setwDNo(Designer wDNo) {
		this.wDNo = wDNo;
	}

	public Guest getwGNo() {
		return wGNo;
	}

	public void setwGNo(Guest wGNo) {
		this.wGNo = wGNo;
	}

	@Override
	public String toString() {	//쓸일있어서 toString 변경햇어용-나모
		return String.format("%s", wGNo);
	}
	
	
}