package kr.or.yi.hairshop.panel;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

public class pCalendar extends JPanel {
	
	public pCalendar() {

		initComponents();
	}
	private void initComponents() {
		
		JCalendar calendar = new JCalendar();
		calendar.setWeekOfYearVisible(false);
		add(calendar);
	}

}
