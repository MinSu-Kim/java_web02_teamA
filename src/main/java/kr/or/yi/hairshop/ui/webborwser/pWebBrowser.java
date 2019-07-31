package kr.or.yi.hairshop.ui.webborwser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class pWebBrowser extends JPanel{
	private JPanel mainPanel;
	private JPanel panelTop;
	private JEditorPane editor;
	private JScrollPane scroll;
	private JTextField field;
	private JButton button;
	private URL url;

	public pWebBrowser() {
		initComponents();

		// set the title of the frame
		// mainPanel.setTitle(title);

		// set the default cloe op of the jframe
		// mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set size of frame
		mainPanel.setSize(800, 600);
		mainPanel.setLayout(new BorderLayout(0, 0));

		// add jpanel to north of jframe
		mainPanel.add(panelTop, BorderLayout.NORTH);

		// add textfield and navigation button to jpanel.
		panelTop.add(field);
		panelTop.add(button);

		// add scroll pane to jframe center
		mainPanel.add(scroll);

		// set the frame visible
		mainPanel.setVisible(true);
	}// end Browser() constructor

	private void initComponents() {
		// create the JFrame
		mainPanel = new JPanel();

		// create the JPanel used to hold the text field and button.
		panelTop = new JPanel();

		// set the url
		try {
			url = new URL("http://www.chahongardor.com/?page_id=294");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(null, mue);
		}

		// create the JEditorPane
		try {
			editor = new JEditorPane(url);

			// set the editor pane to false.
			editor.setEditable(false);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, ioe);
		}

		// create the scroll pane and add the JEditorPane to it.
		scroll = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// create the JTextField
		field = new JTextField();

		// set the JTextField text to the url.
		// we're not doing this on the event dispatch thread, so we need to use
		// SwingUtilities.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				field.setText(url.toString());
			}
		});

		// create the button for chanign pages.
		button = new JButton("Go");

		// add action listener to the button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					editor.setPage(field.getText());
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(null, ioe);
				}
			}
		});
	}// end initComponents()

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new Browser2();
//			}
//		});
//	}// end main method.
}// end Browser class
