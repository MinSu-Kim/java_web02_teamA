package kr.or.yi.hairshop.ui.panel.home;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dto.Product;
import java.awt.BorderLayout;

public abstract class AbstractPanelTable<T> extends JPanel {
	protected JTable table;
	protected List<T> itemList;
	protected pHomeFooterDesigner parent;
	public AbstractPanelTable() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(250, 80));
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		scrollPane.setViewportView(table);

	}

	protected void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}
	

	protected abstract void reloadData();

	protected abstract String[] getColumnNames();

	protected Object[][] getRows() {
		Object[][] rows=null;
		if (itemList == null) {
			rows = new Object[][] {};
		} else {
			rows = new Object[itemList.size()][];
			for (int i = 0; i < itemList.size(); i++) {
				rows[i] = toArray(i);
			}
		}
		return rows;

	}
	public void setParent(pHomeFooterDesigner parent) {
		this.parent=parent;
	}
	
	
	protected abstract Object[] toArray(int i);

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
