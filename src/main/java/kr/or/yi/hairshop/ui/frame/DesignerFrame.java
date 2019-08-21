package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.HairMainFrame;
import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.DesignerPanel;
import kr.or.yi.hairshop.panel.SumPanel;
import kr.or.yi.hairshop.ui.panel.product.pProductMgn;
import java.awt.Color;

@SuppressWarnings("serial")
public class DesignerFrame extends JFrame implements ActionListener {
	private DesignerMapper ds;
	private WorkDialogMapper wdao=new WorkDialogMapperImpl();
	private int dNo;
	private JPanel contentPane;
	private JTextField tfdName;
	private JTextField tfdTel;
	private JTextField tfdTel2;
	private JTextField tfdAddr;
	private JTextField tfdAddr2;
	private JTextField tfdMemo;
	private JButton button;
	private JTextField tfdGrade;
	private JTextField tfdId;
	private JPanel panel_4;
	private JDateChooser dcdBirth;
	private JDateChooser dcdJoin;
	private pProductMgn pProductMgn;
	private DesignerPanel designerPanel;
	private SumPanel sumpanel;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton button_1;
	private PostFrame postframe = new PostFrame();
	private JButton btnNewButton_1;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					DesignerFrame frame = new DesignerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public void setAddr(String addr) {
		tfdAddr.setText(addr);
	}
	
	public void tfEnable() { //수정버튼(비활성화, 버튼 숨기기)
		passwordField.setEditable(false);
		tfdId.setEditable(false);
		btnNewButton.setVisible(false);
		tfdAddr.setEditable(true);
		btnNewButton_1.setVisible(false); //가라버튼
		button.setVisible(true);
	}
	public void tfEnable2() { //등록버튼눌렀을때
		passwordField.setEditable(true);
		tfdId.setEditable(true);
		btnNewButton.setVisible(true);
		tfdAddr.setEditable(false);
		btnNewButton_1.setVisible(true); //가라버튼
		button.setVisible(false); //진짜확인버튼
	}
	
	public DesignerFrame() {
		initComponents();
	}
	
	private void initComponents() {
		setTitle("디자이너 관리 프로그램");
		
		
		postframe.setParent(this);
		
		
		ds = new DesignerMapperImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 624);
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
		panel_1.setLayout(new GridLayout(0, 2, 50, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setSize(200, 600);
		panel_2.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 415, 522);
		
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("아이디");
		label.setBounds(47, 1, 153, 38);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(label);
		
		tfdId = new JTextField();
		tfdId.setBounds(212, 2, 137, 38);
		tfdId.setColumns(10);
		panel_4.add(tfdId);
		
		btnNewButton = new JButton("중복체크");
		btnNewButton.setBorder(new EmptyBorder(-10, -10, -10, -10));
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton.setBounds(351, 1, 64, 38);
		panel_4.add(btnNewButton);
		
		JLabel lbldPassword = new JLabel("비밀번호");
		lbldPassword.setBounds(0, 50, 202, 38);
		lbldPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 14));
		passwordField.setBounds(212, 50, 202, 38);
		panel_4.add(passwordField);
		
		
		JLabel lbldGrade = new JLabel("직급");
		lbldGrade.setBounds(0, 98, 202, 38);
		lbldGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldGrade);
		
		tfdGrade = new JTextField();
		tfdGrade.setBounds(212, 98, 202, 38);
		tfdGrade.setColumns(10);
		panel_4.add(tfdGrade);
		
		
		JLabel lbldName = new JLabel("이름");
		lbldName.setBounds(0, 146, 202, 38);
		lbldName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldName);
		
		tfdName = new JTextField();
		tfdName.setBounds(212, 146, 202, 38);
		panel_4.add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lbldTel = new JLabel("전화번호");
		lbldTel.setBounds(0, 194, 202, 38);
		lbldTel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldTel);
		
		tfdTel = new JTextField();
		tfdTel.setBounds(212, 194, 202, 38);
		tfdTel.setColumns(10);
		panel_4.add(tfdTel);
		
		JLabel lbldTel2 = new JLabel("비상연락망");
		lbldTel2.setBounds(0, 242, 202, 38);
		lbldTel2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldTel2);
		
		tfdTel2 = new JTextField();
		tfdTel2.setBounds(212, 242, 202, 38);
		panel_4.add(tfdTel2);
		tfdTel2.setColumns(10);
		
		JLabel lbldAddr = new JLabel("주소");
		lbldAddr.setBounds(0, 290, 202, 38);
		lbldAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldAddr);
		
		tfdAddr = new JTextField();
		tfdAddr.setBounds(212, 290, 153, 38);
		panel_4.add(tfdAddr);
		tfdAddr.setColumns(10);
		
		JLabel lbldAddr2 = new JLabel("상세주소");
		lbldAddr2.setBounds(0, 338, 202, 38);
		lbldAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldAddr2);
		
		tfdAddr2 = new JTextField();
		tfdAddr2.setBounds(212, 338, 202, 38);
		panel_4.add(tfdAddr2);
		tfdAddr2.setColumns(10);
		
		JLabel lbldBirth = new JLabel("생일");
		lbldBirth.setBounds(0, 386, 202, 38);
		lbldBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldBirth);
		
		dcdBirth = new JDateChooser();
		dcdBirth.setBounds(212, 386, 202, 38);
		panel_4.add(dcdBirth);
		
		JLabel lbldJoin = new JLabel("입사일");
		lbldJoin.setBounds(0, 434, 202, 38);
		lbldJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldJoin);
		
		dcdJoin = new JDateChooser();
		dcdJoin.setBounds(212, 434, 202, 38);
		panel_4.add(dcdJoin);
		
		JLabel lbldMemo = new JLabel("메모");
		lbldMemo.setBounds(0, 482, 202, 38);
		lbldMemo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldMemo);
		
		tfdMemo = new JTextField();
		tfdMemo.setBounds(212, 482, 202, 38);
		tfdMemo.setColumns(10);
		panel_4.add(tfdMemo);
		
		button_1 = new JButton("검색");
		button_1.addActionListener(this);
		button_1.setFont(new Font("굴림", Font.PLAIN, 12));
		button_1.setBorder(new EmptyBorder(-10, -10, -10, -10));
		button_1.setBounds(372, 290, 43, 38);
		panel_4.add(button_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 522, 415, 33);
		panel_2.add(panel_5);
		
		button = new JButton("확인");
		button.addActionListener(this);
		panel_5.add(button);
		
		btnNewButton_1 = new JButton("등록");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setForeground(Color.BLACK);
		panel_5.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		designerPanel = new DesignerPanel();
		panel_3.add(designerPanel);
		designerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		sumpanel= new SumPanel();
		panel_3.add(sumpanel, BorderLayout.SOUTH);
	}

		
	public void clearTextField() { 
		tfdId.setText("");
		passwordField.setText("");
		tfdGrade.setText("");
		tfdName.setText("");
		tfdTel.setText("");
		tfdTel2.setText("");
		tfdAddr.setText("");
		tfdAddr2.setText("");
		dcdBirth.setDate(new Date());
		dcdJoin.setDate(new Date());
		tfdMemo.setText("");	

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == button) {
			if(arg0.getActionCommand().equals("등록")) {
				actionPerformedBtnAdd(arg0);
			}
			if(arg0.getActionCommand().equals("수정")) {
				actionPerformedBtnModify(arg0);
			}			
		}
	}
	
	private void actionPerformedBtnAdd(ActionEvent arg0) { //등록버튼
		String tfi = tfdId.getText();
		char[] pp = passwordField.getPassword();	
		String tfp = "";
		for(char cha : pp) {
			tfp +=cha;
		}
		String tfg =tfdGrade.getText();
		String tfn =tfdName.getText();
		String tft =tfdTel.getText();
		String tft2 =tfdTel2.getText();	
		String tfa =tfdAddr.getText(); //검색한주소 통으로 있음
		String tfa2 =tfdAddr2.getText(); //입력한 상세주소
		Date tfb =dcdBirth.getDate();
		Date tfj =dcdJoin.getDate();
		String tfm =tfdMemo.getText();
		
		//가져왔을 때 비었으면 
		if(tfn.equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력하세요");
		}else if(tft.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
		}else if(tfi.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
		}else if(tfp.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
		}else if(tfa.equals("")) {
			JOptionPane.showMessageDialog(null, "주소를 입력하세요");
		}
		
		String tfaa = tfa.substring(0,4);
		String tfaaa = tfa.substring(6, tfa.length());
		
		Designer designer = new Designer();
		designer.setdId(tfi);
		designer.setdPassword(tfp);
		designer.setdGrade(tfg);
		designer.setdName(tfn);
		designer.setdTel(tft);
		designer.setdTel2(tft2);
		designer.setdAddr(tfaa);
		designer.setdAddr2(tfaaa); //우편번호
		designer.setdAddr3(tfa2); //대구광역시남구
		designer.setdBirth(tfb);
		designer.setdJoin(tfj);
		designer.setdMemo(tfm);
		
		ds.insertDesigner(designer);
		JOptionPane.showMessageDialog(null, "입력되었습니다.");
		pProductMgn.setWorkList(ds.selectDesignerByAll());
		pProductMgn.reloadData();
		dispose();
	
	}
	
	public void setText(Designer design) {
		dNo = design.getdNo();
		
		List<WorkDialog> workDialog=wdao.selectByfivejoinMap(dNo);
		designerPanel.setWorkdialogList(workDialog);
		designerPanel.reloadData();
		int sum=designerPanel.getSum();
		sumpanel.setSum(sum);
		sumpanel.setCount(workDialog.size());
		tfdId.setText(design.getdId());
		passwordField.setText(design.getdPassword());
		tfdGrade.setText(design.getdGrade());
		tfdName.setText(design.getdName());
		tfdTel.setText(design.getdTel());
		tfdTel2.setText(design.getdTel2());
		tfdAddr.setText(design.getdAddr()+design.getdAddr2());
		tfdAddr2.setText(design.getdAddr3());
		dcdBirth.setDate(design.getdBirth());
		dcdJoin.setDate(design.getdJoin());
		tfdMemo.setText(design.getdMemo());
	}
	
	public void actionPerformedBtnModify(ActionEvent arg0) { //수정버튼
		String id = tfdId.getText();
		
		char[] pp = passwordField.getPassword();	
		String ps = "";
		for(char cha : pp) {
			ps +=cha;
		}
		String grade = tfdGrade.getText();
		String name = tfdName.getText();
		String tel = tfdTel.getText();
		String tel2 = tfdTel2.getText();
		String addr = tfdAddr.getText(); //통
		String addr2 = tfdAddr2.getText(); //입력한것
		Date tfb =dcdBirth.getDate();
		Date tfj =dcdJoin.getDate();
		String memo = tfdMemo.getText();
		String addr11 = addr.substring(0,4);
//		수정버튼 누른 후 칸이 비었을 때 뜨는 메세지
//		if(name.equals("")) {
//			JOptionPane.showMessageDialog(null, "이름을 입력하세요");
//		}else if(tel.equals("")) {
//			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
//		}else if(id.equals("")) {
//			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
//		}else if(ps.equals("")) {
//			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
//		}else if(addr.equals("")) {
//			JOptionPane.showMessageDialog(null, "주소를 입력하세요");
//		}
		String addr22 = addr.substring(6, addr.length());
		Designer designer = new Designer(dNo, grade, id, ps, name, tel, tel2, addr11, addr22, addr2, tfb, tfj, memo);
//		JOptionPane.showMessageDialog(null, designer.toString2());
		ds.updateDesigner(designer);
		pProductMgn.setWorkList(ds.selectDesignerByAll());
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
		pProductMgn.reloadData();
		dispose();
	}

	public void setParent(HairMainFrame hairMainFrame) {
	}

	public void setBtnText(String string) {
		button.setText(string);
	}

	public void setProductMgn(pProductMgn pP) {
		this.pProductMgn = pP;
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) { //증복체크하는곳
		String tfi = tfdId.getText();
		Designer tfid = ds.selelctDesignerById(tfi);
		int checkId = 0;
		
		if(tfi.equals("")) { 
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
		}else {
			if(tfid == null) { 
				JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				passwordField.requestFocus();
			}else {
				checkId = 1;
				JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
				tfdId.requestFocus();
			}
		}
		
		button.setVisible(true);
		btnNewButton_1.setVisible(false); //가라버튼
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		postframe.setVisible(true);
		
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "아이디 중복체크를 하세요.");
	}
}















