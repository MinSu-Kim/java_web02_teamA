package kr.or.yi.hairshop.ui.panel.home;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class pHomeSectionBlock extends JPanel implements MouseListener {
	JTable jtable;
	private JLabel lblDesigner;
	private Designer designer;
	private List<WorkDialog> wList;
	private DefaultTableModel model;
	private Map<Integer, WorkDialog> list=new HashMap<Integer, WorkDialog>();
	private Map<Integer,Map<Integer,Guest>> dWorkList=new HashMap<Integer, Map<Integer,Guest>>();
	private final String[] columns = { "시간", "손님"};
	
	private WorkDialogMapper dao = new WorkDialogMapperImpl();
	private WorkDialogFrame frame;
	private String[][] data = { 
			{ "8", "",}, 
			{ "9", ""}, 
			{ "10", ""}, 
			{ "11", ""},
			{ "12", ""},
			{ "13", ""},
			{ "14", ""},
			{ "15", ""},
			{ "16", ""},
			{ "17", ""},
			{ "18", ""},
			{ "19", ""},
			{ "20", ""},
			{ "21", ""},
			{ "22", ""},
			{ "23", ""},
	};
	private JPanel panelRight;
	private JPanel panelCenter;
	
	
	public pHomeSectionBlock() {
		setBorder(null);
		
		setLayout(new BorderLayout());
		
		
		model = new DefaultTableModel(data, columns);

		jtable = new JTable(model);
		
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		jtable.addMouseListener(this);
		tableSetWidth(10, 100);
		JScrollPane spane = new JScrollPane(jtable);
		
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
		Iterator<Integer> map1 = dWorkList.keySet().iterator();
		System.out.println(map1);
        while( map1.hasNext() ){
        	int key1 = map1.next();
        	Iterator<Integer> map2=dWorkList.get(key1).keySet().iterator();
        	while(map2.hasNext()) {
        		int key2=map2.next();
        		System.out.println(String.format("key=%s,value=%s", key2, dWorkList.get(key1).get(key2)));
        	}
        	
        }
		
		int row = jtable.getSelectedRow();
		int column = jtable.getSelectedColumn();
//		System.out.println(lblDesigner.getText());
//		System.out.println(row + "행, " + column + "열 : " + jtable.getValueAt(row, column) + " 선택했음");
//		System.out.println(list.get(jtable.getValueAt(row, 0)));
		WorkDialog work = list.get(row);
		if(work!=null) {
//			frame = new WorkDialogFrame();
			frame.setOpen(work.getwNo());
		}else {
//			frame = new WorkDialogFrame();
			frame.setOpen(-1);
		}
		frame.setVisible(true);
		
	}
	public void setTable(List<WorkDialog> wList) {
		System.out.println(wList);
		lblDesigner.setText(designer.getdName());
		Iterator<WorkDialog> workDialog = wList.iterator();
		while (workDialog.hasNext()) {
		    WorkDialog work=workDialog.next();
//		      //row 갯수
//	        System.out.println(jtable.getRowCount());
//	        //column 갯수
//	        System.out.println(jtable.getColumnCount());
		    
		    //Map<시간,Map<순서,Guest>>
		    
		    Map<Integer,Guest> timeList=new HashMap<Integer, Guest>();
		    Guest guest = new Guest(work.getwGNo().getgNo(), work.getwGNo().getgName());
		    timeList.put(work.getwReservTime().getMinutes(), guest);
		    
		    dWorkList.put(work.getwReservTime().getHours()-8,timeList);
		    list.put(work.getwReservTime().getHours()-8, work);
		    
		    
//		    jtable.setValueAt(work,  work.getwReservTime().getHours()-8, 1);
		    String text=jtable.getValueAt(work.getwReservTime().getHours()-8, 1).toString();
		    if(text.equals("")) {
		    	 jtable.setValueAt(work.getwGNo().getgName(), work.getwReservTime().getHours()-8, 1);
		    }else {
		    	 jtable.setValueAt(text+","+work.getwGNo().getgName(), work.getwReservTime().getHours()-8, 1);
		    }
		    	
		}
		

	}
//	public void refresh() {
//		jtable.setModel(new DefaultTableModel(getRows(), new String[] {"시간","작업명"}));
//		jtable.setValueAt("가나다라", 1 , 1);
//	}
	
	public void setDisigner(Designer designer) {
		this.designer=designer;
	}
	
	public void setWorkDialog(List<WorkDialog> wList) {
		this.wList=wList;
	}
	
	public void clearTable() {
		lblDesigner.setText(" ");
		jtable.setModel(new DefaultTableModel(data,columns));
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
	
	protected void tableAlignmentAndWidth() {
		// 사원번호(0),사원명(1),급여(2),부서(3),성별(4),입사일(5),직책(6) 가운데 정렬
		tableCellAlignment(SwingConstants.LEFT, 2);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 150);
	}
	
	
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
}