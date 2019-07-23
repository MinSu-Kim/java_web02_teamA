package kr.or.yi.hairshop.UI.Panel.Home;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class pHomeBtn extends JPanel {

	public pHomeBtn() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		
		JPanel pCenter = new JPanel();
		add(pCenter);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		pCenter.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_5.add(lblNewLabel_1);
		
		JLabel label = new JLabel("홈");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		panel_5.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		pCenter.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 20));
		
		JButton btnAdd = new JButton("\uB4F1 \uB85D");
		panel_3.add(btnAdd);
		
		JButton btnUpdate = new JButton("\uC218 \uC815");
		panel_3.add(btnUpdate);
		
		JButton btnDel = new JButton("\uC0AD \uC81C");
		panel_3.add(btnDel);
		
		JPanel panel_4 = new JPanel();
		pCenter.add(panel_4);
		
		JPanel pRight = new JPanel();
		add(pRight);

	}

}
