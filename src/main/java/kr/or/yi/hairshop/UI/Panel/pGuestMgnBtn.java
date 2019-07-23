package kr.or.yi.hairshop.UI.Panel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class pGuestMgnBtn extends JPanel {

	public pGuestMgnBtn() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		
		JPanel pCenter = new JPanel();
		add(pCenter);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		pCenter.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_5.add(lblNewLabel);
		
		JLabel label = new JLabel("고객 관리");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_5.add(label_1);
		
		JPanel panel_3 = new JPanel();
		pCenter.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 20));
		
		JButton btnAdd = new JButton("등록");
		panel_3.add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		panel_3.add(btnUpdate);
		
		JButton btnDel = new JButton("삭제");
		panel_3.add(btnDel);
		
		JPanel panel_4 = new JPanel();
		pCenter.add(panel_4);
		
		JPanel pRight = new JPanel();
		add(pRight);

	}

}
