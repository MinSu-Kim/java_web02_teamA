package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import kr.or.yi.hairshop.dto.WorkDialog;
import java.awt.GridLayout;


@SuppressWarnings("serial")
public class DesignerPanel extends JPanel {
	private JTable table;	
	private List<WorkDialog> dList;
	
	public DesignerPanel() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel dsPanel = new JPanel();
		dsPanel.setBorder(new TitledBorder(null, "작업이력", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(dsPanel);
		dsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		dsPanel.setSize(200, 200);
		JScrollPane scrollPane = new JScrollPane();
		dsPanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setSize(200, 200);	
		
	}
	
	public void clearList(List<WorkDialog> work) {
		dList = work;
	}

	public void reloadData() {
		MyTableModel model = new MyTableModel(getRows(), getColumnNames());
		table.setModel(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidth(50, 50, 50, 50);
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

	public void setWorkdialogList(List<WorkDialog> workDialog) {
		System.out.println("여기오나?");
		dList=workDialog;
	}	
	
	public int getSum() {
		int sum=0;
		
		for(int i=0; i<dList.size(); i++) {
			System.out.println(dList.get(i).getwPriceTotal());
			sum+=dList.get(i).getwPriceTotal();
		}
		System.out.println(sum);
		return sum;
	}

}
