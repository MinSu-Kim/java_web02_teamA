package kr.or.yi.hairshop.ui.chart;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Product;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class pGuestChart extends JPanel implements ActionListener {
	private WorkDialogMapper wDao=new WorkDialogMapperImpl();
	private ProductMapper pDao=new ProductMapperImpl();
	GuestCountBarChart pBarPriceChart;
	GuestPriceBarChart pBarCountChart;
	DateYearPriceLineChart dateYearPriceChart;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAdd;
	private JButton btnDelete;
	private int year;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	
	public pGuestChart() {
		initComponents();
	}
	private void initComponents() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		pBarPriceChart = new GuestCountBarChart();
		panel_4.add(pBarPriceChart);
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice());
		
		panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		pBarCountChart = new GuestPriceBarChart();
		panel_5.add(pBarCountChart);
		pBarCountChart.setWList(wDao.selectGuestBarChartCount());
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		dateYearPriceChart = new DateYearPriceLineChart();
		panel_1.add(dateYearPriceChart);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy");
		Date date = new Date();
		year = Integer.parseInt(sf.format(date));
		dateYearPriceChart.setWList(pDao.selectDateYearPriceChart(year));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(new BtnAddActionListener());
		panel_2.add(btnAdd);
		
		btnDelete = new JButton("삭제");
		panel_2.add(btnDelete);
		
		
		
		
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
		Platform.runLater(() -> initFX(dateYearPriceChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
	}
	
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			year--;
			dateYearPriceChart.setYear(year);
			List<Product> pList=pDao.selectDateYearPriceChart(year);
			Object[][] object = new Object[][] {{"01월",0},
				{"02월",0},
				{"03월",0},
				{"04월",0},
				{"05월",0},
				{"06월",0},
				{"07월",0},
				{"08월",0},
				{"09월",0},
				{"10월",0},
				{"11월",0},
				{"12월",0}};
			for(int i=0; i<pList.size(); i++) {
				String month=pList.get(i).getpName().substring(5, 7);
				if(i+1==Integer.parseInt(month)) {
					object[i][0]=month+"월";
					object[i][1]=pList.get(i).getpPrice();
				}else {
					object[i][0]=String.format("%02d", i+1)+"월";
					object[i][1]=0;
				}
			}
			Platform.runLater(() -> {
				dateYearPriceChart.addChartData(object);
			});
		}
	}
}
