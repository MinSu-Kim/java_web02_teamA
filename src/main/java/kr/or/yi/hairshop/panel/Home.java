package kr.or.yi.hairshop.panel;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class Home extends JPanel {
	public Home() {
		initComponents();
	}
	private void initComponents() {
		
	}

	public static void main(String[] args) {
		EmbeddedMediaListPlayerComponent component = new EmbeddedMediaListPlayerComponent();
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JLabel asd=new JLabel();
		p.add(asd);
		f.getContentPane().add(p);
		f.setContentPane(component);
		f.setBounds(new Rectangle(200, 200, 800, 600));
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				component.release();
				System.exit(0);
			}		
		});
		
		f.setVisible(true);
		
		component.mediaPlayer().media().play("https://www.youtube.com/watch?v=6q39g1Gf_8Q");
	}
	

}
