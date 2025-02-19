package kr.or.yi.hairshop.ui.panel.workMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JCalendar;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.EventMapper;
import kr.or.yi.hairshop.dao.EventMapperImpl;
import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.WorkDialog;

@SuppressWarnings("serial")
public class pHomeSectionForm extends JPanel implements ActionListener, PropertyChangeListener {
	private List<Designer> dList=new ArrayList<Designer>();
	private WorkDialogMapper wdao=new WorkDialogMapperImpl();
	private List<WorkDialog> wList=new ArrayList<WorkDialog>();
	private pHomeSectionBlock[] panelList= new pHomeSectionBlock[5];
	private JButton btnLeft;
	private JButton btnRight;
	public int start=0;
	
	private JPopupMenu popupMenuTime=new JPopupMenu();
	
	private pHomeFooterDesigner panelFooterTf;
	private final String[] columns = {"시간"};
	private String[][] data = { 
			{ "08:00"}, 
			{ "09:00"}, 
			{ "10:00"}, 
			{ "11:00"},
			{ "12:00"},
			{ "13:00"},
			{ "14:00"},
			{ "15:00"},
			{ "16:00"},
			{ "17:00"},
			{ "18:00"},
			{ "19:00"},
			{ "20:00"},
			{ "21:00"},
			{ "22:00"},
			{ "23:00"}
	};
	private JTable timeTable;
	private ProductMapper pDao;
	private DesignerMapper dDao;
	private EventMapper eDao;
	private JCalendar calendar;
	private DesignerMapper d_Dao= new DesignerMapperImpl();
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");;
	
	
	public pHomeSectionForm() {
		init();
	}
	public void init(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		calendar = new JCalendar();
		calendar.setWeekOfYearVisible(false);
		
		
		dList = d_Dao.selectDesignerByAll();
		calendar.getDayChooser().addPropertyChangeListener(this);
		
		panel.add(calendar, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images\\home.jpg"));
		panel_2.add(lblNewLabel_1);
		
		
		JPanel pSection = new JPanel();
		add(pSection, BorderLayout.CENTER);
		pSection.setLayout(new BorderLayout(0, 0));
		
		JPanel pLeft = new JPanel();
		pSection.add(pLeft, BorderLayout.WEST);
		pLeft.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		pLeft.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_9.add(panel_14);
		
		btnLeft = new JButton("<");
		panel_9.add(btnLeft);
		btnLeft.addActionListener(this);
		btnLeft.setEnabled(false);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		JPanel ptimeTable = new JPanel();
		pLeft.add(ptimeTable);
		ptimeTable.setLayout(new GridLayout(0, 1, 0, 0));

		DefaultTableModel model= new DefaultTableModel(data, columns);
		
		JPanel panel_13 = new JPanel();
		ptimeTable.add(panel_13);
		panel_13.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 52, 310);
		panel_13.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		
		
		timeTable = new JTable(model);
		timeTable.setPreferredScrollableViewportSize(new Dimension(50, 400));
		
		
		
		JScrollPane scrollPane = new JScrollPane(timeTable);
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel(" ");
		panel_7.add(lblNewLabel);
		TableColumnModel columnModel = timeTable.getColumnModel();
		
		JPanel panel_6 = new JPanel();
		ptimeTable.add(panel_6);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		columnModel.getColumn(0).setCellRenderer(dtcr);
		
		
		JPanel pRight = new JPanel();
		pSection.add(pRight, BorderLayout.EAST);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_11 = new JPanel();
		pRight.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		btnRight = new JButton(">");
		panel_11.add(btnRight);
		btnRight.addActionListener(this);
		
		JPanel panel_12 = new JPanel();
		pRight.add(panel_12);
		
		JPanel panel_3 = new JPanel();
		pSection.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panelListForm = new JPanel();
		panelListForm.setBounds(0, 0, 900, 310);
		panel_1.add(panelListForm);
		panelListForm.setLayout(new BoxLayout(panelListForm, BoxLayout.X_AXIS));
		
		JPanel panelFooter = new JPanel();
		panel_3.add(panelFooter);
		panelFooter.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_4 = new JPanel();
		panelFooter.add(panel_4, BorderLayout.NORTH);
		
		panelFooterTf = new pHomeFooterDesigner();
		panelFooterTf.setParent(this);
		eDao = new EventMapperImpl();
		dDao = new DesignerMapperImpl();
		pDao = new ProductMapperImpl();
		panelFooterTf.setBaseTf(eDao.selectEventByAll(),dDao.selectDesignerByAll(),pDao.selectProductByAll());
		panelFooter.add(panelFooterTf, BorderLayout.CENTER);
		
		
		for(int i=0; i<5; i++) {
			panelList[i] = new pHomeSectionBlock();
			panelListForm.add(panelList[i]);
			panelList[i].setPopupMenu(popupMenuTime);
		}
		
		
		
		
	}

	public void setDList(List<Designer> dList) {
		this.dList=dList;
	}
	
	public void reloadData() {
		dList = d_Dao.selectDesignerByAll();
		
		panelFooterTf.setBaseTf(eDao.selectEventByAll(),dDao.selectDesignerByAll(),pDao.selectProductByAll());
	}
	
	public void refresh(int start) {
		
		for(int i=0; i<5; i++) {
			if(dList.size()>i+start) {
				panelList[i].setParent(this);
				panelList[i].setDisigner(dList.get(i+start));
				Map<String, String> map = new HashMap<String, String>();
				map.put("wDNo",dList.get(i+start).getdNo()+"");
				map.put("date",sf.format(calendar.getDate()));
				wList=wdao.selectWDGECPjoinByWDNoDate(map);
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
		start-=5;
		if(start==0) {
			btnLeft.setEnabled(false);
		}
		btnRight.setEnabled(true);
		for(int i=0; i<5; i++) {
			panelList[i].clearTable();
		}
		refresh(start);
		revalidate();
		repaint();
	}
	protected void actionPerformedBtnRight(ActionEvent e) {
		start+=5;
		btnLeft.setEnabled(true);
		if(dList.size()<start+5) {
			btnRight.setEnabled(false);
		}
		for(int i=0; i<5; i++) {
			panelList[i].clearTable();
		}
		refresh(start);
		
		revalidate();
		repaint();
		
	}
	public JPopupMenu getMenuPopup() {
		return popupMenuTime;
	}
	public void setWorkDate(WorkDialog workDialog) {
		panelFooterTf.setTfWork(workDialog);
	}
	
	
	
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == calendar.getDayChooser()) {
			propertyChangeCalendarDayChooser(evt);
		}
	}
	protected void propertyChangeCalendarDayChooser(PropertyChangeEvent evt) {
		refresh(start);
	}
	public void setReservTime(int row) {
		String day=sf.format(calendar.getDate())+" "+(row+8)+":00:00";
		panelFooterTf.setReservTime(day);
	}
}