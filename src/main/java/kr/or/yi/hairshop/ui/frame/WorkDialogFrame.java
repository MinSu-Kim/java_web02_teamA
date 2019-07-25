package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.yi.hairshop.dto.WorkDialog;

public class WorkDialogFrame extends JFrame {

	private JPanel contentPane;

	private JTextField tfgDname;
	private JTextField tfdName;
	private JTextField tfwWorkTime;
	private JTextField tfwReservTime;
	private JTextField tfeName;
	private JTextField tfpPrice;
	private JTextField tfdMemo;
	private JButton btnConfirm;
	

	public WorkDialogFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("일정 관리");
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(10, 2, 15, 10));
		
		JLabel lblgDname = new JLabel("손님");
		lblgDname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblgDname);
		
		tfgDname = new JTextField();
		panel_4.add(tfgDname);
		tfgDname.setColumns(10);
		
		JLabel lbldName = new JLabel("디자이너");
		lbldName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldName);
		
		tfdName = new JTextField();
		panel_4.add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lblwWorkTime = new JLabel("작업완료일");
		lblwWorkTime.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblwWorkTime);
		
		tfwWorkTime = new JTextField();
		tfwWorkTime.setColumns(10);
		panel_4.add(tfwWorkTime);
		
		JLabel lblwReservTime = new JLabel("작업일예약");
		lblwReservTime.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblwReservTime);
		
		tfwReservTime = new JTextField();
		panel_4.add(tfwReservTime);
		tfwReservTime.setColumns(10);
		
		JLabel lbleName = new JLabel("이벤트명");
		lbleName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbleName);
		
		tfeName = new JTextField();
		panel_4.add(tfeName);
		tfeName.setColumns(10);
		
		JLabel lblpPrice = new JLabel("가격");
		lblpPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblpPrice);
		
		tfpPrice = new JTextField();
		panel_4.add(tfpPrice);
		tfpPrice.setColumns(10);
		
		JLabel lblpName = new JLabel("작업명");
		lblpName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblpName);
		
		tfdMemo = new JTextField();
		tfdMemo.setColumns(10);
		panel_4.add(tfdMemo);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		panel_5.add(btnConfirm);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
	}

	public void setWorkTf(WorkDialog work) {
		
	}

}
