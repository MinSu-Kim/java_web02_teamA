package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;

@SuppressWarnings("serial")
public class DesignerFrame extends JFrame implements ActionListener {
	private DesignerMapper ds = new DesignerMapperImpl ();
	
	private JPanel contentPane;
	private JTextField tfdGrade;
	private JTextField tfdName;
	private JTextField tfdTel;
	private JTextField tfdTel2;
	private JTextField tfdAddr;
	private JTextField tfdBirth;
	private JTextField tfdJoin;
	private JTextField tfdEtc;
	private JTextField tfdMemo;
	private JButton btnConfirm;
	private DesignerMapper dsmapper;
	

	public DesignerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("디자이너 관리");
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(10, 2, 15, 10));
		
		JLabel lbldGrade = new JLabel("등급");
		lbldGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldGrade);
		
		tfdGrade = new JTextField();
		panel_4.add(tfdGrade);
		tfdGrade.setColumns(10);
		
		JLabel lbldName = new JLabel("이름");
		lbldName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldName);
		
		tfdName = new JTextField();
		panel_4.add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lbldTel = new JLabel("전화번호");
		lbldTel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldTel);
		
		tfdTel = new JTextField();
		tfdTel.setColumns(10);
		panel_4.add(tfdTel);
		
		JLabel lbldtel2 = new JLabel("비상연락망");
		lbldtel2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldtel2);
		
		tfdTel2 = new JTextField();
		panel_4.add(tfdTel2);
		tfdTel2.setColumns(10);
		
		JLabel lbldAddr = new JLabel("주소");
		lbldAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldAddr);
		
		tfdAddr = new JTextField();
		panel_4.add(tfdAddr);
		tfdAddr.setColumns(10);
		
		JLabel lbldBirth = new JLabel("생일");
		lbldBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldBirth);
		
		tfdBirth = new JTextField();
		panel_4.add(tfdBirth);
		tfdBirth.setColumns(10);
		
		JLabel lbldJoin = new JLabel("입사일");
		lbldJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldJoin);
		
		tfdJoin = new JTextField();
		panel_4.add(tfdJoin);
		tfdJoin.setColumns(10);
		
		JLabel lbldEtc = new JLabel("직원정보");
		lbldEtc.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldEtc);
		
		tfdEtc = new JTextField();
		panel_4.add(tfdEtc);
		tfdEtc.setColumns(10);
		
		JLabel lbldMemo = new JLabel("메모");
		lbldMemo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldMemo);
		
		tfdMemo = new JTextField();
		tfdMemo.setColumns(10);
		panel_4.add(tfdMemo);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		panel_5.add(btnConfirm);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
	}
	
	public void clearTextField() { //TextField를 비움
		tfdGrade.setText("");
		tfdName.setText("");
		tfdTel.setText("");
		tfdTel2.setText("");
		tfdAddr.setText("");
		tfdBirth.setText("");
		tfdJoin.setText("");
		tfdEtc.setText("");
		tfdEtc.setText("");
		tfdMemo.setText("");		
	}

	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(arg0);
		}
	}
	
	protected void actionPerformedBtnConfirm(ActionEvent arg0) { //확인버튼
		
			
	}
	
}















