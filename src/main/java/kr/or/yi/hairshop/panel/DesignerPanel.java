package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;


@SuppressWarnings("serial")
public class DesignerPanel extends JPanel {
	private JTable table;	
	private List<WorkDialog> dList;
	private DesignerMapper dao = new DesignerMapperImpl();
	private WorkDialogMapper wdao = new WorkDialogMapperImpl();
	
	public DesignerPanel() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel dsPanel = new JPanel();
		dsPanel.setBorder(new TitledBorder(null, "작업이력", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(dsPanel);
		dsPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		dsPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setSize(200, 200);	
	}
	
	public void clearList() {
		dList = wdao.selectByfivejoinMap();
	}

	public void reloadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidth(60, 50, 40, 50);
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[dList.size()][];
		for (int i = 0; i < dList.size(); i++) {
			rows[i] = dList.get(i).toArrayFiveJoinMap();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "작업일", "작업명", "손님명", "금액" };
	}

	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}	
}
