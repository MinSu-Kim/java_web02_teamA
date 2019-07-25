package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.HairMainFrame;
import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dto.Designer;

public class LoginFrame extends JFrame implements ActionListener {

	private static Designer Auth = null;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfPassWord;
	private JButton btnLogin;
	private HairMainFrame parent;
	
	private DesignerMapper dao = new DesignerMapperImpl();
	private JPanel topLabel;

	public LoginFrame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 300);
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
		
		JPanel center = new JPanel();
		contentPane.add(center);
		center.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		center.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblLogin = new JLabel("아이디");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblLogin);
		
		tfId = new JTextField();
		panel_4.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblPassWord = new JLabel("비밀번호");
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblPassWord);
		
		tfPassWord = new JTextField();
		panel_4.add(tfPassWord);
		tfPassWord.setColumns(10);
		
		JPanel bottom = new JPanel();
		contentPane.add(bottom);
		bottom.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		bottom.add(panel_7);
		
		JPanel panel_6 = new JPanel();
		bottom.add(panel_6);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel_6.add(btnLogin);
		
		JPanel panel_5 = new JPanel();
		bottom.add(panel_5);
	}
	
	public void setParent(HairMainFrame HairMainFrame) {
		this.parent = HairMainFrame;
	}	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		String id = tfId.getText();
		String password = tfPassWord.getText();
		
		Designer designer = dao.selelctDesignerById(id);
		
		if(password.equals(designer.getdPassword()) == true) {
			String dGrade = designer.getdGrade();
			String dId = designer.getdId();
			String dName = designer.getdName();
			Auth = new Designer(dGrade, dId, dName);
			
			parent.Login(Auth);
			tfId.setText("");
			tfPassWord.setText("");
			JOptionPane.showMessageDialog(null, "로그인 되었습니다");
			dispose();
		}

		
	}
	public void clearAuth() {
		if(Auth != null) {
			Auth = null;
		}
		
	}
}
