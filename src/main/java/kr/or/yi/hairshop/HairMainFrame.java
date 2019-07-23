package kr.or.yi.hairshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.ui.panel.guest.pGuestMgn;
import kr.or.yi.hairshop.ui.panel.product.pProductMgn;

public class HairMainFrame extends JFrame implements ActionListener {

	private static HairMainFrame mainFrame;
	private JPanel contentPane;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
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

		JButton btnLogin = new JButton("로그인");
		LoginBtn.add(btnLogin);

		JPanel pMain = new JPanel();
		contentPane.add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pMain.add(tabbedPane);

		JPanel Home = new JPanel();
		tabbedPane.addTab("홈", null, Home, "홈");

		JPanel ReservationMgn = new JPanel();
		tabbedPane.addTab("예약 관리", null, ReservationMgn, null);

		pGuestMgn GuestMgn = new pGuestMgn();
		tabbedPane.addTab("고객 관리", null, GuestMgn, null);

		pProductMgn ProductMgn = new pProductMgn();
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
		// TODO Auto-generated method stub

	}

}