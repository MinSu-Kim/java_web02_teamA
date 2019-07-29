package kr.or.yi.hairshop.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Guest {
	private int gNo;
	private String gId;
	private String gPassword;
	private Level gLGrade;
	private String gName;
	private String gTel;
	private String gEmail;
	private Date gBirth;
	private Date gJoin;
	private int gPoint;
	private String gMemo;
	private List<WorkDialog> workDialogList;

	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(int gNo) {
		this.gNo = gNo;
	}

	public Guest(int gNo, String gName) {
		this.gNo = gNo;
		this.gName = gName;
	}

	public Guest(int gNo, String gId, String gPassword, Level gLGrade, String gName, String gTel, String gEmail,
			Date gBirth, Date gJoin, int gPoint, String gMemo, List<WorkDialog> workDialogList) {
		this.gNo = gNo;
		this.gId = gId;
		this.gPassword = gPassword;
		this.gLGrade = gLGrade;
		this.gName = gName;
		this.gTel = gTel;
		this.gEmail = gEmail;
		this.gBirth = gBirth;
		this.gJoin = gJoin;
		this.gPoint = gPoint;
		this.gMemo = gMemo;
		this.workDialogList = workDialogList;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgPassword() {
		return gPassword;
	}

	public void setgPassword(String gPassword) {
		this.gPassword = gPassword;
	}

	public Level getgLGrade() {
		return gLGrade;
	}

	public void setgLGrade(Level gLGrade) {
		this.gLGrade = gLGrade;
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

	public List<WorkDialog> getWorkDialogList() {
		return workDialogList;
	}

	public void setWorkDialogList(List<WorkDialog> workDialogList) {
		this.workDialogList = workDialogList;
	}

	@Override
	public String toString() { // 나모가 바꿈
		return String.format("%s", gName);
	}

	public Object[] toArray() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return new Object[] { gNo, gLGrade.getlGrade(), gName, gTel, gEmail, date.format(gBirth), date.format(gJoin),
				gPoint, gMemo };
	}

	public Object[] toArray2() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		return new Object[] {gName,date.format(gBirth),gId,gLGrade.getlGrade()};
	}
	
	
}
