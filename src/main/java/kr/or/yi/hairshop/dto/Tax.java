package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Tax {
	private int tNo;
	private String tName;
	private int tPrice;
	private Date tDate;
	private Product tPName;
	
	public Tax() {
		// TODO Auto-generated constructor stub
	}

	public Tax(int tNo, String tName, int tPrice, Date tDate, Product tPName) {
		this.tNo = tNo;
		this.tName = tName;
		this.tPrice = tPrice;
		this.tDate = tDate;
		this.tPName = tPName;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int gettPrice() {
		return tPrice;
	}

	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public Product gettPName() {
		return tPName;
	}

	public void settPName(Product tPName) {
		this.tPName = tPName;
	}

	@Override
	public String toString() {
		return String.format("Tax [tNo=%s, tName=%s, tPrice=%s, tDate=%s, tPName=%s]", tNo, tName, tPrice, tDate, tPName);
	}

	public Object[] toArray() {
		return new Object[] { tNo, tName, tPrice, tDate, tPName };
	}
	
}
