package kr.or.yi.hairshop.UI.Panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.UI.pCalendar;
import kr.or.yi.hairshop.dto.Guest;

@SuppressWarnings("serial")
public class pGuestMgn extends JPanel {

	private JTable table;	
	private List<Guest> gList;
	
	public pGuestMgn() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pGuestMain = new JPanel();
		pGuestMain.setBorder(new TitledBorder(null, "고객관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pGuestMain);
		pGuestMain.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pGuestMain.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setSize(200, 200);
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		pCalendar pCalendar = new pCalendar();
		panel.add(pCalendar);
		
		pGuestMgnBtn pBtn = new pGuestMgnBtn();
		panel.add(pBtn);
	}

	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		// 부서번호, 부서명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		// 부서번호, 부서명, 위치 의 폭을 (100, 200, 70)으로 가능하면 설정
		tableSetWidth(20, 20, 20, 20, 20, 20, 20, 20, 20, 20);
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[gList.size()][];
		for (int i = 0; i < gList.size(); i++) {
			rows[i] = gList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "등급", "손님명", "핸드폰", "주소", "생일", "최근작업목록", "가입일", "포인트", "매출액", "메모" };
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
