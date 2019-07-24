package kr.or.yi.hairshop.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkDialog {
	private int wNo;
	private Date wWrokTime;
	private Date wReservTime;
	private int wPriceTotal;
	private Event wEName;
	private Designer wDNo;
	private Guest wGNo;

	public WorkDialog() {
		// TODO Auto-generated constructor stub
	}

	public WorkDialog(int wNo, Date wWrokTime, Date wReservTime, int wPriceTotal, Event wEName, Designer wDNo,
			Guest wGNo) {
		this.wNo = wNo;
		this.wWrokTime = wWrokTime;
		this.wReservTime = wReservTime;
		this.wPriceTotal = wPriceTotal;
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

	public int getwPriceTotal() {
		return wPriceTotal;
	}

	public void setwPriceTotal(int wPriceTotal) {
		this.wPriceTotal = wPriceTotal;
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
	public String toString() {
		return String.format(
				"WorkDialog [wNo=%s, wWrokTime=%s, wReservTime=%s, wPriceTotal=%s, wEName=%s, wDNo=%s, wGNo=%s]", wNo, wWrokTime, wReservTime, wPriceTotal, wEName, wDNo, wGNo);
	}
	public Object[] toArray() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] { wNo, wWrokTime, wReservTime, wPriceTotal, wEName, wDNo, wGNo };
	}
}