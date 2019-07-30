package kr.or.yi.hairshop.ui.chart;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class GuestBarChart extends JPanel {
	GuestChart pBarChart;
	public GuestBarChart() {
		pBarChart = new GuestChart();
		add(pBarChart);
		Platform.runLater(() -> initFX(pBarChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
}
