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

public class pGuestChart extends JPanel {
	private WorkDialogMapper wDao=new WorkDialogMapperImpl();
	private ProductMapper pDao=new ProductMapperImpl();
	GuestCountBarChart pBarPriceChart;
	GuestPriceBarChart pBarCountChart;
	DateYearPriceLineChart dateYearPriceChart;
	
	public pGuestChart() {
		initComponents();
	}
	private void initComponents() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		pBarPriceChart = new GuestCountBarChart();
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice());
		panel.add(pBarPriceChart);
		
		pBarCountChart = new GuestPriceBarChart();
		pBarCountChart.setWList(wDao.selectGuestBarChartCount());
		panel.add(pBarCountChart);
		
		
		dateYearPriceChart = new DateYearPriceLineChart();
		dateYearPriceChart.setWList(pDao.selectDateYearPriceChart());
		panel.add(dateYearPriceChart);
		
		
		
		
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
		Platform.runLater(() -> initFX(dateYearPriceChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
