package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Guest {
	private int g_no;
	private Level g_l_grade;
	private String g_Name;
	private String g_tel;
	private String g_email;
	private Date g_birth;
	private Date g_join;
	private int g_point;
	private String g_memo;

	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(int g_no, Level g_l_grade, String g_Name, String g_tel, String g_email, Date g_birth, Date g_join,
			int g_point, String g_memo) {
		this.g_no = g_no;
		this.g_l_grade = g_l_grade;
		this.g_Name = g_Name;
		this.g_tel = g_tel;
		this.g_email = g_email;
		this.g_birth = g_birth;
		this.g_join = g_join;
		this.g_point = g_point;
		this.g_memo = g_memo;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public Level getG_l_grade() {
		return g_l_grade;
	}

	public void setG_l_grade(Level g_l_grade) {
		this.g_l_grade = g_l_grade;
	}

	public String getG_Name() {
		return g_Name;
	}

	public void setG_Name(String g_Name) {
		this.g_Name = g_Name;
	}

	public String getG_tel() {
		return g_tel;
	}

	public void setG_tel(String g_tel) {
		this.g_tel = g_tel;
	}

	public String getG_email() {
		return g_email;
	}

	public void setG_email(String g_email) {
		this.g_email = g_email;
	}

	public Date getG_birth() {
		return g_birth;
	}

	public void setG_birth(Date g_birth) {
		this.g_birth = g_birth;
	}

	public Date getG_join() {
		return g_join;
	}

	public void setG_join(Date g_join) {
		this.g_join = g_join;
	}

	public int getG_point() {
		return g_point;
	}

	public void setG_point(int g_point) {
		this.g_point = g_point;
	}

	public String getG_memo() {
		return g_memo;
	}

	public void setG_memo(String g_memo) {
		this.g_memo = g_memo;
	}

	@Override
	public String toString() {
		return String.format("Guest [%s, %s, %s, %s, %s, %s, %s, %s, %s]", g_no, g_l_grade, g_Name, g_tel, g_email,
				g_birth, g_join, g_point, g_memo);
	}

	public Object[] toArray() {
		return new Object[] { g_no, g_l_grade, g_Name, g_tel, g_email, g_birth, g_join, g_point, g_memo };
	}
}
