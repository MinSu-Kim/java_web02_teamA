package kr.or.yi.hairshop.ui.panel.home;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class pHomeSection extends JPanel {

	/**
	 * Create the panel.
	 */
	public pHomeSection() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/homeimage.PNG"));
		add(lblNewLabel);
	}

}
