package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
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

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfPassWord;
	private JButton btnLogin;
	private WorkDialogMapper dao = new WorkDialogMapperImpl();

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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("관리자 로그인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
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
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel_6.add(btnLogin);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		
	}
}
