package kr.or.yi.hairshop.ui.panel.guest;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dao.GuestMapper;
import kr.or.yi.hairshop.dao.GuestMapperImpl;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.panel.pCalendar;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class pGuestMgn extends JPanel {

	private JTable table;	
	private List<Guest> gList;
	private GuestMapper dao = new GuestMapperImpl();
	
	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	
	public pGuestMgn() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pGuestMain = new JPanel();
		pGuestMain.setBorder(new TitledBorder(null, "고객관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pGuestMain);
		pGuestMain.setLayout(new GridLayout(0, 1, 0, 0));
		
				JScrollPane scrollPane = new JScrollPane();
				pGuestMain.add(scrollPane);
				
						table = new JTable();
						scrollPane.setViewportView(table);
						scrollPane.setSize(200, 200);
						
				
		GuestPanel panel_2 = new GuestPanel();
		pGuestMain.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		pCalendar pCalendar = new pCalendar();
		panel.add(pCalendar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\home.jpg"));
		panel_1.add(lblNewLabel);
	}
	
	public void clearList() {
		gList = dao.selectGuestByAll();
	}

	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		tableSetWidth(20, 20, 50, 50, 80, 50, 50, 50, 100);
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
