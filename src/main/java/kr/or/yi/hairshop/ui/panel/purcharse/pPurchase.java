package kr.or.yi.hairshop.ui.panel.purcharse;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dto.Tax;

public class pPurchase extends JPanel {

	private JTable table;	
	private List<Tax> tList;
	
	public pPurchase() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JSpinner spStart = new JSpinner();
		spStart.setModel(new SpinnerDateModel(new Date(1563721200000L), null, null, Calendar.DAY_OF_YEAR));
		panel_1.add(spStart);
		
		JSpinner spEnd = new JSpinner();
		spEnd.setModel(new SpinnerDateModel(new Date(1563721200000L), null, null, Calendar.DAY_OF_YEAR));
		panel_1.add(spEnd);
		
		JPanel pList = new JPanel();
		panel.add(pList);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setSize(200, 200);
		
	}
	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));

		// 부서번호, 부서명은 가운데 정렬
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3);
		// 부서번호, 부서명, 위치 의 폭을 (100, 200, 70)으로 가능하면 설정
		tableSetWidth(20, 20, 20, 20);
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[tList.size()][];
		for (int i = 0; i < tList.size(); i++) {
			rows[i] = tList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "번호", "제품명", "단가", "구매일"};
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
