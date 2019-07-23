package kr.or.yi.hairshop.ui.frame.guest;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.ui.list.guest.GuestList;

@SuppressWarnings("serial")
public class GuestFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnOK;

	
	public GuestFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGM = new JLabel("고객관리");
		panel.add(lblGM);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 15, 10));
		
		JLabel lblRating = new JLabel("등급");
		lblRating.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblRating);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblName);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblTel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel lblBirthday = new JLabel("생일");
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblBirthday);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JLabel lblJoinDate = new JLabel("가입일");
		lblJoinDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblJoinDate);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JLabel lblPoint = new JLabel("포인트");
		lblPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPoint);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_2.add(textField_6);
		
		JLabel lblMemo = new JLabel("메모");
		lblMemo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblMemo);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_2.add(textField_7);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		btnOK = new JButton("확인");
		btnOK.addActionListener((ActionListener) this);
		panel_4.add(btnOK);
		
		GuestList panel_3 = new GuestList();
		panel_1.add(panel_3);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOKJButton(arg0);
		}
	}
	protected void actionPerformedBtnOKJButton(ActionEvent arg0) {
		
	}

}
