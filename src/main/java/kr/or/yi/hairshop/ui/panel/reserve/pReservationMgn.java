package kr.or.yi.hairshop.ui.panel.reserve;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JCalendar;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.pCalendar;

@SuppressWarnings("serial")
public class pReservationMgn extends JPanel implements ActionListener {
	
	private List<WorkDialog> workList;
	private WorkDialogMapper dao = new WorkDialogMapperImpl();
	private JTable table;
	private JButton btnSearch;
	private JCalendar calStart;
	private JCalendar calEnd;
	private JButton btnAllSearch;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private JMenuItem mntmAdd;
	private JButton button;
	
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
		
		calStart = new JCalendar();
		calStart.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd 00:00");
				SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd 23:59");
				
				String oneDay = sdate.format(calStart.getDate());
				String endDay = edate.format(calStart.getDate());
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("start", oneDay);
				map.put("end", endDay);
				
				workList = dao.selectReservDetailByDate(map);
				reloadData();
				
			}
		});
		
		pNorth.add(calStart);
		
		calEnd = new JCalendar();
		calEnd.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd 00:00");
				SimpleDateFormat edate = new SimpleDateFormat("yyyy-MM-dd 23:59");
				
				String oneDay = sdate.format(calEnd.getDate());
				String endDay = edate.format(calEnd.getDate());
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("start", oneDay);
				map.put("end", endDay);
				
				workList = dao.selectReservDetailByDate(map);
				reloadData();
				
			}
		});		
		
		pNorth.add(calEnd);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pNorth.add(btnSearch);
		
		btnAllSearch = new JButton("전체 검색");
		btnAllSearch.addActionListener(this);
		pNorth.add(btnAllSearch);
		
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
		pR.setLayout(new BorderLayout(0, 0));
		
		pCalendar pCalendar = new pCalendar();
		pR.add(pCalendar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		pR.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\home.jpg"));
		panel_1.add(lblNewLabel);

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
		
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setComponentPopupMenu(popupMenu);
	}
	
	public void clearList() {
		workList = dao.selectReservDetail();
	}

	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(20, 80, 40, 40, 40, 40, 40, 40, 40, 80);

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
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
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
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		String sDay = date.format(calStart.getDate());
		String eDay = date.format(calEnd.getDate());
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", sDay);
		map.put("end", eDay);
		
		workList = dao.selectReservDetailByDate(map);
		reloadData();
		
	}
	protected void actionPerformedBtnAllSearch(ActionEvent arg0) {
		clearList();
		reloadData();
	}

}
















