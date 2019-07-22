package kr.or.yi.hairshop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import kr.or.yi.hairshop.UI.Frame.ScheduleFrame;
import kr.or.yi.hairshop.UI.Panel.pCalendar;
import kr.or.yi.hairshop.UI.Panel.pRightBtn;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class HairMain extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JButton btnHome;
	private JButton btnReservation;
	private JCalendar calendar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HairMain frame = new HairMain();
					frame.setVisible(true);
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// LookAndFeel Windows 스타일 적용
					SwingUtilities.updateComponentTreeUI(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HairMain() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		
		btnHome = new JButton("홈 ");
		btnHome.addActionListener(this);
		Top_02.add(btnHome);
		
		btnReservation = new JButton("예약관리");
		btnReservation.addActionListener(this);
		Top_02.add(btnReservation);
		
		JButton btnCustomer = new JButton("고객관리");
		Top_02.add(btnCustomer);
		
		JButton btnProduct = new JButton("상품관리");
		Top_02.add(btnProduct);
		
		JButton btnSales = new JButton("   매출   ");
		Top_02.add(btnSales);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel Rmain = new JPanel();
		panel.add(Rmain, BorderLayout.EAST);
		Rmain.setLayout(new BorderLayout(0, 0));

		pRightBtn pSideBtn = new pRightBtn();
		Rmain.add(pSideBtn);
		pSideBtn.setPreferredSize(new Dimension(50, 50)); // 사이즈 조정 (정해진 전체 사이즈 보다 작아지지 못하는듯)
		
		JPanel pCalendar = new JPanel();
		Rmain.add(pCalendar, BorderLayout.NORTH);
		
		calendar = new JCalendar();
		calendar.addMouseListener(this);
		pCalendar.add(calendar);

		pCalendar pMain = new pCalendar();
		panel.add(pMain, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReservation) {
			actionPerformedBtnReservation(e);
		}
		if (e.getSource() == btnHome) {
			actionPerformedBtnHome(e);
		}
	}
	protected void actionPerformedBtnHome(ActionEvent e) {

	}
	
	protected void actionPerformedBtnReservation(ActionEvent e) {
		ScheduleFrame scheduleFrame = new ScheduleFrame();
		scheduleFrame.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == calendar) {
			mouseClickedCalendar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedCalendar(MouseEvent e) {
		JOptionPane.showMessageDialog(null, "dd");
	}
}
