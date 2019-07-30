package kr.or.yi.hairshop.ui.panel.guest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.dao.GuestMapper;
import kr.or.yi.hairshop.dao.GuestMapperImpl;
import kr.or.yi.hairshop.dao.LevelMapper;
import kr.or.yi.hairshop.dao.LevelMapperImpl;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Level;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class GuestPanel extends JPanel implements ActionListener {
	private int gno;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfMemo;
	private JButton btnAdd;
	private JTextField tfId;
	private JTextField tfPassword;
	private JDateChooser dcBirth;
	private JDateChooser dcJoin;
	private JSpinner spPoint;

	private GuestMapper dao = new GuestMapperImpl();
	private LevelMapper ldao = new LevelMapperImpl();
	private pGuestMgn parent;
	private JButton btnCancel;
	private JComboBox<Level> cbGrade;
	private Level level;

	public void setParent(pGuestMgn pGuestMgn) {
		this.parent = pGuestMgn;
	}

	public GuestPanel() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 15, 10));

		JLabel label = new JLabel("등급");
		label.setFont(new Font("굴림", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label);
		
		cbGrade = new JComboBox<Level>();
		setGuestList(ldao.selectLevelByAll(level));
		panel_1.add(cbGrade);

		JLabel label_1 = new JLabel("이름");
		label_1.setFont(new Font("굴림", Font.PLAIN, 14));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);

		tfName = new JTextField();
		tfName.setColumns(20);
		panel_1.add(tfName);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);

		tfId = new JTextField();
		panel_1.add(tfId);
		tfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);

		tfPassword = new JTextField();
		panel_1.add(tfPassword);
		tfPassword.setColumns(10);

		JLabel label_2 = new JLabel("전화번호");
		label_2.setFont(new Font("굴림", Font.PLAIN, 14));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);

		tfTel = new JTextField();
		tfTel.setColumns(20);
		panel_1.add(tfTel);

		JLabel label_3 = new JLabel("이메일");
		label_3.setFont(new Font("굴림", Font.PLAIN, 14));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_3);

		tfEmail = new JTextField();
		tfEmail.setColumns(20);
		panel_1.add(tfEmail);

		JLabel label_4 = new JLabel("생일");
		label_4.setFont(new Font("굴림", Font.PLAIN, 14));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_4);

		dcBirth = new JDateChooser();
		panel_1.add(dcBirth);

		JLabel label_5 = new JLabel("가입일");
		label_5.setFont(new Font("굴림", Font.PLAIN, 14));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_5);

		dcJoin = new JDateChooser();
		panel_1.add(dcJoin);

		JLabel label_6 = new JLabel("포인트");
		label_6.setFont(new Font("굴림", Font.PLAIN, 14));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_6);

		spPoint = new JSpinner();
		spPoint.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(100)));
		panel_1.add(spPoint);

		JLabel label_7 = new JLabel("메모");
		label_7.setFont(new Font("굴림", Font.PLAIN, 14));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_7);

		tfMemo = new JTextField();
		tfMemo.setColumns(20);
		panel_1.add(tfMemo);

		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 1, 10, 10));

		btnAdd = new JButton("등록");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);
		
		
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\ppp.jpg"));
		panel_4.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		add(panel_2);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancelJButton(e);
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("등록")) {
				actionPerformedBtnAddJButton(e);
			}else if(e.getActionCommand().equals("수정")){
				updateGuest();
				clear();
				setBtn();
			}
			
		}
		
	}

	protected void actionPerformedBtnAddJButton(ActionEvent e) {
		if (btnAdd.getText() == "등록") {
			MakeGuest();
		} 
	}

	protected void actionPerformedBtnUPJButton(ActionEvent e) {
		if (btnAdd.getText() == "수정") {
			updateGuest();
		} 
	}
	
	protected void updateGuest() {
		Guest modifyguest = new Guest();
		
		Level level = (Level) cbGrade.getSelectedItem();
		String name = tfName.getText();
		String id = tfId.getText();
		String pass = tfPassword.getText();
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		Date birth = dcBirth.getDate();
		Date join = dcJoin.getDate();
		int point = (int) spPoint.getValue();
		String memo = tfMemo.getText();

		modifyguest.setgNo(gno);
		modifyguest.setgLGrade(level);;
		modifyguest.setgName(name);
		modifyguest.setgId(id);
		modifyguest.setgPassword(pass);
		modifyguest.setgTel(tel);
		modifyguest.setgEmail(email);
		modifyguest.setgBirth(birth);
		modifyguest.setgJoin(join);
		modifyguest.setgPoint(point);
		modifyguest.setgMemo(memo);

		dao.updateGuest(modifyguest);
		parent.clearList();
		parent.reloadData();

	}

	private void MakeGuest() {
		Guest guest = new Guest();
		
		Level level = (Level) cbGrade.getSelectedItem();
		String name = tfName.getText();
		String id = tfId.getText();
		String pass = tfPassword.getText();
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		Date birth = dcBirth.getDate();
		Date join = dcJoin.getDate();
		int point = (int) spPoint.getValue();
		String memo = tfMemo.getText();

		guest.setgLGrade(level);
		guest.setgName(name);
		guest.setgId(id);
		guest.setgPassword(pass);
		guest.setgTel(tel);
		guest.setgEmail(email);
		guest.setgBirth(birth);
		guest.setgJoin(join);
		guest.setgPoint(point);
		guest.setgMemo(memo);

		dao.insertGuest(guest);
		
		parent.clearList();
		parent.reloadData();
	}

	public void setBtn() {
		if (btnAdd.getText() == "수정") {
			btnAdd.setText("등록");
		} 
	}
	
	public void setBtn2() {
		if(btnAdd.getText() == "등록"){
			btnAdd.setText("수정");
		}
	}

	public void setGuestTf(Guest g) {
		gno = g.getgNo();
		cbGrade.setSelectedItem(g.getgLGrade().getlGrade());
		tfName.setText(g.getgName());
		tfId.setText(g.getgId());
		tfPassword.setText(g.getgPassword());
		tfTel.setText(g.getgTel());
		tfEmail.setText(g.getgEmail());
		dcBirth.setDate(g.getgBirth());
		dcJoin.setDate(g.getgJoin());
		spPoint.setValue(g.getgPoint());
		tfMemo.setText(g.getgMemo());

	}

	public void clear() {
		cbGrade.setSelectedItem(1);
		tfName.setText("");
		tfId.setText("");
		tfPassword.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		dcBirth.setDate(new Date());
		dcJoin.setDate(new Date());
		spPoint.setValue(0);
		tfMemo.setText("");

	}

	protected void actionPerformedBtnCancelJButton(ActionEvent e) {
		clear();
	}
	
	public void setGuestList(List<Level> level) {
		DefaultComboBoxModel<Level> levelModels = new DefaultComboBoxModel<Level>(new Vector<Level>(level));
		cbGrade.setModel(levelModels);
		cbGrade.setSelectedIndex(1);
	}
}
