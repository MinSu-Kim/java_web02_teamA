package kr.or.yi.hairshop.panel;

import javax.swing.JPanel;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.daoImpl.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PanelDesignerSecheduleForm extends JPanel {
	private List<Designer> dList=new ArrayList<Designer>();
	private WorkDialogMapper workDialog=new WorkDialogMapperImpl();
	private List<WorkDialog> wList=new ArrayList<WorkDialog>();
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
		
		
		for(int i=0; i<3; i++) {
			panelList[i] = new PanelDesignerScheduleBlock();
			panelListForm.add(panelList[i]);
		}
		
		
		
	}

	public void setDList(List<Designer> dList) {
		this.dList=dList;
	}
	
	public void refresh() {
		for(int i=0; i<3; i++) {
			panelList[i].setDisigner(dList.get(i));
			wList=workDialog.selectDListByNo(dList.get(i).getdNo());
			panelList[i].setWorkDialog(wList);
			panelList[i].setTable(wList);
		}
	}

	
	
}
