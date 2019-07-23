package kr.or.yi.hairshop.dto;

public class Product {
	private int p_Price;
	private String p_name;
	private String p_division;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int p_Price, String p_name, String p_division) {
		this.p_Price = p_Price;
		this.p_name = p_name;
		this.p_division = p_division;
	}
	public int getP_Price() {
		return p_Price;
	}
	public void setP_Price(int p_Price) {
		this.p_Price = p_Price;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_division() {
		return p_division;
	}
	public void setP_division(String p_division) {
		this.p_division = p_division;
	}
	@Override
	public String toString() {
		return String.format("Product [p_Price=%s, p_name=%s, p_division=%s]", p_Price, p_name, p_division);
	}
	
	
	
}
