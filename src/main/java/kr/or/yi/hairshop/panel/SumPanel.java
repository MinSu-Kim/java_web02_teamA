package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;


@SuppressWarnings("serial")
public class SumPanel extends JPanel {
	private WorkDialogMapper wdao = new WorkDialogMapperImpl();
	private List<WorkDialog> wList;
	private int wDNo;
	private JTextField tfSum;
	JTextField tfCount;

	public SumPanel() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel dsPanel = new JPanel();
		dsPanel.setBorder(new TitledBorder(null, null, TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(dsPanel);
		dsPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSum = new JLabel("총합");
		dsPanel.add(lblSum);
		
		tfSum = new JTextField();
		dsPanel.add(tfSum);
		
		JLabel lblCount = new JLabel("총횟수");
		dsPanel.add(lblCount);
		
		tfCount = new JTextField();
		dsPanel.add(tfCount);
	}
	
	public void clearList(int wDNo) {
		wList = wdao.selectTotalPriceByDesigner(wDNo);
	}


	public void setSum(int sum) {
		tfSum.setText(sum+"");
	}

	public void setCount(int size) {
		tfCount.setText(size+"");
	}


	
}
