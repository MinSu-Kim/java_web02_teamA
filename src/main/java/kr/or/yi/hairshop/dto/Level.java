package kr.or.yi.hairshop.dto;

public class Level {
	private String lGrade;
	private int lSale;

	public Level() {
		// TODO Auto-generated constructor stub
	}

	public Level(String lGrade, int lSale) {
		this.lGrade = lGrade;
		this.lSale = lSale;
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

	@Override
	public String toString() {
		return String.format("Level [lGrade=%s, lSale=%s]", lGrade, lSale);
	}

	public Object[] toArray() {
		return new Object[] { lGrade, lSale };
	}

}
