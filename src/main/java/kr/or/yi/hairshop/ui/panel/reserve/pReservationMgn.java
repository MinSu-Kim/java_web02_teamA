package kr.or.yi.hairshop.ui.panel.reserve;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JCalendar;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.pCalendar;

@SuppressWarnings("serial")
public class pReservationMgn extends JPanel {
	
	private List<WorkDialog> workList;
	private WorkDialogMapper dao = new WorkDialogMapperImpl();
	private JTable table;
	
	public pReservationMgn() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		panel.add(pNorth, BorderLayout.NORTH);
		
		JCalendar calStart = new JCalendar();
		pNorth.add(calStart);
		
		JCalendar calEnd = new JCalendar();
		pNorth.add(calEnd);
		
		JButton btnSearch = new JButton("검색");
		pNorth.add(btnSearch);
		
		JPanel pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "예약정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pList);
		
		JPanel pR = new JPanel();
		add(pR, BorderLayout.EAST);
		pList.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		pR.setLayout(new BorderLayout(0, 0));
		
		pCalendar pCalendar = new pCalendar();
		pR.add(pCalendar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		pR.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\home.jpg"));
		panel_1.add(lblNewLabel);
	}
	
	public void clearList() {
		workList = dao.selectReservDetail();
	}

	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(20, 20, 50, 50, 80, 50, 50, 50, 50, 50);

	}

	private Object[][] getRows() {
		Object[][] rows = new Object[workList.size()][];
		for (int i = 0; i < workList.size(); i++) {
			
			/* oooooooooooooooooooooooooooo 포기 oooooooooooooooooooooooooooo */
			//rows[i] = workList.get(i).toArray();
			//rows[i] = workList.get(i).toArrayReservDetail();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "번호", "예약일시", "디자이너", "직책", "손님명", "손님등급", "작업명", "이벤트", "가격", "완료일시"};
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
















