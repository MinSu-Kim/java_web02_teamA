package kr.or.yi.hairshop.ui.panel.home;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.hairshop.dto.Product;

public class pHomeProductTable extends AbstractPanelTable<Product> {
	
	
	
	public pHomeProductTable() {
		
	}

	@Override
	protected void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(200, 200, 200);		
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "이름", "가격", "사용여부"};
	}

	@Override
	protected Object[] toArray(int i) {
		return itemList.get(i).toArray();
	}
	
}
