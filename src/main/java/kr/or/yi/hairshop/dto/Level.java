package kr.or.yi.hairshop.dto;

import java.util.List;

public class Level {
	private String lGrade;
	private int lSale;
	private List<Guest> guestList;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}


	public Level(String lGrade, int lSale, List<Guest> guestList) {
		this.lGrade = lGrade;
		this.lSale = lSale;
		this.guestList = guestList;
	}

	
	
	public String getlGrade() {
		return lGrade;
	}


	public void setlGrade(String lGrade) {
		this.lGrade = lGrade;
	}


	public int getlSale() {
		return lSale;
	}


	public void setlSale(int lSale) {
		this.lSale = lSale;
	}


	public List<Guest> getGuestList() {
		return guestList;
	}


	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	}

	
	
	
	@Override
	public String toString() {
		return String.format("Level [lGrade=%s, lSale=%s, guestList=%s]", lGrade, lSale, guestList);
	}


	public Object[] toArray() {
		return new Object[] { lGrade, lSale };
	}

}
