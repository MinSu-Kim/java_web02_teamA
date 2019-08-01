package kr.or.yi.hairshop.ui.panel.guest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import kr.or.yi.hairshop.dao.GuestMapper;
import kr.or.yi.hairshop.dao.GuestMapperImpl;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.panel.MyTableModel;
import kr.or.yi.hairshop.panel.pCalendar;
import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class pGuestMgn extends JPanel implements ActionListener {

	private JTable table;
	private List<Guest> gList;
	private GuestMapper dao = new GuestMapperImpl();

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	private JMenuItem mntmAdd;
	private GuestPanel pInfomation;

	public pGuestMgn() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel pGuestMain = new JPanel();
		pGuestMain.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uACE0\uAC1D\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		add(pGuestMain);
		pGuestMain.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pList = new JPanel();
		pGuestMain.add(pList);
		pList.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setSize(200, 200);

		pInfomation = new GuestPanel();
		pInfomation.setParent(pGuestMgn.this);
		pGuestMain.add(pInfomation);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		pCalendar pCalendar = new pCalendar();
		panel.add(pCalendar, BorderLayout.NORTH);
		pCalendar.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

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
		gList = dao.selectGuestByAll();
	}

	public void reloadData() {
		MyTableModel model = new MyTableModel(getRows(), getColumnNames());
		table.setModel(model);
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		tableSetWidth(20, 20, 50, 50, 80, 50, 50, 50, 100);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAdd) {
			pInfomation.clear();
			pInfomation.setBtn();
			pInfomation.resetGradeCmb();

		}
		if (e.getSource() == mntmUpdate) {
			int i = table.getSelectedRow();
			Guest selectGuest = gList.get(i);
			pInfomation.setGuestTf(selectGuest);
			
			pInfomation.setBtn2();

			
		}		
		if (e.getSource() == mntmDelete) {
			deleteGuestUI();
			pInfomation.resetGradeCmb();
			
		}		
	}
	
	
	
	
	private void deleteGuestUI() {
		int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.CLOSED_OPTION) {
			// 취소선택
		}else if (result == JOptionPane.YES_OPTION) {
			//예 선택
			int i = table.getSelectedRow();
			Guest selectGuest = gList.get(i);
			dao.deleteGuest(selectGuest.getgNo());
			pInfomation.clear();
			clearList();
			reloadData();
			pInfomation.setBtn();
		}else {
			//아니오 선택
		}
	}
	
	

	private Object[][] getRows() {
		Object[][] rows = new Object[gList.size()][];
		for (int i = 0; i < gList.size(); i++) {
			rows[i] = gList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "번호", "등급", "이름", "전화번호", "이메일", "생일", "가입일", "포인트", "메모" };
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

}
