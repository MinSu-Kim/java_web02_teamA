package kr.or.yi.hairshop.ui.panel.workMain;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.hairshop.dto.Guest;

public class pHomeTfgNameTable extends AbstractPanelTable<Guest> implements MouseListener{
	
	private int choiceRow;
	public pHomeTfgNameTable() {
		initComponents();
	}
	private void initComponents() {
		table.addMouseListener(this);
		
	}
//	@Override
//	public void reloadData() {
//		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
//		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
//		tableSetWidth(200, 200, 200);
//	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "이름","생일","아이디", "등급"};
	}

	@Override
	protected Object[] toArray(int i) {
		return itemList.get(i).toArray2();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		choiceRow = table.getSelectedRow();
		parent.setTfGuest(itemList.get(choiceRow));
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
