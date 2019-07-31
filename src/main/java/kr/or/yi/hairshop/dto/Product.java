package kr.or.yi.hairshop.dto;

import java.text.DecimalFormat;
import java.util.List;

public class Product {
	private int pPrice;
	private String pName;
	private String pDivision;
	private List<WorkDialog> workDialogList;
	private List<Tax> taxList;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Product(int pPrice, String pName) {
		this.pPrice = pPrice;
		this.pName = pName;
	}



	public Product(int pPrice, String pName, String pDivision) {
		this.pPrice = pPrice;
		this.pName = pName;
		this.pDivision = pDivision;
	}

	public Product(int pPrice, String pName, String pDivision, List<WorkDialog> workDialogList, List<Tax> taxList) {
		this.pPrice = pPrice;
		this.pName = pName;
		this.pDivision = pDivision;
		this.workDialogList = workDialogList;
		this.taxList = taxList;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDivision() {
		return pDivision;
	}

	public void setpDivision(String pDivision) {
		this.pDivision = pDivision;
	}

	public List<WorkDialog> getWorkDialogList() {
		return workDialogList;
	}

	public void setWorkDialogList(List<WorkDialog> workDialogList) {
		this.workDialogList = workDialogList;
	}

	public List<Tax> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<Tax> taxList) {
		this.taxList = taxList;
	}

	@Override
	public String toString() {
		return String.format("%s",pName);
	}

	public Object[] toArray() {
		DecimalFormat df=new DecimalFormat("###,###");
		return new Object[] { pName, df.format(pPrice)+"원", pDivision };
	}
	public Object[] toArray2() {
		DecimalFormat df=new DecimalFormat("###,###");
		return new Object[] { pName, df.format(pPrice)+"원", pDivision };
	}

}
