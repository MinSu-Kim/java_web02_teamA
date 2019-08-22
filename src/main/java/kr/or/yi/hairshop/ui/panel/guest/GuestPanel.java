package kr.or.yi.hairshop.ui.panel.guest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.dao.GuestMapper;
import kr.or.yi.hairshop.dao.GuestMapperImpl;
import kr.or.yi.hairshop.dao.LevelMapper;
import kr.or.yi.hairshop.dao.LevelMapperImpl;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Level;
import kr.or.yi.hairshop.panel.MyTableModel;
import kr.or.yi.hairshop.ui.panel.guest.pGuestMgn.ReturnTableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GuestPanel extends JPanel implements ActionListener, MouseListener {
	private int gno;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfEmail;
	private JTextField tfMemo;
	private JButton btnAdd;
	private JTextField tfId;
	private JPasswordField tfPassword;
	private JPasswordField tfPassword2;
	private JDateChooser dcBirth;
	private JDateChooser dcJoin;
	private JSpinner spPoint;

	private GuestMapper dao = new GuestMapperImpl();
	private LevelMapper ldao = new LevelMapperImpl();
	private pGuestMgn parent;
	private JButton btnCancel;
	private JComboBox<Level> cbGrade;
	private List<Level> lList;
	private List<Guest> gList;
	private Level level;
	private JTextField tfGrade;
	private JTable table;
	
	private JPopupMenu popupMenu2;
	private JMenuItem mntmUpdate2;
	private JMenuItem mntmDelete2;
	private JMenuItem mntmAdd2;
	private JSpinner spSale;
	private JButton btnAdd2;
	private JButton btnCancel2;
	
	private String OriginalGrade;

	public void setParent(pGuestMgn pGuestMgn) {
		this.parent = pGuestMgn;
	}

	public GuestPanel() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
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
		resetGradeCmb();
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

		tfPassword = new JPasswordField();
		panel_1.add(tfPassword);
		tfPassword.setColumns(10);
		tfPassword.setEchoChar('*');
		
		JLabel lblNewLabel_9 = new JLabel("비밀번호확인");
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_9);
		
		
		tfPassword2 = new JPasswordField();
		panel_1.add(tfPassword2);
		tfPassword2.setColumns(10);
		tfPassword2.setEchoChar('*');

		
		
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
		spPoint.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(100)));
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

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB4F1\uAE09\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_5.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel lblGrade = new JLabel("등급 이름");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblGrade);

		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		panel_7.add(tfGrade);
		
		JLabel lblSale = new JLabel("할인율");
		lblSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblSale);
		
		spSale = new JSpinner();
		spSale.setModel(new SpinnerNumberModel(0, 0, 50, 5));
		panel_7.add(spSale);

		btnAdd2 = new JButton("등록");
		btnAdd2.addActionListener(this);
		panel_7.add(btnAdd2);

		btnCancel2 = new JButton("취소");
		btnCancel2.addActionListener(this);
		panel_7.add(btnCancel2);

		JLabel lblNewLabel_3 = new JLabel("");
		panel_7.add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("");
		panel_7.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		panel_7.add(lblNewLabel_8);

		JLabel lblNewLabel_4 = new JLabel("");
		panel_7.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		panel_7.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		panel_7.add(lblNewLabel_6);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB4F1\uAE09\uB9AC\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_5.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
	
		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		scrollPane.setSize(100, 100);
		
		clearLevelList();			
		reloadLevelData();
		
		
		popupMenu2 = new JPopupMenu();
		
		mntmAdd2 = new JMenuItem("등록");
		mntmAdd2.addActionListener(this);
		popupMenu2.add(mntmAdd2);
		
		mntmUpdate2 = new JMenuItem("수정");
		mntmUpdate2.addActionListener(this);
		popupMenu2.add(mntmUpdate2);
		
		mntmDelete2 = new JMenuItem("삭제");
		mntmDelete2.addActionListener(this);
		popupMenu2.add(mntmDelete2);
		
		table.setComponentPopupMenu(popupMenu2);
		scrollPane.setComponentPopupMenu(popupMenu2);
		
	}
	/*
	 * public void actionPerformed1(ActionEvent e) {
	 * 
	 * }
	 */

	public void resetGradeCmb() {
		setGuestList(ldao.selectLevelByAll());
	}

	private void deleteLevelUI() {
		int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
		
		if(res == JOptionPane.CLOSED_OPTION) {
			
		}else if (res == JOptionPane.YES_OPTION) {
			int i = table.getSelectedRow();
			Level selectLevel = lList.get(i);
			ldao.deleteLevel(selectLevel.getlGrade());
			clear2();
			clearLevelList();
			reloadLevelData();
			setBtn3();
		}else {
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel2) {
			actionPerformedBtnCancel2JButton(e);
		}
		if (e.getSource() == btnAdd2) {
			if(e.getActionCommand().equals("등록")) {
				actionPerformedBtnAdd2JButton(e);
				clear2();
				resetGradeCmb();
			}else if (e.getActionCommand().equals("수정")) {
				updateLevel();
				clear2();
				resetGradeCmb();
				setBtn3();
				
			}
			
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancelJButton(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("등록")) {
				actionPerformedBtnAddJButton(e);
				
			} else if (e.getActionCommand().equals("수정")) {
				updateGuest();
				
			}

		}

		
		if (e.getSource() == mntmAdd2) {
			clear2();
			setBtn3();
		}
		if (e.getSource() == mntmUpdate2) {
			int i = table.getSelectedRow();
			Level selectlevel = lList.get(i);
			setLevelTf(selectlevel);
			setBtn4();
			
			OriginalGrade = tfGrade.getText();
			
		}		
		if (e.getSource() == mntmDelete2) {
			deleteLevelUI();
			resetGradeCmb();
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
	
	protected void actionPerformedBtnAdd2JButton(ActionEvent e) {
		if (btnAdd2.getText() == "등록") {
			MakeLevel();
		}
	}
	protected void actionPerformedBtnUP2JButton(ActionEvent e) {
		if (btnAdd2.getText() == "수정") {
			updateLevel();
		}
	}

	
	protected void updateGuest() {
		Guest modifyguest = new Guest();
		
		
		Level level = (Level) cbGrade.getSelectedItem();
		String name = tfName.getText();
		String id = tfId.getText();
		String pass = tfPassword.getText();
		String pass2 = tfPassword2.getText();
		String tel = tfTel.getText();
		String email = tfEmail.getText();
		Date birth = dcBirth.getDate();
		Date join = dcJoin.getDate();
		int point = (int) spPoint.getValue();
		String memo = tfMemo.getText();

		
		
		
		modifyguest.setgNo(gno);
		modifyguest.setgLGrade(level);
		modifyguest.setgName(name);
		modifyguest.setgId(id);
		modifyguest.setgPassword(pass);
		modifyguest.setgPassword2(pass2);
		modifyguest.setgTel(tel);
		modifyguest.setgEmail(email);
		modifyguest.setgBirth(birth);
		modifyguest.setgJoin(join);
		modifyguest.setgPoint(point);
		modifyguest.setgMemo(memo);
		
		if(pass.equals(pass2)) {
			dao.updateGuest(modifyguest);
			clear();
			setBtn();
		}else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 다시확인해주세요!");
			clear3();
		}
		parent.clearList();
		parent.reloadData();
	}
	
	protected void updateLevel() {
//		Level lv = new Level();
//		
//		String grade = tfGrade.getText();
		int sale = (int) spSale.getValue();
//		
//		lv.setlGrade(grade);
//		lv.setlSale(sale);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Sale",sale );
		map.put("OriginalGrade", OriginalGrade);
		map.put("NewGrade", tfGrade.getText());
//		
//		
		ldao.updateLevel(map);
		clearLevelList();
		reloadLevelData();
	}

	private void MakeGuest() {
		Guest guest = new Guest();


		
		Level level = (Level) cbGrade.getSelectedItem();
		String name = tfName.getText();
		String id = tfId.getText();
		String pass = tfPassword.getText();
		String pass2 = tfPassword2.getText();
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
		guest.setgPassword2(pass2);
		guest.setgTel(tel);
		guest.setgEmail(email);
		guest.setgBirth(birth);
		guest.setgJoin(join);
		guest.setgPoint(point);
		guest.setgMemo(memo);

		if(pass.equals(pass2)) {
			dao.insertGuest(guest);
			clear();
		}else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 다시확인해주세요!");
			clear3();
		}
		
		
		parent.clearList();
		parent.reloadData();
		
	}
	
	private void MakeLevel() {
		Level lv = new Level();
		
		String grade = tfGrade.getText();
		int sale = (int) spSale.getValue();
		
		lv.setlGrade(grade);
		lv.setlSale(sale);
		
		ldao.insertLevel(lv);
		clearLevelList();
		reloadLevelData();
	}

	public void setBtn() {
		if (btnAdd.getText() == "수정") {
			btnAdd.setText("등록");
		}
	}

	public void setBtn2() {
		if (btnAdd.getText() == "등록") {
			btnAdd.setText("수정");
		}
	}
	
	public void setBtn3() {
		if (btnAdd2.getText() == "수정") {
			btnAdd2.setText("등록");
		}
	}

	public void setBtn4() {
		if (btnAdd2.getText() == "등록") {
			btnAdd2.setText("수정");
		}
	}

	public void setGuestTf(Guest g) {
		gno = g.getgNo();
		
		cbGrade.setSelectedItem(new Level(g.getgLGrade().getlGrade()));
		tfName.setText(g.getgName());
		tfId.setText(g.getgId());
//		tfPassword.setText(g.getgPassword());
		tfTel.setText(g.getgTel());
		tfEmail.setText(g.getgEmail());
		dcBirth.setDate(g.getgBirth());
		dcJoin.setDate(g.getgJoin());
		spPoint.setValue(g.getgPoint());
		tfMemo.setText(g.getgMemo());
		tfId.setEditable(false);
	}
	
	public void setLevelTf(Level lv) {
		tfGrade.setText(lv.getlGrade());
		spSale.setValue(lv.getlSale());
	}
	
	public void clear() {
		cbGrade.setSelectedIndex(-1);
		tfName.setText("");
		tfId.setText("");
		tfPassword.setText("");
		tfPassword2.setText("");
		tfTel.setText("");
		tfEmail.setText("");
		dcBirth.setDate(new Date());
		dcJoin.setDate(new Date());
		spPoint.setValue(0);
		tfMemo.setText("");
		tfId.setEditable(true);
	}
	
	public void clear2() {
		tfGrade.setText("");
		spSale.setValue(0);
	}
	
	public void clear3() {
		tfPassword.setText("");
		tfPassword2.setText("");
	}

	protected void actionPerformedBtnCancelJButton(ActionEvent e) {
		clear();
		setBtn();
	}
	
	protected void actionPerformedBtnCancel2JButton(ActionEvent e) {
		clear2();
		setBtn3();
	}

	public void setGuestList(List<Level> level) {
		DefaultComboBoxModel<Level> levelModels = new DefaultComboBoxModel<Level>(new Vector<Level>(level));
		cbGrade.setModel(levelModels);
		cbGrade.setSelectedIndex(-1);
	}
	
	
	
	public void clearLevelList() {
		lList = ldao.selectLevelByAll();
	}
	
	public void reloadLevelData() {
		MyTableModel model = new MyTableModel(getRows(), getColumnNames());
		table.setModel(model);
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableSetWidth(80, 80);
	}
	
	private Object[][] getRows() {
		Object[][] rows = new Object[lList.size()][];
		for (int i = 0; i < lList.size(); i++) {
			rows[i] = lList.get(i).toArray();
			
		}
		return rows;
	}
	
	private String[] getColumnNames() {
		
		return new String[] {"등급종류", "할인율(%)"};
	}
	
	// 테이블 셀 내용의 정렬
		protected void tableCellAlignment(int align, int... idx) {
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(align);

			TableColumnModel model = table.getColumnModel();
			for (int i = 0; i < idx.length; i++) {
				model.getColumn(idx[i]).setCellRenderer(dtcr);
			}
		}

		// 테이블 셀의 폭 설정
		protected void tableSetWidth(int... width) {
			for (int i = 0; i < getColumnNames().length; i++) {
				table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer2());
			}
			
			TableColumnModel cModel = table.getColumnModel();

			for (int i = 0; i < width.length; i++) {
				cModel.getColumn(i).setPreferredWidth(width[i]);
			}
		}
		
		public class ReturnTableCellRenderer2 extends JLabel implements TableCellRenderer {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				if (value==null) return this;
				setText(value.toString());
				setOpaque(true);
				
				if(column == 0) {
					setHorizontalAlignment(JLabel.CENTER);
				}
				if(column == 1) {
					setHorizontalAlignment(JLabel.CENTER);
				}
				
				if (table.getValueAt(row, 0).toString().equals("골드")) {
					setBackground(new Color(255, 215, 0, 30));
				}else if(table.getValueAt(row, 0).toString().equals("실버")) {
					setBackground(new Color(192, 192, 192, 70));
				}
				else {
					setBackground(Color.WHITE);
				}
				if (isSelected) {
					setBackground(Color.orange);
				}
				return this;
			}
		}
	
	
	
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
//		table.clearSelection();
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseExitedTableJTable(MouseEvent arg0) {
	}
}
