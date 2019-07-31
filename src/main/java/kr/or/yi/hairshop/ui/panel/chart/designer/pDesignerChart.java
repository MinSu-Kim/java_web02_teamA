package kr.or.yi.hairshop.ui.panel.chart.designer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class pDesignerChart extends JPanel {
	private JPanel pMain;
	private JFXPanel panel;
	private pPieChart pLeft;

	public pDesignerChart() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("디자이너 작업");
		panel.add(lblNewLabel);

		pMain = new JPanel();
		add(pMain);
		pMain.setLayout(new GridLayout(0, 2, 0, 0));

		pPieChart pLeft = new pPieChart();
		pMain.add(pLeft);

		JPanel pRight = new JPanel();
		pMain.add(pRight);
		Platform.runLater(() -> initFX(pLeft));

	}

	public void initFX(pPieChart pChartLeft) {
		Scene scene = pChartLeft.createScene();
		panel = (JFXPanel) pChartLeft;
		panel.setScene(scene);
	}

}
