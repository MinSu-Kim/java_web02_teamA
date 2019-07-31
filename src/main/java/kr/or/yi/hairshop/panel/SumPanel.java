package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SumPanel extends JPanel {
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
		dsPanel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel lblCount = new JLabel("작업횟수");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		dsPanel.add(lblCount);
		
		JLabel lblSum = new JLabel("총 매출");
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		dsPanel.add(lblSum);
		
		tfCount = new JTextField();
		tfCount.setColumns(17);
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCount.setEditable(false);
		dsPanel.add(tfCount);
		
		tfSum = new JTextField();
		tfSum.setColumns(17);
		tfSum.setHorizontalAlignment(SwingConstants.CENTER);
		tfSum.setEditable(false);
		dsPanel.add(tfSum);
	
	
	}

	public void setSum(int sum) {
		tfSum.setText(sum+"");
	}

	public void setCount(int size) {
		tfCount.setText(size+"");
	}


	
}
