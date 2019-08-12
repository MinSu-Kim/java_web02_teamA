package kr.or.yi.hairshop.ui.panel.reserve;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.HairMainFrame;
import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.MyTableModel;

@SuppressWarnings("serial")
public class pReservationMgn extends JPanel implements ActionListener, PropertyChangeListener {
	
	private List<WorkDialog> workList;
	private List<Designer> dList;
	private WorkDialogMapper wDao = new WorkDialogMapperImpl();
	private DesignerMapper dDao = new DesignerMapperImpl();

	private JTable table;
	private JButton btnSearch;
	private JButton btnAllSearch;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private JMenuItem mntmAdd;
	private JDateChooser dcStart;
	private JDateChooser dcEnd;
	private JButton btnToday;
	private JButton btnThisMon;
	private JButton btnThisWeek;
	private JCalendar rCalendar;

	private HairMainFrame parent;
	
	private JComboBox<Designer> cmbDesigner;
	private DefaultComboBoxModel<Designer> designerCmbModel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSelect;
	private JRadioButton rdbtnAll;
	private JTextField tfGuestName;
	private JButton btnNameSearch;
	
	
	public pReservationMgn() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		panel.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		pNorth.add(panel_4, BorderLayout.WEST);
		panel_4.setBorder(new TitledBorder(null, "\uB0A0\uC9DC \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("시작일");
		panel_8.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		dcStart = new JDateChooser();
		panel_8.add(dcStart);
		
		JLabel label_1 = new JLabel("종료일");
		panel_8.add(label_1);
		label_1.setFont(new Font("굴림", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		dcEnd = new JDateChooser();
		panel_8.add(dcEnd);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		btnSearch = new JButton("검색");
		panel_9.add(btnSearch);
		btnSearch.setToolTipText("");
		btnSearch.addActionListener(this);
		
		JPanel panel_5 = new JPanel();
		pNorth.add(panel_5);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "\uB0A0\uC9DC \uAE30\uC900", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		panel_5.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("☆ 일자별 검색을 우측 달력의 일자를 선택해 주세요");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_4);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnToday = new JButton("today");
		panel_11.add(btnToday);
		
		btnThisWeek = new JButton("week");
		panel_11.add(btnThisWeek);
		
		btnThisMon = new JButton("month");
		panel_11.add(btnThisMon);
		
		btnAllSearch = new JButton("All");
		panel_11.add(btnAllSearch);
		btnAllSearch.addActionListener(this);
		btnThisMon.addActionListener(this);
		btnThisWeek.addActionListener(this);
		btnToday.addActionListener(this);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "손님 기준", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_5.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnAll = new JRadioButton("전체 선택");
		panel_3.add(rdbtnAll);
		rdbtnAll.setSelected(true);
		buttonGroup.add(rdbtnAll);
		
		dList = dDao.selectDesignerByAll();
		designerCmbModel = new DefaultComboBoxModel<Designer>(new Vector<Designer>(dList));
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		rdbtnSelect = new JRadioButton("디자이너 선택");
		panel_3.add(rdbtnSelect);
		buttonGroup.add(rdbtnSelect);
		
		cmbDesigner = new JComboBox<Designer>();
		panel_3.add(cmbDesigner);
		cmbDesigner.setModel(designerCmbModel);
		
		cmbDesigner.setSelectedIndex(-1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "손님 기준", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_5.add(panel_7);
		
		tfGuestName = new JTextField("이름 검색");
		panel_7.add(tfGuestName);
		tfGuestName.setColumns(10);
		
		btnNameSearch = new JButton("검색");
		btnNameSearch.addActionListener(this);
		panel_7.add(btnNameSearch);
		
		JPanel pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "예약정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pList);
		
		JPanel pR = new JPanel();
		add(pR, BorderLayout.EAST);
		pList.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		pList.add(panel_6, BorderLayout.NORTH);
		pR.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		pR.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\home.jpg"));
		panel_1.add(lblNewLabel);
		
		rCalendar = new JCalendar();
		rCalendar.getDayChooser().addPropertyChangeListener(this);
		rCalendar.setWeekOfYearVisible(false);
		pR.add(rCalendar, BorderLayout.NORTH);

		popupMenu = new JPopupMenu();
		
		mntmAdd = new JMenuItem("등록");
		mntmAdd.addActionListener(this);
		popupMenu.add(mntmAdd);
		
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);
		
		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		
//		table.setComponentPopupMenu(popupMenu);
//		scrollPane.setComponentPopupMenu(popupMenu);
	}
	
	public void setParent(HairMainFrame HairMainFrame) {
		this.parent = HairMainFrame;
	}
	
	public void clearList() {
		workList = wDao.selectReservDetail();
	}

	public void reloadData() {
		MyTableModel model = new MyTableModel(getRows(), getColumnNames());
		table.setModel(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(20, 80, 40, 40, 40, 40, 80, 40, 40, 80);
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[workList.size()][];
		for (int i = 0; i < workList.size(); i++) {
			rows[i] = workList.get(i).toArrayReservDetail();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "번호", "예약일시", "디자이너", "직책", "손님명", "손님등급", "작업명", "이벤트", "가격", "완료일시"};
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
			table.getColumnModel().getColumn(i).setCellRenderer(new ReturnTableCellRenderer());
		}
		
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			
			if(column == 8) {
				setHorizontalAlignment(JLabel.RIGHT);
			}else {
				setHorizontalAlignment(JLabel.CENTER);
			}
			
			SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			String date = sDate.format(today);

			if ( table.getValueAt(row, 1).toString().substring(0, 10).equals(date) ) { //오늘 날짜 면
				setBackground(new Color(255, 129, 228, 30));
			}else if( !table.getValueAt(row, 9).toString().equals("작업전") ) {
				setBackground(new Color(245, 185, 174, 100));
			}else if( !table.getValueAt(row, 7).toString().equals("일반") ){
				setBackground(new Color(150, 235, 176, 100));
			}else {
				setBackground(Color.WHITE);
			}

			
			if (isSelected) {
				setBackground(Color.orange);
			}
			return this;
		}
	}	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNameSearch) {
			actionPerformedBtnNameSearch(e);
		}
		if (e.getSource() == btnThisWeek) {
			actionPerformedBtnThisWeek(e);
		}
		if (e.getSource() == btnThisMon) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnAllSearch) {
			actionPerformedBtnAllSearch(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == mntmAdd) {
			JOptionPane.showMessageDialog(null, "등록");
		}
		if (e.getSource() == mntmUpdate) {
			JOptionPane.showMessageDialog(null, "수정");
		}		
		if (e.getSource() == mntmDelete) {
			JOptionPane.showMessageDialog(null, "삭제");
		}

	}
	protected void actionPerformedBtnSearch(ActionEvent arg0) {
		
		
		//검색 버튼
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd 00:00");
		SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd 23:59");
		
		if(dcStart.getDate() == null || dcEnd.getDate() == null) {
			JOptionPane.showMessageDialog(null, "날짜를 모두 선택하세요");
		}else {
			String sDay = sdate.format(dcStart.getDate());
			String eDay = edate.format(dcEnd.getDate());
			Map<String, String> map = new HashMap<String, String>();
			map.put("start", sDay);
			map.put("end", eDay);
			if (rdbtnSelect.isSelected()) { //디자이너 검색으로 선택되어 있으면
				Designer selDesigner = (Designer) cmbDesigner.getSelectedItem();
				map.put("name", selDesigner.getdName());
			}
			
			workList = wDao.selectReservDetailByDate(map);
			reloadData();			
		}
		
	}
	protected void actionPerformedBtnAllSearch(ActionEvent arg0) {
		if (rdbtnSelect.isSelected()) { //디자이너 검색으로 선택되어 있으면
			Designer selDesigner = (Designer) cmbDesigner.getSelectedItem();
			workList = wDao.selectReservDetailByDesignerName(selDesigner.getdName());
		}else {
			workList = wDao.selectReservDetail();
		}
		reloadData();
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		//이번달 검색
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-01 00:00");
		SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-31 23:59");
		Date today = new Date();
		
		String sDay = sdate.format(today);
		String eDay = edate.format(today);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", sDay);
		map.put("end", eDay);		
		if (rdbtnSelect.isSelected()) { //디자이너 검색으로 선택되어 있으면
			Designer selDesigner = (Designer) cmbDesigner.getSelectedItem();
			map.put("name", selDesigner.getdName());
		}
		
		workList = wDao.selectReservDetailByDate(map);
		reloadData();
	}
	protected void actionPerformedBtnThisWeek(ActionEvent e) {
		//이번 주 검색
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd 00:00");
		SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd 23:59");
		Date today = new Date();
		
		Calendar c = Calendar.getInstance();

		c.setTime(today);
		c.add(Calendar.DATE, 3);		
		String eDay = edate.format(c.getTime());
		
		c.setTime(today);
		c.add(Calendar.DATE, -3);
		String sDay = sdate.format(c.getTime());

		Map<String, String> map = new HashMap<String, String>();
		map.put("start", sDay);
		map.put("end", eDay);		
		if (rdbtnSelect.isSelected()) { //디자이너 검색으로 선택되어 있으면
			Designer selDesigner = (Designer) cmbDesigner.getSelectedItem();
			map.put("name", selDesigner.getdName());
		}
		
		workList = wDao.selectReservDetailByDate(map);
		reloadData();
	}
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getSource() == rCalendar.getDayChooser()) {
			propertyChangeRCalendarDayChooser(arg0);
		}
	}
	protected void propertyChangeRCalendarDayChooser(PropertyChangeEvent arg0) {
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd 00:00");
		SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd 23:59");
		
		String oneDay = sdate.format(rCalendar.getDate());
		String endDay = edate.format(rCalendar.getDate());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", oneDay);
		map.put("end", endDay);
		if (rdbtnSelect.isSelected()) { //디자이너 검색으로 선택되어 있으면
			Designer selDesigner = (Designer) cmbDesigner.getSelectedItem();
			map.put("name", selDesigner.getdName());
		}
		
		workList = wDao.selectReservDetailByDate(map);
		reloadData();	
	}
	protected void actionPerformedBtnNameSearch(ActionEvent e) {
		workList = wDao.selectReservDetailByGuestName(tfGuestName.getText());
		reloadData();
	}
}


  













