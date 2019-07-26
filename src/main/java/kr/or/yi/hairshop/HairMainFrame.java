package kr.or.yi.hairshop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.ui.frame.LoginFrame;
import kr.or.yi.hairshop.ui.panel.guest.pGuestMgn;
import kr.or.yi.hairshop.ui.panel.home.pHomeSectionForm;
import kr.or.yi.hairshop.ui.panel.product.pProductMgn;
import kr.or.yi.hairshop.ui.panel.reserve.pReservationMgn;

@SuppressWarnings("serial")
public class HairMainFrame extends JFrame implements ActionListener {

	private static HairMainFrame mainFrame;
	private static LoginFrame LoginFrame;
	private static Designer Auth = null;
	
	private JPanel contentPane;
	private List<Designer> dList;
	private pHomeSectionForm home;
	private JButton btnLogin;
	private JLabel lblLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new HairMainFrame();
					mainFrame.setVisible(true);

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// LookAndFeel
																									// Windows 스타일 적용
					SwingUtilities.updateComponentTreeUI(mainFrame);

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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 760);
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

		JLabel lblNewLabel = new JLabel("미용실관리 프로그램");
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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pMain.add(tabbedPane);
		
		DesignerMapper d_Dao=new DesignerMapperImpl();
		dList = d_Dao.selectDesignerByAll();
		home = new pHomeSectionForm();
		home.setDList(dList);
		home.refresh(0);
		tabbedPane.addTab("홈", null, home, "홈");

		pReservationMgn ReservationMgn = new pReservationMgn();
		ReservationMgn.clearList();
		ReservationMgn.reloadData();
		tabbedPane.addTab("예약 관리", null, ReservationMgn, null);

		pGuestMgn GuestMgn = new pGuestMgn();
		GuestMgn.clearList();
		GuestMgn.reloadData();
		tabbedPane.addTab("고객 관리", null, GuestMgn, null);

		pProductMgn ProductMgn = new pProductMgn();
		ProductMgn.setParent(HairMainFrame.this);
		ProductMgn.clearList();
		ProductMgn.reloadData();
		tabbedPane.addTab("제품 관리", null, ProductMgn, null);

		JPanel SalesMgn = new JPanel();
		tabbedPane.addTab("매출 관리", null, SalesMgn, null);

		JPanel PurchaseMgn = new JPanel();
		tabbedPane.addTab("매입 관리", null, PurchaseMgn, null);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}

	}
	

	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		//로그인 버튼
		if(LoginFrame == null) {
			LoginFrame = new LoginFrame();
			LoginFrame.setParent(HairMainFrame.this);
			LoginFrame.setVisible(true);
		}else {
			LoginFrame.clearAuth();
			btnLogin.setText("로그인");
			lblLogin.setText("");
			LoginFrame.setVisible(true);
		}
	}
	

	public void Login(Designer designer) {
		Auth = designer;
		btnLogin.setText("로그아웃");
		lblLogin.setText(Auth.getdName()+"님 반갑습니다");
		
	}
	
}