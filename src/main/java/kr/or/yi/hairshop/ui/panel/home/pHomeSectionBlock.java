package kr.or.yi.hairshop.ui.panel.home;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.ui.frame.WorkDialogFrame;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class pHomeSectionBlock extends JPanel implements MouseListener, ActionListener {
	JTable jtable;
	private JLabel lblDesigner;
	private Designer designer;
	private DefaultTableModel model;
//	private Map<Integer, WorkDialog> list=new HashMap<Integer, WorkDialog>();

	private Map<Integer, ArrayList<WorkDialog>> dWorkList = new HashMap<Integer,ArrayList<WorkDialog>>();
	private final String[] columns = {"손님" };

	private WorkDialogMapper dao = new WorkDialogMapperImpl();
	private WorkDialogFrame frame;
	private String[][] data = { 
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},			
			{""},
			{""}, 
			{""}, 
			{""}, 
			{""}, 
			{""}, 
			{""},
			{""}, 
			{""}, 
			{""}};
	private JPanel panelCenter;

	private JScrollPane spane;
	private pHomeSectionForm parent;
	private JMenuItem menuItemList;

	public pHomeSectionBlock() {
		setBorder(null);

		setLayout(new BorderLayout());

		model = new DefaultTableModel(data, columns);

		jtable = new JTable(model);

		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		jtable.addMouseListener(this);
		tableSetWidth(100);
		spane = new JScrollPane(jtable);

		JPanel panelNorth = new JPanel();

		add(panelNorth, BorderLayout.NORTH);
		lblDesigner = new JLabel("디자이너이름");

		panelNorth.add(lblDesigner);

		panelCenter = new JPanel();
		panelCenter.setBorder(null);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelCenter.add(spane);

		add(panelCenter, BorderLayout.CENTER);

	}

//	public static void main(String[] args) {
//		JFrame f = new JFrame("JTable Test");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		PanelDesignerScheduleBlock jt = new PanelDesignerScheduleBlock();
//		f.getContentPane().add(jt);
//		f.setSize(300, 200);
//		f.setVisible(true);
//	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		jtable.clearSelection();
		
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent me) {

//		Iterator<Integer> map1 = dWorkList.keySet().iterator();
//		while (map1.hasNext()) {
//			int key1 = map1.next();
//			Iterator<Integer> map2 = dWorkList.get(key1).keySet().iterator();
//			while (map2.hasNext()) {
//				int key2 = map2.next();
////				System.out.println(String.format("key1=%s, key2=%s,value=%s", key1, key2, dWorkList.get(key1).get(key2)));
////				WorkDialog workDialog = dWorkList.get(key1).get(key2);
//			}
//
//		}

		int row = jtable.getSelectedRow();
		parent.getMenuPopup().removeAll();
		
		if (dWorkList.get(row) != null) {
//			Iterator<Integer> map = dWorkList.get(row).keySet().iterator();
			for(int i=0; i<dWorkList.get(row).size(); i++) {
				WorkDialog workDialog = dWorkList.get(row).get(i);
				SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
				menuItemList = new JMenuItem(String.format("%s. %s %s",i+1, workDialog.getwGNo().getgName(),
						sf.format(workDialog.getwReserveTime())));
				menuItemList.addActionListener(this);
				parent.getMenuPopup().add(menuItemList);

			}

		}

//		System.out.println(lblDesigner.getText());
//		System.out.println(row + "행, " + column + "열 : " + jtable.getValueAt(row, column) + " 선택했음");
//		System.out.println(list.get(jtable.getValueAt(row, 0)));

//		if(work!=null) {
//			frame = new WorkDialogFrame();
//			frame.setOpen(work.getwNo());
//		}else {
//			frame = new WorkDialogFrame();
//			frame.setOpen(-1);
//		}
//		frame.setVisible(true);

	}

	public void setTable(List<WorkDialog> wList) {
		dWorkList.clear();
		lblDesigner.setText(designer.getdName());
		Iterator<WorkDialog> workDialog = wList.iterator();
		while (workDialog.hasNext()) {
			WorkDialog work = workDialog.next();

			// Map<시간,Map<순서(분),Guest>>

			int index = work.getwReserveTime().getHours() - 8;
			String text = jtable.getValueAt(index, 0).toString();
			if (dWorkList.get(index) != null) {
				dWorkList.get(index).add(work);
				
				jtable.setValueAt(text + "," + work.getwGNo().getgName(), index, 0);
			}
			else {
				ArrayList<WorkDialog> timeList = new ArrayList<WorkDialog>();// 2번쨰map
				timeList.add(work);
				dWorkList.put(index, timeList);// 1번쨰풋
				jtable.setValueAt(work.getwGNo().getgName(), index, 0);
			}
			
			if(index==6)
				System.out.println(jtable.getValueAt(index, 0).toString());
		}

	}

	public void setDisigner(Designer designer) {
		this.designer = designer;
	}

	public void clearTable() {
		lblDesigner.setText(" ");
		jtable.setModel(new DefaultTableModel(data, columns));
	}

//	private Object[][] getRows() {
//		if(wList==null) {
//			wList=new ArrayList<>();
//		}
//		Object[][] rows = new Object[14][];
//		for (int i = 0; i < 14; i++) {
//			rows[i] = wList.get(i).toArray(i);
//		}
//		return rows;
//	}

//	public void reloadData() {
//		jtable.setModel(new DefaultTableModel(getRows(), new String[] {"시간","작업명"}));
////		tableAlignmentAndWidth();
//	}

	// 테이블 셀 내용의 정렬
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = jtable.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 셀의 폭 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = jtable.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		int index=Integer.parseInt(str.substring(0, str.indexOf(".")));
		System.out.println(index);
		str = str.substring(str.length() - 5, str.length());
		int h = Integer.parseInt(str.substring(0, 2));
		int m = Integer.parseInt(str.substring(3));
		
		
		parent.setWorkDate(dWorkList.get(h - 8).get(index-1));

	}

	public void setPopupMenu(JPopupMenu popupMenuList) {

		jtable.setComponentPopupMenu(popupMenuList);
	}

	public void setParent(pHomeSectionForm pHomeSectionForm) {
		parent = pHomeSectionForm;
	}
}