package kr.or.yi.hairshop.ui.frame;

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

import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.ui.list.guest.GuestList;

@SuppressWarnings("serial")
public class GuestFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfRating;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfAddr;
	private JTextField tfBirth;
	private JTextField tfJoinD;
	private JTextField tfPoint;
	private JTextField tfMemo;
	private JButton btnOK;
	private JButton btnCancel;

	
	public GuestFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 599);
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
		
		tfRating = new JTextField();
		panel_2.add(tfRating);
		tfRating.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblName);
		
		tfName = new JTextField();
		panel_2.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		panel_2.add(tfTel);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblAddress);
		
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		panel_2.add(tfAddr);
		
		JLabel lblBirthday = new JLabel("생일");
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblBirthday);
		
		tfBirth = new JTextField();
		tfBirth.setColumns(10);
		panel_2.add(tfBirth);
		
		JLabel lblJoinDate = new JLabel("가입일");
		lblJoinDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblJoinDate);
		
		tfJoinD = new JTextField();
		tfJoinD.setColumns(10);
		panel_2.add(tfJoinD);
		
		JLabel lblPoint = new JLabel("포인트");
		lblPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPoint);
		
		tfPoint = new JTextField();
		tfPoint.setColumns(10);
		panel_2.add(tfPoint);
		
		JLabel lblMemo = new JLabel("메모");
		lblMemo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblMemo);
		
		tfMemo = new JTextField();
		tfMemo.setColumns(10);
		panel_2.add(tfMemo);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		btnOK = new JButton("추가");
		btnOK.setBounds(67, 10, 57, 23);
		btnOK.addActionListener((ActionListener) this);
		panel_4.setLayout(null);
		panel_4.add(btnOK);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(12, 10, 57, 23);
		panel_5.add(btnCancel);
		
		GuestList panel_3 = new GuestList();
		panel_1.add(panel_3);
	}

	public void actionPerformed(ActionEvent g) {
		if (g.getSource() == btnCancel) {
			actionPerformedBtnCancelJButton(g);
		}
		if (g.getSource() == btnOK) {
			actionPerformedBtnOKJButton(g);
		}
	}
	protected void actionPerformedBtnOKJButton(ActionEvent arg0) {
		
	}
	
	
	protected void actionPerformedBtnCancelJButton(ActionEvent g) {
	}
}
