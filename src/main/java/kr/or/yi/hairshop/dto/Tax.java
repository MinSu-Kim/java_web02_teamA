package kr.or.yi.hairshop.dto;

import java.util.Date;

public class Tax {
	private int t_no;
	private String t_name;
	private int t_price;
	private Date t_date;
	private Product t_p_name;
	
	public Tax() {
		// TODO Auto-generated constructor stub
	}
	public Tax(int t_no, String t_name, int t_price, Date t_date, Product t_p_name) {
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_price = t_price;
		this.t_date = t_date;
		this.t_p_name = t_p_name;
	}
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getT_price() {
		return t_price;
	}
	public void setT_price(int t_price) {
		this.t_price = t_price;
	}
	public Date getT_date() {
		return t_date;
	}
	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}
	public Product getT_p_name() {
		return t_p_name;
	}
	public void setT_p_name(Product t_p_name) {
		this.t_p_name = t_p_name;
	}
	@Override
	public String toString() {
		return String.format("Tax [t_no=%s, t_name=%s, t_price=%s, t_date=%s, t_p_name=%s]", t_no, t_name, t_price,
				t_date, t_p_name);
	}
	

}
