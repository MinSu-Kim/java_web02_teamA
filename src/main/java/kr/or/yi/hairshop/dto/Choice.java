package kr.or.yi.hairshop.dto;

public class Choice {
	private WorkDialog c_w_no;
	private Product c_p_name;

	public Choice() {
		// TODO Auto-generated constructor stub
	}

	public Choice(WorkDialog c_w_no, Product c_p_name) {
		this.c_w_no = c_w_no;
		this.c_p_name = c_p_name;
	}

	public WorkDialog getC_w_no() {
		return c_w_no;
	}

	public void setC_w_no(WorkDialog c_w_no) {
		this.c_w_no = c_w_no;
	}

	public Product getC_p_name() {
		return c_p_name;
	}

	public void setC_p_name(Product c_p_name) {
		this.c_p_name = c_p_name;
	}

	@Override
	public String toString() {
		return String.format("Choice [%s, %s]", c_w_no, c_p_name);
	}

	public Object[] toArray() {
		return new Object[] { c_w_no, c_p_name };
	}
}
