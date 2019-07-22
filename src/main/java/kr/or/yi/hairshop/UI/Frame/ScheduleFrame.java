package kr.or.yi.hairshop.UI.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.ComponentOrientation;
import java.awt.Component;
import kr.or.yi.hairshop.UI.List.gList;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ScheduleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public ScheduleFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 518);
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
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblName);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblMobile = new JLabel("전화번호");
		lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblMobile);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblWork = new JLabel("작업명");
		lblWork.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblWork);
		
		JComboBox cmbWork = new JComboBox();
		panel_4.add(cmbWork);
		
		JLabel lblWorktingTime = new JLabel("작업시간");
		lblWorktingTime.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblWorktingTime);
		
		JComboBox cmbWorkingTime = new JComboBox();
		panel_4.add(cmbWorkingTime);
		
		JLabel lblWorker = new JLabel("작업자");
		lblWorker.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblWorker);
		
		JComboBox cmbWorker = new JComboBox();
		panel_4.add(cmbWorker);
		
		JLabel lblEvent = new JLabel("이벤트");
		lblEvent.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblEvent);
		
		JComboBox cmbEvent = new JComboBox();
		panel_4.add(cmbEvent);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("확인");
		panel_5.add(btnConfirm);
		
		gList pList = new gList();
		pList.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(pList);
	}

}
