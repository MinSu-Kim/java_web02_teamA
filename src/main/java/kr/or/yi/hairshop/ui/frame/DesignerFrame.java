package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.hairshop.HairMainFrame;
import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.panel.DesignerPanel;

@SuppressWarnings("serial")
public class DesignerFrame extends JFrame implements ActionListener {
	private DesignerMapper ds = new DesignerMapperImpl ();
	
	private JPanel contentPane;
	private JTextField tfdName;
	private JTextField tfdTel;
	private JTextField tfdTel2;
	private JTextField tfdAddr;
	private JTextField tfdAddr2;
	private JTextField tfdBirth;
	private JTextField tfdJoin;
	private JTextField tfdMemo;
	private JButton button;
	private DesignerMapper dsmapper;
	private JTable tableDesigner;
	private List<Designer> DesignList;
	private JTextField textField;
	private JTextField tfdGrade;
	private JTextField tfId;
	private JTextField tfdPassword;

	private JTextField tfdId;
	private JPanel panel_4;
	
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

	public DesignerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 624);
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
		
		panel_4 = new JPanel();
		panel_4.setSize(200, 400);
		panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel label = new JLabel("아이디");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(label);
		
		tfdId = new JTextField();
		tfdId.setColumns(10);
		panel_4.add(tfdId);
		
		JLabel lbldPassword = new JLabel("비밀번호");
		lbldPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldPassword);
		
		tfdPassword = new JTextField();
		tfdPassword.setColumns(10);
		panel_4.add(tfdPassword);
		
		
		JLabel lbldGrade = new JLabel("직책");
		lbldGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldGrade);
		
		tfdGrade = new JTextField();
		tfdGrade.setColumns(10);
		panel_4.add(tfdGrade);
		
		
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
		
		JLabel lbldTel2 = new JLabel("비상연락망");
		lbldTel2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldTel2);
		
		tfdTel2 = new JTextField();
		panel_4.add(tfdTel2);
		tfdTel2.setColumns(10);
		
		JLabel lbldAddr = new JLabel("주소");
		lbldAddr.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldAddr);
		
		tfdAddr = new JTextField();
		panel_4.add(tfdAddr);
		tfdAddr.setColumns(10);
		
		JLabel lbldAddr2 = new JLabel("상세주소");
		lbldAddr2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldAddr2);
		
		tfdAddr2 = new JTextField();
		panel_4.add(tfdAddr2);
		tfdAddr2.setColumns(10);
		
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
		
		JLabel lbldMemo = new JLabel("메모");
		lbldMemo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldMemo);
		
		tfdMemo = new JTextField();
		tfdMemo.setColumns(10);
		panel_4.add(tfdMemo);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		button = new JButton("확인");
		button.addActionListener(this);
		panel_5.add(button);
		
		DesignerPanel panel_3 = new DesignerPanel();
		panel_1.add(panel_3);
		
		panel_3.clearList();
		panel_3.reloadData();
	
		
	}

		
	public void clearTextField() { 
		tfdId.setText("");
		tfdPassword.setText("");
		tfdGrade.setText("");
		tfdName.setText("");
		tfdTel.setText("");
		tfdTel2.setText("");
		tfdAddr.setText("");
		tfdAddr2.setText("");
		tfdBirth.setText("");
		tfdJoin.setText("");
		tfdMemo.setText("");	
//		tfdId.
//		tfdPassword.
//		tfdGrade.
//		tfdName.
//		tfdTel.
//		tfdTel2.
//		tfdAddr.
//		tfdAddr2.
//		tfdBirth.
//		tfdJoin.
//		tfdMemo.
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			if(arg0.getActionCommand().equals("등록")) {
				actionPerformedBtnAdd(arg0);
			}
			if(arg0.getActionCommand().equals("수정")) {
				actionPerformedBtnModify(arg0);
			}			
		}
	}

	/* tfdPassword.
		tfdGrade.
		tfdName.
		tfdTel.
		tfdTel2.
		tfdAddr.
		tfdAddr2.
		tfdBirth.
		tfdJoin.
		tfdMemo. */
	
	private void actionPerformedBtnModify(ActionEvent arg0) { //수정버튼
		Designer designer = new Designer();
		
		String id = designer.getdId();
		String ps = designer.getdPassword();
		String grade = designer.getdGrade();
		String name = designer.getdName();
		String tel = designer.getdTel();
		String tel2 = designer.getdTel2();
		String addr = designer.getdAddr();
		String addr2 = designer.getdAddr2();
		Date tfb =designer.getdBirth();
		Date tfj =designer.getdJoin();		
		String memo = designer.getdMemo();
		
		//텍스트필드에 보이게 뿌리기
		tfdId.setText(id);
		tfdPassword.setText(ps);
		tfdGrade.setText(grade);
		tfdName.setText(name);
		tfdTel.setText(tel);
		tfdTel2.setText(tel2);
		tfdAddr.setText(addr);
		tfdAddr2.setText(addr2);
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");		
		tfdBirth.setText(sd.format(tfb));
		tfdJoin.setText(sd.format(tfj));		
		tfdMemo.setText(memo);	
		
		//뿌리고 난다음 입력한 값으로 바껴야 함.
		
	}

	private void actionPerformedBtnAdd(ActionEvent arg0) { //등록버튼
		String tfi = tfdId.getText();
		String tfp = tfdPassword.getText();	
		String tfg =tfdGrade.getText();
		String tfn =tfdName.getText();
		String tft =tfdTel.getText();
		String tft2 =tfdTel2.getText();	
		String tfa =tfdAddr.getText();
		String tfa2 =tfdAddr2.getText();
		String tfb =tfdBirth.getText();
		String tfj =tfdJoin.getText();
		String tfm =tfdMemo.getText();		
				
		Designer designer = new Designer();
		designer.setdId(tfi);
		designer.setdPassword(tfp);
		designer.setdGrade(tfg);
		designer.setdName(tfn);
		designer.setdTel(tft);
		designer.setdTel2(tft2);
		designer.setdAddr(tfa);
		designer.setdAddr2(tfa2);

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			designer.setdBirth(sd.parse(tfb));
			designer.setdJoin(sd.parse(tfj));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		designer.setdMemo(tfm);
		
		ds.insertDesigner(designer);
		JOptionPane.showMessageDialog(null, "입력되었습니다.");
		clearTextField();
		
	}

	public void setParent(HairMainFrame hairMainFrame) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}















