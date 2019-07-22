package kr.or.yi.hairshop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.UI.Frame.ScheduleFrame;
import kr.or.yi.hairshop.UI.Panel.pCalendar;
import kr.or.yi.hairshop.UI.Panel.pRightBtn;
import kr.or.yi.hairshop.UI.Panel.pSampleMain;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HairMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenu mnReservation;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HairMain frame = new HairMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HairMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel TopMenu = new JPanel();
		contentPane.add(TopMenu, BorderLayout.NORTH);
		TopMenu.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel Top_01 = new JPanel();
		TopMenu.add(Top_01);
		Top_01.setLayout(new BorderLayout(0, 0));

		JPanel topLogo = new JPanel();
		Top_01.add(topLogo);
		topLogo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("미용실관리 프로그램");
		topLogo.add(lblNewLabel);

		JPanel LoginBtn = new JPanel();
		FlowLayout fl_LoginBtn = (FlowLayout) LoginBtn.getLayout();
		fl_LoginBtn.setAlignment(FlowLayout.RIGHT);
		Top_01.add(LoginBtn, BorderLayout.EAST);

		JButton btnLogin = new JButton("로그인");
		LoginBtn.add(btnLogin);

		JPanel Top_02 = new JPanel();
		FlowLayout fl_Top_02 = (FlowLayout) Top_02.getLayout();
		fl_Top_02.setAlignment(FlowLayout.LEFT);
		TopMenu.add(Top_02);

		JMenuBar menuBar = new JMenuBar();
		Top_02.add(menuBar);

		JMenu mnHome = new JMenu("홈");
		menuBar.add(mnHome);

		mnReservation = new JMenu("예약 관리");
		mnReservation.addActionListener(this);	
		
		menuBar.add(mnReservation);

		JMenu mnCustomer = new JMenu("고객 관리");
		menuBar.add(mnCustomer);

		JMenu mnProduct = new JMenu("상품 관리");
		menuBar.add(mnProduct);

		JMenu mnSale = new JMenu("매출");
		menuBar.add(mnSale);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		Top_02.add(btnNewButton);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel Rmain = new JPanel();
		panel.add(Rmain, BorderLayout.EAST);
		Rmain.setLayout(new BorderLayout(0, 0));

		pCalendar pCalendar = new pCalendar();
		Rmain.add(pCalendar, BorderLayout.NORTH);

		pRightBtn pSideBtn = new pRightBtn();
		Rmain.add(pSideBtn);
		pSideBtn.setPreferredSize(new Dimension(50, 50)); // 사이즈 조정 (정해진 전체 사이즈 보다 작아지지 못하는듯)

		pSampleMain pMain = new pSampleMain();
		panel.add(pMain, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButtonJButton(e);
		}
		if (e.getSource() == mnReservation) {
			actionPerformedMnReservationJMenu(e);
		}
	}
	
	protected void actionPerformedMnReservationJMenu(ActionEvent e) {
		ScheduleFrame scheduleFrame = new ScheduleFrame();
		scheduleFrame.setVisible(true);
		JOptionPane.showMessageDialog(null, "아아아아아");
		
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		ScheduleFrame scheduleFrame = new ScheduleFrame();
		scheduleFrame.setVisible(true);
		JOptionPane.showMessageDialog(null, "아아아아아");
	}
	
}
