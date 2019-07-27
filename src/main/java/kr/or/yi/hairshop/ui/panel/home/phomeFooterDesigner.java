package kr.or.yi.hairshop.ui.panel.home;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import kr.or.yi.hairshop.dto.WorkDialog;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

public class phomeFooterDesigner extends JPanel {

	private JTextField tfgName;
	private JTextField tfdName;
	private JTextField tfwReservTime;
	private JTextField tfeName;
	private JTextField tfpPrice;
	private JTextField tfdMemo;
	private JButton btnOk;
	private JSpinner jSpinwWorkTime;
	private final String[] columns = { "작업일", "작업명","금액"};
	
	
	public phomeFooterDesigner() {
		
		initComponents();
	}
	private void initComponents() {
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelData = new JPanel();
		panel.add(panelData, BorderLayout.CENTER);
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JLabel lblgDname = new JLabel("손님");
		panelData.add(lblgDname);
		lblgDname.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfgName = new JTextField();
		panelData.add(tfgName);
		tfgName.setColumns(10);
		
		JLabel lbldName = new JLabel("디자이너");
		panelData.add(lbldName);
		lbldName.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfdName = new JTextField();
		panelData.add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lblwWorkTime = new JLabel("작업완료일");
		panelData.add(lblwWorkTime);
		lblwWorkTime.setHorizontalAlignment(SwingConstants.CENTER);
		
//		tfwWorkTime = new JTextField();
//		tfwWorkTime.setColumns(10);
//		panel.add(tfwWorkTime);
		
		jSpinwWorkTime = new JSpinner();
		panelData.add(jSpinwWorkTime);
		jSpinwWorkTime.setModel(new SpinnerDateModel(new Date(1564055994890L), null, null, Calendar.HOUR_OF_DAY));
		
		JLabel lblwReservTime = new JLabel("작업일예약");
		panelData.add(lblwReservTime);
		lblwReservTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfwReservTime = new JTextField();
		panelData.add(tfwReservTime);
		tfwReservTime.setColumns(10);
		
		JLabel lbleName = new JLabel("이벤트명");
		panelData.add(lbleName);
		lbleName.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfeName = new JTextField();
		panelData.add(tfeName);
		tfeName.setColumns(10);
		
		JLabel lblpPrice = new JLabel("가격");
		panelData.add(lblpPrice);
		lblpPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfpPrice = new JTextField();
		panelData.add(tfpPrice);
		tfpPrice.setColumns(10);
		
		JLabel lblpName = new JLabel("작업명");
		panelData.add(lblpName);
		lblpName.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfdMemo = new JTextField();
		panelData.add(tfdMemo);
		tfdMemo.setColumns(10);
		
		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panelBtn.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnOk = new JButton("확인");
		panel_5.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		panel_5.add(btnCancel);
		
		JPanel panelTable = new JPanel();
		add(panelTable);
	}
	
	public void setTable() {
		
	}
	public void setWorkDate(WorkDialog workDialog) {
		tfdName.setText(workDialog.getwDNo().getdName());
		tfeName.setText(workDialog.getwEName().geteName());
		tfgName.setText(workDialog.getwGNo().getgName());
		tfpPrice.setText(workDialog.getwPriceTotal()+"");
		SimpleDateFormat sf = new SimpleDateFormat();
		tfwReservTime.setText(sf.format(workDialog.getwReservTime()));
		
	}
	
	
}
