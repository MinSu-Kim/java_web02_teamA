package kr.or.yi.hairshop.dto;

import java.util.Date;

public class WorkDialog {
	private int w_no;
	private Date w_wrokTime;
	private Date w_reservTime;
	private Event w_e_name;
	private Designer w_d_no;
	private Choice w_c_no;
	public WorkDialog() {
		// TODO Auto-generated constructor stub
	}
	public WorkDialog(int w_no, Date w_wrokTime, Date w_reservTime, Event w_e_name, Designer w_d_no, Choice w_c_no) {
		this.w_no = w_no;
		this.w_wrokTime = w_wrokTime;
		this.w_reservTime = w_reservTime;
		this.w_e_name = w_e_name;
		this.w_d_no = w_d_no;
		this.w_c_no = w_c_no;
	}
	public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public Date getW_wrokTime() {
		return w_wrokTime;
	}
	public void setW_wrokTime(Date w_wrokTime) {
		this.w_wrokTime = w_wrokTime;
	}
	public Date getW_reservTime() {
		return w_reservTime;
	}
	public void setW_reservTime(Date w_reservTime) {
		this.w_reservTime = w_reservTime;
	}
	public Event getW_e_name() {
		return w_e_name;
	}
	public void setW_e_name(Event w_e_name) {
		this.w_e_name = w_e_name;
	}
	public Designer getW_d_no() {
		return w_d_no;
	}
	public void setW_d_no(Designer w_d_no) {
		this.w_d_no = w_d_no;
	}
	public Choice getW_c_no() {
		return w_c_no;
	}
	public void setW_c_no(Choice w_c_no) {
		this.w_c_no = w_c_no;
	}
	@Override
	public String toString() {
		return String.format("WorkDialog [w_no=%s, w_wrokTime=%s, w_reservTime=%s, w_e_name=%s, w_d_no=%s, w_c_no=%s]",
				w_no, w_wrokTime, w_reservTime, w_e_name, w_d_no, w_c_no);
	}
	
	
}
