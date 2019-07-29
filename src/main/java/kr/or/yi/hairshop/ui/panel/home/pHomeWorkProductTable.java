package kr.or.yi.hairshop.ui.panel.home;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.hairshop.dto.Product;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;

public class pHomeWorkProductTable extends AbstractPanelTable<Product> implements MouseListener {
	public pHomeWorkProductTable() {
		initComponents();
	}
	private void initComponents() {
		itemList=new ArrayList<Product>();
		table.addMouseListener(this);
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
		return itemList.get(i).toArray2();
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
		table.clearSelection();
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredThisTable(MouseEvent e) {
	}
	public void addProduct(Product product) {
		itemList.add(product);
		reloadData();
	}
	public List<Product> getProductList(){
		return itemList;
	}
}
