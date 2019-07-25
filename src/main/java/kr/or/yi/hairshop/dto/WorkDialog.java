package kr.or.yi.hairshop.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WorkDialog {
	private int wNo;
	private Date wReservTime;
	private Date wWorkTime;
	private int wPriceTotal;
	private Event wEName;
	private Designer wDNo;
	private Guest wGNo;
	private List<Product> productList;

	public WorkDialog() {
		// TODO Auto-generated constructor stub
	}

	public WorkDialog(int wNo, Date wReservTime, Date wWorkTime, int wPriceTotal, Event wEName, Designer wDNo,
			Guest wGNo, List<Product> productList) {
		this.wNo = wNo;
		this.wReservTime = wReservTime;
		this.wWorkTime = wWorkTime;
		this.wPriceTotal = wPriceTotal;
		this.wEName = wEName;
		this.wDNo = wDNo;
		this.wGNo = wGNo;
		this.productList = productList;
	}

	public int getwNo() {
		return wNo;
	}

	public void setwNo(int wNo) {
		this.wNo = wNo;
	}

	public Date getwWorkTime() {
		return wWorkTime;
	}

	public void setwWorkTime(Date wWorkTime) {
		this.wWorkTime = wWorkTime;
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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() { //나모가 바꿈요
		return String.format(
				"%s",wGNo);
	}

	public Object[] toArray() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] { wNo, wWorkTime, wReservTime, wPriceTotal, wEName, wDNo, wGNo };
	}
}