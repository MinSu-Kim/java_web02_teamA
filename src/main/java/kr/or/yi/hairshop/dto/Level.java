package kr.or.yi.hairshop.dto;

import java.util.List;

public class Level {
	private String lGrade;
	private int lSale;
	private List<Guest> guestList;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}


	public Level(String lGrade) {
		super();
		this.lGrade = lGrade;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lGrade == null) ? 0 : lGrade.hashCode());
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
		Level other = (Level) obj;
		if (lGrade == null) {
			if (other.lGrade != null)
				return false;
		} else if (!lGrade.equals(other.lGrade))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return lGrade;
	}


	public Object[] toArray() {
		return new Object[] { lGrade, lSale };
	}

}
