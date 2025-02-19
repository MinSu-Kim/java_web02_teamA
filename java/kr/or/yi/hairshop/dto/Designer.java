package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Designer {
	private int dNo;
	private String dGrade;
	private String dName;
	private String dTel;
	private String dTel2;
	private String dAddr;
	private String dAddr2;
	private String dAddr3;
	private Date dBirth;
	private Date dJoin;
	private String dMemo;

	public Designer() {
		// TODO Auto-generated constructor stub
	}

	public Designer(int dNo, String dGrade, String dName, String dTel, String dTel2, String dAddr, String dAddr2,
			String dAddr3, Date dBirth, Date dJoin, String dMemo) {
		this.dNo = dNo;
		this.dGrade = dGrade;
		this.dName = dName;
		this.dTel = dTel;
		this.dTel2 = dTel2;
		this.dAddr = dAddr;
		this.dAddr2 = dAddr2;
		this.dAddr3 = dAddr3;
		this.dBirth = dBirth;
		this.dJoin = dJoin;
		this.dMemo = dMemo;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getdGrade() {
		return dGrade;
	}

	public void setdGrade(String dGrade) {
		this.dGrade = dGrade;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdTel() {
		return dTel;
	}

	public void setdTel(String dTel) {
		this.dTel = dTel;
	}

	public String getdTel2() {
		return dTel2;
	}

	public void setdTel2(String dTel2) {
		this.dTel2 = dTel2;
	}

	public String getdAddr() {
		return dAddr;
	}

	public void setdAddr(String dAddr) {
		this.dAddr = dAddr;
	}

	public String getdAddr2() {
		return dAddr2;
	}

	public void setdAddr2(String dAddr2) {
		this.dAddr2 = dAddr2;
	}

	public String getdAddr3() {
		return dAddr3;
	}

	public void setdAddr3(String dAddr3) {
		this.dAddr3 = dAddr3;
	}

	public Date getdBirth() {
		return dBirth;
	}

	public void setdBirth(Date dBirth) {
		this.dBirth = dBirth;
	}

	public Date getdJoin() {
		return dJoin;
	}

	public void setdJoin(Date dJoin) {
		this.dJoin = dJoin;
	}

	public String getdMemo() {
		return dMemo;
	}

	public void setdMemo(String dMemo) {
		this.dMemo = dMemo;
	}

	@Override
	public String toString() {
		return String.format(
				"designer [dNo=%s, dGrade=%s, dName=%s, dTel=%s, dTel2=%s, dAddr=%s, dAddr2=%s, dAddr3=%s, dBirth=%s, dJoin=%s, dMemo=%s]",
				dNo, dGrade, dName, dTel, dTel2, dAddr, dAddr2, dAddr3, dBirth, dJoin, dMemo);
	}

}
