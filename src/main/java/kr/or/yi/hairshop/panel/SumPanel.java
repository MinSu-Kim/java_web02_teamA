package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

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
		dsPanel.setSize(100, 100);
		dsPanel.setBorder(new TitledBorder(null, null, TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(dsPanel);
		dsPanel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel lblSum = new JLabel("총합");
		lblSum.setBounds(new Rectangle(0, 0, 30, 30));
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		dsPanel.add(lblSum);
		
		JLabel lblCount = new JLabel("총횟수");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		dsPanel.add(lblCount);
		
		tfSum = new JTextField();
		dsPanel.add(tfSum);
		
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
