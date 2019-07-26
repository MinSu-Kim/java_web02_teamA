package kr.or.yi.hairshop.ui.panel.guest;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class GuestPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public GuestPanel() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 15, 10));
		
		JLabel label = new JLabel("등급");
		label.setFont(new Font("굴림", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setFont(new Font("굴림", Font.PLAIN, 14));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("전화번호");
		label_2.setFont(new Font("굴림", Font.PLAIN, 14));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(20);
		panel_1.add(textField_2);
		
		JLabel label_3 = new JLabel("이메일");
		label_3.setFont(new Font("굴림", Font.PLAIN, 14));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(20);
		panel_1.add(textField_3);
		
		JLabel label_4 = new JLabel("생일");
		label_4.setFont(new Font("굴림", Font.PLAIN, 14));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(20);
		panel_1.add(textField_4);
		
		JLabel label_5 = new JLabel("가입일");
		label_5.setFont(new Font("굴림", Font.PLAIN, 14));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(20);
		panel_1.add(textField_5);
		
		JLabel label_6 = new JLabel("포인트");
		label_6.setFont(new Font("굴림", Font.PLAIN, 14));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		panel_1.add(textField_6);
		
		JLabel label_7 = new JLabel("메모");
		label_7.setFont(new Font("굴림", Font.PLAIN, 14));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(20);
		panel_1.add(textField_7);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(2, 1, 10, 10));
		
		JButton btnAdd = new JButton("추가");
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		panel.add(btnCancel);

	}
}
