package kr.or.yi.hairshop.ui.chart;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

public class ChartByProduct extends JFrame {

	private JPanel contentPane;
	private JFXPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChartByProduct frame = new ChartByProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChartByProduct() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		ChartByProductPie ch = new ChartByProductPie();
		panel.add(ch);
		
		Platform.runLater(() -> initFX(ch));
		
	}

	public void initFX(ChartByProductPie pChart) {
		Scene scene = pChart.createScene();
		panel = (JFXPanel) pChart;
		panel.setScene(scene);
	}
	
	
}
















