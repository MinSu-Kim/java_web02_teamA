package kr.or.yi.hairshop.dto;

public class Choice {
	private WorkDialog cWNo;
	private Product cPName;
	public Choice() {
		// TODO Auto-generated constructor stub
	}
	public Choice(WorkDialog cWNo, Product cPName) {
		this.cWNo = cWNo;
		this.cPName = cPName;
	}
	public WorkDialog getcWNo() {
		return cWNo;
	}
	public void setcWNo(WorkDialog cWNo) {
		this.cWNo = cWNo;
	}
	public Product getcPName() {
		return cPName;
	}
	public void setcPName(Product cPName) {
		this.cPName = cPName;
	}
	@Override
	public String toString() {
		return String.format("Choice [cWNo=%s, cPName=%s]", cWNo, cPName);
	}
	
	
}
