package kr.or.yi.hairshop.panel;

import javax.swing.JPanel;

import kr.or.yi.hairshop.dto.Designer;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class PanelDesignerSecheduleForm extends JPanel {
	private List<Designer> d_List=new ArrayList<Designer>();
	private PanelDesignerScheduleBlock[] panelList= new PanelDesignerScheduleBlock[5];
	public PanelDesignerSecheduleForm() {
		init();
	}
	public void init(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		

		
		JPanel panelListForm = new JPanel();
		add(panelListForm, BorderLayout.CENTER);
		panelListForm.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		for(int i=0; i<5; i++) {
			panelList[i] = new PanelDesignerScheduleBlock();
			panelListForm.add(panelList[i]);
		}
		
		
		
	}

	public void setD_List(List<Designer> d_List) {
		this.d_List=d_List;
	}
	public void refresh() {
		for(int i=0; i<5; i++) {
			panelList[i].setDisigner(d_List.get(i));
			panelList[i].refresh();
		}
	}
	
	
}
