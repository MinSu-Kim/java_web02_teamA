package kr.or.yi.hairshop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.ui.chart.pGuestChart;
import kr.or.yi.hairshop.ui.frame.LoginFrame;
import kr.or.yi.hairshop.ui.panel.chart.designer.pDesignerChart;
import kr.or.yi.hairshop.ui.panel.guest.pGuestMgn;
import kr.or.yi.hairshop.ui.panel.home.pHomeSection;
import kr.or.yi.hairshop.ui.panel.product.pProductMgn;
import kr.or.yi.hairshop.ui.panel.reserve.pReservationMgn;
import kr.or.yi.hairshop.ui.panel.workMain.pHomeSectionForm;

@SuppressWarnings("serial")
public class HairMainFrame extends JFrame implements ActionListener {

	private static HairMainFrame mainFrame;
	private static LoginFrame LoginFrame;
	private static Designer Auth = null;

	private pDesignerChart pDesignerChart;

	private JPanel contentPane;
	private JButton btnLogin;
	private JLabel lblLogin;
	private pGuestChart guestChart;
	private pProductMgn ProductMgn;
	private pGuestMgn GuestMgn;
	private pHomeSection home;
	private pReservationMgn ReservationMgn;
	private JTabbedPane tabbedPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					
					//1. vip고객 - 고객의 이용횟수, 결제총액 / 막대
					//2. 디자이너 - 작업횟수, 결제 총액 / 전체(디자이너별%)
					
					//3. 어떤작업이 제일많이 작업되었는지
					//4. 총매출 / 년/월 /일 막대그래프
					//4-1 년 : 월별로-12 -파이로
					//4-2 달 : 일별로-30 -
					//4-3 일 : 시간별-24 -

					mainFrame = new HairMainFrame();
					mainFrame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HairMainFrame() {
		initComponents();
	}

	private void initComponents() {
		setTitle("미용실 관리 프로그램");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 50, 1280, 960);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel TopMenu = new JPanel();
		contentPane.add(TopMenu, BorderLayout.NORTH);
		TopMenu.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel TopLogo = new JPanel();
		TopMenu.add(TopLogo);
		TopLogo.setLayout(new BorderLayout(0, 0));

		JPanel topLogo = new JPanel();
		TopLogo.add(topLogo);
		topLogo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\logo.png"));
		topLogo.add(lblNewLabel);

		JPanel LoginBtn = new JPanel();
		FlowLayout fl_LoginBtn = (FlowLayout) LoginBtn.getLayout();
		fl_LoginBtn.setAlignment(FlowLayout.RIGHT);
		TopLogo.add(LoginBtn, BorderLayout.EAST);

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);

		lblLogin = new JLabel("");
		LoginBtn.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		LoginBtn.add(btnLogin);

		JPanel pMain = new JPanel();
		contentPane.add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pMain.add(tabbedPane);

		home = new pHomeSection();
		tabbedPane.addTab("홈", null, home, "홈");
		
		pHomeSectionForm workMain = new pHomeSectionForm();
		workMain.refresh(0);
		tabbedPane.addTab("작업화면", null, workMain, "작업화면");

		ReservationMgn = new pReservationMgn();
		ReservationMgn.clearList();
		ReservationMgn.reloadData();
		tabbedPane.addTab("예약 관리", null, ReservationMgn, null);

		GuestMgn = new pGuestMgn();
		GuestMgn.clearList();
		GuestMgn.reloadData();
		tabbedPane.addTab("고객 관리", null, GuestMgn, null);

		ProductMgn = new pProductMgn();
		ProductMgn.setParent(HairMainFrame.this);
		ProductMgn.clearList();
		ProductMgn.reloadData();
		tabbedPane.addTab("제품 관리", null, ProductMgn, null);
		
		guestChart = new pGuestChart();
		tabbedPane.addTab("매출 현황", null, guestChart, null);
//		tabbedPane.setEnabledAt(5, false);

		pDesignerChart = new pDesignerChart();
		tabbedPane.addTab("디자이너 현황", null, pDesignerChart, null);
//		tabbedPane.setEnabledAt(6, false);
		
		tabbedPane.setEnabledAt(5, false);
		tabbedPane.setEnabledAt(6, false);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}

	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		// 로그인 버튼
		if (LoginFrame == null) {
			LoginFrame = new LoginFrame();
			LoginFrame.setParent(HairMainFrame.this);
			LoginFrame.setVisible(true);
		} else {
			LoginFrame.clearAuth();
			btnLogin.setText("로그인");
			lblLogin.setText("");
			LoginFrame.setVisible(true);
			mainFrame.setTitle("미용실 관리 프로그램");
			//로그 아웃시 볼수 없음
			tabbedPane.setEnabledAt(5, false);
			tabbedPane.setEnabledAt(6, false);
			
		}
	}

	public void Login(Designer designer) {
		Auth = designer;
		btnLogin.setText("로그아웃");		
		mainFrame.setTitle(Auth.getdName() + "님 반갑습니다");
		tabbedPane.setEnabledAt(5, true);
		tabbedPane.setEnabledAt(6, true);
	}

}