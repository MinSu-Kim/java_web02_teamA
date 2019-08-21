package kr.or.yi.hairshop.dto;

public class Post {
	private String pZipcode;
	private String pSido;
	private String pSigungu;
	private String pDoro;
	private int pAddress1;
	private int pAddress2;
	public Post() {
		// TODO Auto-generated constructor stub
	}
	public Post(String pZipcode, String pSido, String pSigungu, String pDoro, int pAddress1, int pAddress2) {
		this.pZipcode = pZipcode;
		this.pSido = pSido;
		this.pSigungu = pSigungu;
		this.pDoro = pDoro;
		this.pAddress1 = pAddress1;
		this.pAddress2 = pAddress2;
	}
	public String getpZipcode() {
		return pZipcode;
	}
	public void setpZipcode(String pZipcode) {
		this.pZipcode = pZipcode;
	}
	public String getpSido() {
		return pSido;
	}
	public void setpSido(String pSido) {
		this.pSido = pSido;
	}
	public String getpSigungu() {
		return pSigungu;
	}
	public void setpSigungu(String pSigungu) {
		this.pSigungu = pSigungu;
	}
	public String getpDoro() {
		return pDoro;
	}
	public void setpDoro(String pDoro) {
		this.pDoro = pDoro;
	}
	
	public int getpAddress1() {
		return pAddress1;
	}
	public void setpAddress1(int pAddress1) {
		this.pAddress1 = pAddress1;
	}
	public int getpAddress2() {
		return pAddress2;
	}
	public void setpAddress2(int pAddress2) {
		this.pAddress2 = pAddress2;
	}
	@Override
	public String toString() {
		/*
		 * return String.
		 * format("Post [pZipcode=%s, pSido=%s, pSigungu=%s, pDoro=%s, pBuilding1=%s, pBuilding2=%s]"
		 * , pZipcode, pSido, pSigungu, pDoro, pBuilding1, pBuilding2);
		 */
		return String.format("%s %s %s %s %s %s",
				pZipcode, 
				pSido, 
				pSigungu, 
				pDoro, 
				pAddress1, 
				pAddress2);
	}
	
	
	
}
