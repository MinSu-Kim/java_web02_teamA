package kr.or.yi.hairshop.dto;

public class Choice {
	private int cWNo;
	private String cPName;
	public Choice() {
		// TODO Auto-generated constructor stub
	}
	public Choice(int cWNo, String cPName) {
		this.cWNo = cWNo;
		this.cPName = cPName;
	}
	public int getcWNo() {
		return cWNo;
	}
	public void setcWNo(int cWNo) {
		this.cWNo = cWNo;
	}
	public String getcPName() {
		return cPName;
	}
	public void setcPName(String cPName) {
		this.cPName = cPName;
	}
	@Override
	public String toString() {
		return String.format("Choice [cWNo=%s, cPName=%s]", cWNo, cPName);
	}
	
	
}
