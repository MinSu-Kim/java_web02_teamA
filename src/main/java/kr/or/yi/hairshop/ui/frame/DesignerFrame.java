package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
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
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.DesignerPanel;
import kr.or.yi.hairshop.ui.panel.product.pProductMgn;

import com.jtattoo.plaf.acryl.AcrylBorders.ComboBoxBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

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
	private JTextField tfdId;
	private JTextField tfdPassword;
	
	private JPanel panel_4;

	private JDateChooser dcdBirth;
	private JDateChooser dcdJoin;

	private pProductMgn pProductMgn;
	private DesignerPanel designerPanel;
//	private Object[] ComboBox  = {"","신입", "디자이너", "실장", "원장"};
	private Object[] ComboBox;
	private List<Designer> dList;
	private List<Object> dGradeList=new ArrayList<Object>();
	private JComboBox<Object> cmbdGrade;
	private JTextField tfdGrade;
	
	
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
	
		ds = new DesignerMapperImpl();
		dList=ds.selectDesignerByAll();
		
		for(int i=0; i<dList.size(); i++) {
			if(!dGradeList.contains(dList.get(i).getdGrade())) {
				dGradeList.add(dList.get(i).getdGrade());
				
			}
		
		}
		ComboBox=new Object[dGradeList.size()];
		
		for(int i=0; i<dGradeList.size(); i++) {
			ComboBox[i]=dGradeList.get(i);
		}
		
		
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
		
//		cmbdGrade = new JComboBox<Object>(ComboBox);
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
		
		dcdBirth = new JDateChooser();
		panel_4.add(dcdBirth);
		
		JLabel lbldJoin = new JLabel("입사일");
		lbldJoin.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lbldJoin);
		
		dcdJoin = new JDateChooser();
		panel_4.add(dcdJoin);
		
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
		
		designerPanel = new DesignerPanel();
		panel_1.add(designerPanel);
		
		designerPanel.clearList(dNo);
		designerPanel.reloadData();
	
		
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
		dcdBirth.setDate(new Date());
		dcdJoin.setDate(new Date());
		tfdMemo.setText("");	

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
	
	private void actionPerformedBtnAdd(ActionEvent arg0) { //등록버튼
		String tfi = tfdId.getText();
		String tfp = tfdPassword.getText();	
		String tfg = tfdGrade.getText();	
		String tfn =tfdName.getText();
		String tft =tfdTel.getText();
		String tft2 =tfdTel2.getText();	
		String tfa =tfdAddr.getText();
		String tfa2 =tfdAddr2.getText();
		Date tfb =dcdBirth.getDate();
		Date tfj =dcdJoin.getDate();
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
		designer.setdBirth(tfb);
		designer.setdJoin(tfj);
		designer.setdMemo(tfm);
		
		ds.insertDesigner(designer);
		JOptionPane.showMessageDialog(null, "입력되었습니다.");
		clearTextField();
		pProductMgn.setWorkList(ds.selectDesignerByAll());
		pProductMgn.reloadData();
	}
	
	public void setText(Designer design) {
		dNo = design.getdNo();
		
		List<WorkDialog> workDialog=wdao.selectByfivejoinMap(dNo);
		designerPanel.setWorkdialogList(workDialog);
		designerPanel.reloadData();
		
		tfdId.setText(design.getdId());
		tfdPassword.setText(design.getdPassword());
		System.out.println(design.getdGrade());
		cmbdGrade.setSelectedItem(design.getdGrade());	
		tfdName.setText(design.getdName());
		tfdTel.setText(design.getdTel());
		tfdTel2.setText(design.getdTel2());
		tfdAddr.setText(design.getdAddr());
		tfdAddr2.setText(design.getdAddr2());
		dcdBirth.setDate(design.getdBirth());
		dcdJoin.setDate(design.getdJoin());
		tfdMemo.setText(design.getdMemo());
	}
	
	public void actionPerformedBtnModify(ActionEvent arg0) { //수정버튼
		String id = tfdId.getText();
		String ps = tfdPassword.getText();
		String grade = (String) cmbdGrade.getSelectedItem();
		
		String name = tfdName.getText();
		String tel = tfdTel.getText();
		String tel2 = tfdTel2.getText();
		String addr = tfdAddr.getText();
		String addr2 = tfdAddr2.getText();
		Date tfb =dcdBirth.getDate();
		Date tfj =dcdJoin.getDate();
		String memo = tfdMemo.getText();
		
		Designer designer = new Designer(dNo, grade, id, ps, name, tel, tel2, addr, addr2, tfb, tfj, memo);
		JOptionPane.showMessageDialog(null, designer.toString2());
		ds.updateDesigner(designer);
		pProductMgn.setWorkList(ds.selectDesignerByAll());
		JOptionPane.showMessageDialog(null, "수정되었습니다.");
		clearTextField();
		pProductMgn.reloadData();
	}

	
	public void setParent(HairMainFrame hairMainFrame) {
		
	}

	public void setBtnText(String string) {
		button.setText(string);
	}

	public void setProductMgn(pProductMgn pP) {
		this.pProductMgn = pP;
	}
	
}















