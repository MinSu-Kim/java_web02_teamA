package kr.or.yi.hairshop.ui.panel.home;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import kr.or.yi.hairshop.dto.Product;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.RowSorter;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class pHomeWorkProductTable extends AbstractPanelTable<Product> implements MouseListener,ActionListener {
	private JPopupMenu popupMenuProduct=new JPopupMenu();
	private JMenuItem popupItemProduct=null;
	private int choiceRow;
	
	public pHomeWorkProductTable() {
		initComponents();
	}
	private void initComponents() {
		table.addMouseListener(this);
		popupItemProduct=new JMenuItem("삭제");
		popupItemProduct.addActionListener(this);
		popupMenuProduct.add(popupItemProduct);
		itemList=new ArrayList<Product>();
		table.setComponentPopupMenu(popupMenuProduct);
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
	protected void mouseEnteredThisTable(MouseEvent e) {
	}
	
	public void addProduct(Product product) {
		if(itemList.contains(product)==false) {
			itemList.add(product);
			reloadData();
		}else {
			JOptionPane.showMessageDialog(null, "이미 상품이 있습니다.");
		}
		
	}
	public List<Product> getProductList(){
		return this.itemList;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		itemList.remove(choiceRow);
		parent.setPriceSub();
		reloadData();
	}
	
	public void clearProduct() {
		itemList=new ArrayList<Product>();
		reloadData();
	}
}
