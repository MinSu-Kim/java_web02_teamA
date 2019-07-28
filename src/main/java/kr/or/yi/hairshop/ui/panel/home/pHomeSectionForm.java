package kr.or.yi.hairshop.ui.panel.home;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.WorkDialog;
import kr.or.yi.hairshop.panel.pCalendar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class pHomeSectionForm extends JPanel implements ActionListener {
	private List<Designer> dList=new ArrayList<Designer>();
	private WorkDialogMapper wdao=new WorkDialogMapperImpl();
	private List<WorkDialog> wList=new ArrayList<WorkDialog>();
	private pHomeSectionBlock[] panelList= new pHomeSectionBlock[5];
	private JButton btnLeft;
	private JButton btnRight;
	int start=0;
	
	private JPopupMenu popupMenuList=new JPopupMenu();
	private phomeFooterDesigner panelDesignerel;
	
	
	
	public pHomeSectionForm() {
		init();
	}
	public void init(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		pCalendar panel_1 = new pCalendar();
		panel.add(panel_1);
		
		pHomeMgnBtn panel_2 = new pHomeMgnBtn();
		panel.add(panel_2);
		
		JPanel pSection = new JPanel();
		add(pSection, BorderLayout.CENTER);
		pSection.setLayout(new BorderLayout(0, 0));
		
		JPanel pLeft = new JPanel();
		pSection.add(pLeft, BorderLayout.WEST);
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.X_AXIS));
		
		btnLeft = new JButton("<");
		btnLeft.addActionListener(this);
		btnLeft.setEnabled(false);
		pLeft.add(btnLeft);
		
		JPanel pRight = new JPanel();
		pSection.add(pRight, BorderLayout.EAST);
		pRight.setLayout(new BoxLayout(pRight, BoxLayout.X_AXIS));
		
		btnRight = new JButton(">");
		btnRight.addActionListener(this);
		pRight.add(btnRight);
		
		JPanel panel_3 = new JPanel();
		pSection.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		JPanel panelListForm = new JPanel();
		panel_3.add(panelListForm);
		panelListForm.setLayout(new BoxLayout(panelListForm, BoxLayout.X_AXIS));
		
		JPanel panelFooter = new JPanel();
		panel_3.add(panelFooter);
		panelFooter.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_4 = new JPanel();
		panelFooter.add(panel_4, BorderLayout.NORTH);
		
		panelDesignerel = new phomeFooterDesigner();
		panelFooter.add(panelDesignerel, BorderLayout.CENTER);
		
		
		for(int i=0; i<3; i++) {
			panelList[i] = new pHomeSectionBlock();
			panelListForm.add(panelList[i]);
			panelList[i].setPopupMenu(popupMenuList);
		}
		
		
		
		
	}

	public void setDList(List<Designer> dList) {
		this.dList=dList;
	}
	
	
	
	public void refresh(int start) {
		for(int i=0; i<3; i++) {
			if(dList.size()>i+start) {
				panelList[i].setParent(this);
				panelList[i].setDisigner(dList.get(i+start));
				wList=wdao.selectWDGECPjoinByWDNo(dList.get(i+start).getdNo());
				panelList[i].clearTable();
				panelList[i].setTable(wList);
				
				
			}else {
				panelList[i].clearTable();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRight) {
			actionPerformedBtnRight(e);
		}
		if (e.getSource() == btnLeft) {
			actionPerformedBtnLeft(e);
		}
	}
	protected void actionPerformedBtnLeft(ActionEvent e) {
		start-=3;
		if(start==0) {
			btnLeft.setEnabled(false);
		}
		btnRight.setEnabled(true);
		for(int i=0; i<3; i++) {
			panelList[i].clearTable();
		}
		refresh(start);
		revalidate();
		repaint();
	}
	protected void actionPerformedBtnRight(ActionEvent e) {
		start+=3;
		btnLeft.setEnabled(true);
		if(dList.size()<start+3) {
			btnRight.setEnabled(false);
		}
		for(int i=0; i<3; i++) {
			panelList[i].clearTable();
		}
		refresh(start);
		
		revalidate();
		repaint();
		
	}
	public JPopupMenu getMenuPopup() {
		return popupMenuList;
	}
	public void test1() {
	}
	public void setWorkDate(WorkDialog workDialog) {
		panelDesignerel.setWorkDate(workDialog);
	}
}