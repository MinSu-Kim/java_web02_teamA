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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.ui.frame.WorkDialogFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class pHomeDesignerBlock extends JPanel implements MouseListener {
	JTable jtable;
	private JLabel lblDesigner;
	private Designer designer;
	private List<WorkDialog> wList;
	private DefaultTableModel model;
	private Map<Integer, WorkDialog> list=new HashMap<Integer, WorkDialog>();
	private final String[] columns = { "시간", "작업명"};
	private String[][] data = { 
			{ "08:00", ""}, 
			{ "09:00", ""}, 
			{ "10:00", ""}, 
			{ "11:00", ""},
			{ "12:00", ""},
			{ "13:00", ""},
			{ "14:00", ""},
			{ "15:00", ""},
			{ "16:00", ""},
			{ "17:00", ""},
			{ "18:00", ""},
			{ "19:00", ""},
			{ "20:00", ""},
			{ "21:00", ""},
			{ "22:00", ""},
			{ "23:00", ""},
			{ "24:00", ""},
	};
	public pHomeDesignerBlock() {
		
		setLayout(new BorderLayout());
		

		model = new DefaultTableModel(data, columns);

		jtable = new JTable(model);

		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		jtable.addMouseListener(this);
		
		JScrollPane spane = new JScrollPane(jtable);
		add(spane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		lblDesigner = new JLabel("디자이너이름");
		panel.add(lblDesigner);
	}

//	public static void main(String[] args) {
//		JFrame f = new JFrame("JTable Test");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		PanelDesignerScheduleBlock jt = new PanelDesignerScheduleBlock();
//		f.getContentPane().add(jt);
//		f.setSize(300, 200);
//		f.setVisible(true);
//	}

	public void mouseClicked(MouseEvent me) {
		int row = jtable.getSelectedRow();
		int column = jtable.getSelectedColumn();
		System.out.println(lblDesigner.getText());
		System.out.println(row + "행, " + column + "열 : " + jtable.getValueAt(row, column) + " 선택했음");
//		System.out.println(list.get(jtable.getValueAt(row, 0)));
		WorkDialog work = list.get(row);
		WorkDialogFrame frame = new WorkDialogFrame();
		frame.setWorkTf(work);
		frame.setVisible(true);
		
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		jtable.clearSelection();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void setTable(List<WorkDialog> wList) {
		
		lblDesigner.setText(designer.getdName());
		Iterator<WorkDialog> workDialog = wList.iterator();
		while (workDialog.hasNext()) {
		    WorkDialog work=workDialog.next();
//		      //row 갯수
//	        System.out.println(jtable.getRowCount());
//	        //column 갯수
//	        System.out.println(jtable.getColumnCount());
		    jtable.setValueAt(work,  work.getwReservTime().getHours()-8, 1);
		    list.put(work.getwReservTime().getHours()-8, work);
		    
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
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 3,4,5,6);
		tableCellAlignment(SwingConstants.RIGHT, 2);
		// 직책번호, 직책명의 폭을 (100, 200)으로 가능하면 설정
		tableSetWidth(100, 150 ,150,100,50,100,100);
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