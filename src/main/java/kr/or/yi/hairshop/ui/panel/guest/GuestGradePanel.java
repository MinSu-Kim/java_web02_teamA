package kr.or.yi.hairshop.ui.panel.guest;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GuestGradePanel extends JPanel {
	private JTextField tfGrade;

	public GuestGradePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblGrade = new JLabel("등급등록");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblGrade);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 1, 10, 10));
		
		tfGrade = new JTextField();
		panel_2.add(tfGrade);
		tfGrade.setColumns(10);
		
	}

}
