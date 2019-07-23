package kr.or.yi.hairshop.UI;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

public class pCalendar extends JPanel {

	public pCalendar() {

		initComponents();
	}
	private void initComponents() {
		
		JCalendar calendar = new JCalendar();
		add(calendar);
	}

}
