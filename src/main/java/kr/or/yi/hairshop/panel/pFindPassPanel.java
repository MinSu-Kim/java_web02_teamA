package kr.or.yi.hairshop.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.yi.hairshop.ui.frame.Email;

@SuppressWarnings("serial")
public class pFindPassPanel extends JPanel implements ActionListener {
	private JTextField tfCerNumber;
	private JButton btnCerSander;
	private Email email = new Email();
	private int CerNumber = 0;
	private JTextField tfId;
	private JPasswordField tfNewPassCheck;
	private JPasswordField tfNewPass;
	
	public pFindPassPanel() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbltext = new JLabel("대표메일로");
		lbltext.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbltext);
		
		btnCerSander = new JButton("인증번호 보내기");
		btnCerSander.addActionListener(this);
		add(btnCerSander);
		
		JLabel lblCerNumber = new JLabel("인증번호");
		lblCerNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCerNumber);
		
		tfCerNumber = new JTextField();
		add(tfCerNumber);
		tfCerNumber.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		tfId = new JTextField();
		add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNewPass = new JLabel("새로운 비밀번호");
		lblNewPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewPass);
		
		tfNewPass = new JPasswordField();
		add(tfNewPass);
		
		JLabel lblNewPassCheck = new JLabel("비밀번호 확인");
		lblNewPassCheck.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewPassCheck);
		
		tfNewPassCheck = new JPasswordField();
		add(tfNewPassCheck);
	}
	
	public String getTfCerNumber() {
		return tfCerNumber.getText();
	}
	
	public String getTfNewPass() {
		return tfNewPass.getText();
	}

	public String getTfNewPassCheck() {
		return tfNewPassCheck.getText();
	}
	
	public String getTfId() {
		return tfId.getText();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerSander) {
			actionPerformedBtnCerSander(arg0);
		}
	}
	protected void actionPerformedBtnCerSander(ActionEvent arg0) {
		CerNumber = email.emailSander();
		JOptionPane.showMessageDialog(null, "대표 메일로 인증번호를 발송하였습니다");
	}
	
	public int getCerNumber() {
		return CerNumber;
	}
	
	public void tfClear() {
		tfCerNumber.setText("");
		tfId.setText("");
		tfNewPass.setText("");
		tfNewPassCheck.setText("");
		
	}
}












