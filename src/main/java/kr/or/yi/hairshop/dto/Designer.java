package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Designer {
	private int d_no;
	private String d_grade;
	private String d_name;
	private String d_tel;
	private String d_tel2;
	private String d_addr;
	private String d_addr2;
	private String d_addr3;
	private Date d_birth;
	private Date d_join;
	private String d_memo;
	
	
	public Designer() {
		// TODO Auto-generated constructor stub
	}


	public Designer(int d_no, String d_grade, String d_name, String d_tel, String d_tel2, String d_addr, String d_addr2,
			String d_addr3, Date d_birth, Date d_join, String d_memo) {
		this.d_no = d_no;
		this.d_grade = d_grade;
		this.d_name = d_name;
		this.d_tel = d_tel;
		this.d_tel2 = d_tel2;
		this.d_addr = d_addr;
		this.d_addr2 = d_addr2;
		this.d_addr3 = d_addr3;
		this.d_birth = d_birth;
		this.d_join = d_join;
		this.d_memo = d_memo;
	}


	public int getD_no() {
		return d_no;
	}


	public void setD_no(int d_no) {
		this.d_no = d_no;
	}


	public String getD_grade() {
		return d_grade;
	}


	public void setD_grade(String d_grade) {
		this.d_grade = d_grade;
	}


	public String getD_name() {
		return d_name;
	}


	public void setD_name(String d_name) {
		this.d_name = d_name;
	}


	public String getD_tel() {
		return d_tel;
	}


	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}


	public String getD_tel2() {
		return d_tel2;
	}


	public void setD_tel2(String d_tel2) {
		this.d_tel2 = d_tel2;
	}


	public String getD_addr() {
		return d_addr;
	}


	public void setD_addr(String d_addr) {
		this.d_addr = d_addr;
	}


	public String getD_addr2() {
		return d_addr2;
	}


	public void setD_addr2(String d_addr2) {
		this.d_addr2 = d_addr2;
	}


	public String getD_addr3() {
		return d_addr3;
	}


	public void setD_addr3(String d_addr3) {
		this.d_addr3 = d_addr3;
	}


	public Date getD_birth() {
		return d_birth;
	}


	public void setD_birth(Date d_birth) {
		this.d_birth = d_birth;
	}


	public Date getD_join() {
		return d_join;
	}


	public void setD_join(Date d_join) {
		this.d_join = d_join;
	}


	public String getD_memo() {
		return d_memo;
	}


	public void setD_memo(String d_memo) {
		this.d_memo = d_memo;
	}


	@Override
	public String toString() {
		return String.format(
				"Designer [d_no=%s, d_grade=%s, d_name=%s, d_tel=%s, d_tel2=%s, d_addr=%s, d_addr2=%s, d_addr3=%s, d_birth=%s, d_join=%s, d_memo=%s]",
				d_no, d_grade, d_name, d_tel, d_tel2, d_addr, d_addr2, d_addr3, d_birth, d_join, d_memo);
	}

	
	
}
