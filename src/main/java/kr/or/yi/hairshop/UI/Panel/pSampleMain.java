package kr.or.yi.hairshop.UI.Panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class pSampleMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public pSampleMain() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\workspace\\java_web02_teamA\\images\\sam.JPG"));
		add(lblNewLabel, BorderLayout.NORTH);

	}

}
