package kr.or.yi.hairshop.ui.chart;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;

public class pGuestChart extends JPanel {
	private WorkDialogMapper wDao=new WorkDialogMapperImpl();
	GuestPriceChart pBarPriceChart;
	GuestCountChart pBarCountChart;
	
	public pGuestChart() {
		initComponents();
	}
	private void initComponents() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		pBarPriceChart = new GuestPriceChart();
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice());
		panel.add(pBarPriceChart);
		
		pBarCountChart = new GuestCountChart();
		pBarCountChart.setWList(wDao.selectGuestBarChartCount());
		panel.add(pBarCountChart);
		
		
		
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
