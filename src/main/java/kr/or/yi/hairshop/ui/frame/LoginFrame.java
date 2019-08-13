package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.HairMainFrame;
import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.panel.pFindPassPanel;
import kr.or.yi.hairshop.panel.pLoginPanel;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener, KeyListener {

	private static Designer Auth = null;
	private JPanel contentPane;
	private JButton btnLogin;
	private HairMainFrame parent;
	
	private DesignerMapper dao = new DesignerMapperImpl();
	private JPanel topLabel;
	private JButton btnFindPass;
	private JPanel center;
	
	private pFindPassPanel pFindPass = new pFindPassPanel();
	private pLoginPanel pLogin = new pLoginPanel();
	private int CerNumber;
	
	public LoginFrame() {
		initComponents();
	}
	private void initComponents() {
		
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 320);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		topLabel = new JPanel();
		contentPane.add(topLabel);
		topLabel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("관리자 로그인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.add(lblNewLabel);
		
		center = new JPanel();
		contentPane.add(center);
		center.setLayout(new BorderLayout(0, 0));
		
		center.add(pLogin);
		
		JPanel bottom = new JPanel();
		contentPane.add(bottom);
		bottom.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_7 = new JPanel();
		bottom.add(panel_7);
		
		JPanel panel_6 = new JPanel();
		bottom.add(panel_6);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_2 = new JLabel("");
		panel_6.add(label_2);
		panel_6.add(btnLogin);
		
		btnFindPass = new JButton("비번 찾기");
		btnFindPass.addActionListener(this);
		panel_6.add(btnFindPass);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_6.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		bottom.add(panel_5);
	}
	
	public void setParent(HairMainFrame HairMainFrame) {
		this.parent = HairMainFrame;
	}	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFindPass) {
			actionPerformedBtnFindPass(arg0);
		}
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}
	
	protected void actionPerformedBtnFindPass(ActionEvent arg0) {
		int result = JOptionPane.showConfirmDialog(null, "비밀번호를 찾으시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
		}else if (result == JOptionPane.YES_OPTION) {
			center.removeAll();
			center.add(pFindPass);
			center.revalidate();
			center.repaint();
			btnFindPass.setVisible(false);
			btnLogin.setText("비번 변경");
			
		}else {
			JOptionPane.showMessageDialog(null, "취소하셨습니다.");
		}
	}
	
	private void findPassword() {
		CerNumber = pFindPass.getCerNumber();
		int typedCerNumber = Integer.parseInt(pFindPass.getTfCerNumber());
		String id = pFindPass.getTfId();
		String newpass = pFindPass.getTfNewPass();
		String newpasscheck = pFindPass.getTfNewPassCheck();

		if(CerNumber == typedCerNumber) {
			JOptionPane.showMessageDialog(null, "인증번호가 확인 되었습니다");
			
			if(newpass.equals(newpasscheck)) {
				Designer designer = dao.selelctDesignerById(id);
				designer.setdPassword(newpass);
				int result = dao.updateDesigner(designer);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "비밀번호를 변경하였습니다");
					
					center.removeAll();
					center.add(pLogin);
					center.revalidate();
					center.repaint();
					btnFindPass.setVisible(true);
					btnLogin.setText("로그인");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요");
			}
		}else {
			JOptionPane.showMessageDialog(null, "인증번호를 확인하세요");			
		}
		
		
	}
	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		if(btnLogin.getText() == "로그인") {
			loginAction();			
		}else {
			findPassword();
		}
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER) {
			keyPressedTfPassWord(e);
		}
	}
	
	private void keyPressedTfPassWord(KeyEvent e) {
		loginAction();
	}

	public void loginAction() {
		
		String id = pLogin.getTfId();
		String password = pLogin.getTfPass();
		
		Designer designer = dao.selelctDesignerById(id);
		
		if(designer != null && password.equals(designer.getdPassword()) == true ) {
			String dGrade = designer.getdGrade();
			String dId = designer.getdId();
			String dName = designer.getdName();
			Auth = new Designer(dGrade, dId, dName);
			
			parent.Login(Auth);
			pLogin.tfClear();
				
			JOptionPane.showMessageDialog(null, "로그인 되었습니다");
			dispose();
			
		}else {
			JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 잘못 입력하였습니다");
		}
	}
	
	public void clearAuth() {
		if(Auth != null) {
			Auth = null;
		}		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	

}
