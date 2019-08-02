package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

public class pCalendar extends JPanel {
	private JCalendar calendar;
	
	public pCalendar() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		calendar = new JCalendar();
		calendar.setWeekOfYearVisible(false);
		add(calendar);

		
		
	}

}
