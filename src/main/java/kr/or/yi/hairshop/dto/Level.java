package kr.or.yi.hairshop.dto;

public class Level {
	private String l_grade;
	private int l_sale;
	public Level() {
		// TODO Auto-generated constructor stub
	}
	public Level(String l_grade, int l_sale) {
		this.l_grade = l_grade;
		this.l_sale = l_sale;
	}
	public String getL_grade() {
		return l_grade;
	}
	public void setL_grade(String l_grade) {
		this.l_grade = l_grade;
	}
	public int getL_sale() {
		return l_sale;
	}
	public void setL_sale(int l_sale) {
		this.l_sale = l_sale;
	}
	@Override
	public String toString() {
		return String.format("Level [l_grade=%s, l_sale=%s]", l_grade, l_sale);
	}

	

}
