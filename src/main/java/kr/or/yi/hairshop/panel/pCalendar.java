package kr.or.yi.hairshop.panel;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class pCalendar extends JPanel {
	
	public pCalendar() {

		initComponents();
	}
	private void initComponents() {
		
		JCalendar calendar = new JCalendar();
		add(calendar);
	}

}
