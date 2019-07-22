package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Guest {
	private int gNo;
	private String gGrade;
	private String gName;
	private String gTel;
	private String gEmail;
	private Date gBirth;
	private Date gJoin;
	private int gPoint;
	private String gMemo;

	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(int gNo, String gGrade, String gName, String gTel, String gEmail, Date gBirth, Date gJoin, int gPoint,
			String gMemo) {
		this.gNo = gNo;
		this.gGrade = gGrade;
		this.gName = gName;
		this.gTel = gTel;
		this.gEmail = gEmail;
		this.gBirth = gBirth;
		this.gJoin = gJoin;
		this.gPoint = gPoint;
		this.gMemo = gMemo;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgGrade() {
		return gGrade;
	}

	public void setgGrade(String gGrade) {
		this.gGrade = gGrade;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgTel() {
		return gTel;
	}

	public void setgTel(String gTel) {
		this.gTel = gTel;
	}

	public String getgEmail() {
		return gEmail;
	}

	public void setgEmail(String gEmail) {
		this.gEmail = gEmail;
	}

	public Date getgBirth() {
		return gBirth;
	}

	public void setgBirth(Date gBirth) {
		this.gBirth = gBirth;
	}

	public Date getgJoin() {
		return gJoin;
	}

	public void setgJoin(Date gJoin) {
		this.gJoin = gJoin;
	}

	public int getgPoint() {
		return gPoint;
	}

	public void setgPoint(int gPoint) {
		this.gPoint = gPoint;
	}

	public String getgMemo() {
		return gMemo;
	}

	public void setgMemo(String gMemo) {
		this.gMemo = gMemo;
	}

	@Override
	public String toString() {
		return String.format(
				"Guest [gNo=%s, gGrade=%s, gName=%s, gTel=%s, gEmail=%s, gBirth=%s, gJoin=%s, gPoint=%s, gMemo=%s]",
				gNo, gGrade, gName, gTel, gEmail, gBirth, gJoin, gPoint, gMemo);
	}

}
