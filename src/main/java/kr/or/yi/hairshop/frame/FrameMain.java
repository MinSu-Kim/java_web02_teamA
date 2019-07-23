package kr.or.yi.hairshop.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.List;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.daoImpl.DesignerMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.PanelDesignerScheduleBlock;
import javax.swing.JLabel;
import kr.or.yi.hairshop.panel.PanelDesignerSecheduleForm;

public class FrameMain extends JFrame {

	private JPanel contentPane;
	private List<Designer> dList;
	private PanelDesignerSecheduleForm panelSection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	public FrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DesignerMapper d_Dao=new DesignerMapperImpl();
		dList = d_Dao.selectDesignerByAll();
		
		panelSection = new PanelDesignerSecheduleForm();
		panelSection.setDList(dList);
		panelSection.refresh();
		panelSection.setBounds(0, 74, 983, 487);
		contentPane.add(panelSection);
		
		
		
		
	}
}
