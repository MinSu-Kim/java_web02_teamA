package kr.or.yi.hairshop.dto;

public class Grade {
	private String g_grade;
	private int g_sale;

	public Grade(String g_grade, int g_sale) {
		this.g_grade = g_grade;
		this.g_sale = g_sale;
	}

	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public String getG_grade() {
		return g_grade;
	}

	public void setG_grade(String g_grade) {
		this.g_grade = g_grade;
	}

	public int getG_sale() {
		return g_sale;
	}

	public void setG_sale(int g_sale) {
		this.g_sale = g_sale;
	}

	@Override
	public String toString() {
		return String.format("Grade [g_grade=%s, g_sale=%s]", g_grade, g_sale);
	}

}
