package kr.or.yi.hairshop.ui.panel.workMain;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.junit.runners.ParentRunner;

import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Product;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class pHomeProductTable extends AbstractPanelTable<Product> implements MouseListener,ActionListener {
	
	private JPopupMenu popupMenuProduct=new JPopupMenu();
	private JMenuItem popupItemProduct=null;
	private int choiceRow;
	
	public pHomeProductTable() {
		
		initComponents();
	}
	private void initComponents() {
		table.addMouseListener(this);
		popupItemProduct=new JMenuItem("추가");
		popupItemProduct.addActionListener(this);
		popupMenuProduct.add(popupItemProduct);
		table.setComponentPopupMenu(popupMenuProduct);
	}

//	@Override
//	protected void reloadData() {
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
//		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
//		tableSetWidth(200, 200, 200);		
//	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "이름", "가격", "사용여부"};
	}

	@Override
	protected Object[] toArray(int i) {
		return itemList.get(i).toArray();
	}
	
	public void mouseClicked(MouseEvent e) {
		choiceRow = table.getSelectedRow();
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
	protected void mouseExitedThisTable(MouseEvent e) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		parent.setWorkProduct(itemList.get(choiceRow));
	}
	
}
