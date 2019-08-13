package kr.or.yi.hairshop.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class pLoginPanel extends JPanel {
	private JTextField tfPassWord;
	private JTextField tfId;

	public pLoginPanel() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblLogin = new JLabel("아이디");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLogin);
		
		tfId = new JTextField();
		add(tfId);
		tfId.setColumns(10);
		
		JLabel lblPassWord = new JLabel("비밀번호");
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPassWord);
		
		tfPassWord = new JTextField();
		add(tfPassWord);
		tfPassWord.setColumns(10);
	}
	
	public String getTfId() {
		return tfId.getText();
	}
	
	public String getTfPass() {
		return tfPassWord.getText();
	}

	public void tfClear() {
		tfId.setText("");
		tfPassWord.setText("");
	}
}
