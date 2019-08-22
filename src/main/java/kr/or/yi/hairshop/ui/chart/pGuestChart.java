package kr.or.yi.hairshop.ui.chart;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Product;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Dimension;

public class pGuestChart extends JPanel implements ActionListener, PropertyChangeListener {
	private WorkDialogMapper wDao=new WorkDialogMapperImpl();
	private ProductMapper pDao=new ProductMapperImpl();
	GuestCountBarChart pBarPriceChart;
	GuestPriceBarChart pBarCountChart=new GuestPriceBarChart();
	DateYearPriceLineChart dateYearPriceChart;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnAdd;
	private JButton btnDelete;
	private int year;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JDateChooser dateStart;
	private JDateChooser dateEnd;
	private JButton btnAllDay;
	private Map<String, Date> map;
	private Date date;
	
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	public pGuestChart() {
		initComponents();
	}
	private void initComponents() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		dateStart = new JDateChooser();
		dateStart.setPreferredSize(new Dimension(100, 21));
		dateStart.addPropertyChangeListener(this);
		panel_7.add(dateStart);
		
		dateEnd = new JDateChooser();
		dateEnd.setPreferredSize(new Dimension(100, 21));
		dateEnd.addPropertyChangeListener(this);
		panel_7.add(dateEnd);
		
		btnAllDay = new JButton("전체보기");
		btnAllDay.addActionListener(this);
		panel_7.add(btnAllDay);
		
		panel_3 = new JPanel();
		panel_6.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
				
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		pBarPriceChart = new GuestCountBarChart();
		panel_4.add(pBarPriceChart);
		
		map = new HashMap<String, Date>();
		date = new Date();
		
		map.put("dateStart",new Date(date.getYear(),0,1));
		map.put("dateEnd",new Date(date.getYear(),11,31,23,59,59));
		
		dateStart.setDate(new Date(date.getYear(),0,1));
		dateEnd.setDate(new Date(date.getYear(),11,31,23,59,59));
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice(map));
		
		panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		
		panel_5.add(pBarCountChart);
		pBarCountChart.setWList(wDao.selectGuestBarChartCount(map));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		dateYearPriceChart = new DateYearPriceLineChart();
		panel_1.add(dateYearPriceChart);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy");
		Date date = new Date();
		year = Integer.parseInt(sf.format(date));
		dateYearPriceChart.setWList(pDao.selectDateYearPriceChart(year));
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(new BtnAddActionListener());
		panel_2.add(btnAdd);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panel_2.add(btnDelete);
		
		
		
		
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
		Platform.runLater(() -> initFX(dateYearPriceChart));
	}
	
	public void initFX(InitScene fxPanel) {
		Scene scene = fxPanel.createScene();
		JFXPanel panel = (JFXPanel) fxPanel;
		panel.setScene(scene);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAllDay) {
			actionPerformedBtnAllDay(e);
		}
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
	}
	
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			year--;
			dateYearPriceChart.setYear(year);
			List<Product> pList=pDao.selectDateYearPriceChart(year);
			System.out.println(pList.size());
			Object[][] object = new Object[][] {{"01월",0},
				{"02월",0},
				{"03월",0},
				{"04월",0},
				{"05월",0},
				{"06월",0},
				{"07월",0},
				{"08월",0},
				{"09월",0},
				{"10월",0},
				{"11월",0},
				{"12월",0}};
			for(int i=0; i<pList.size(); i++) {
				String month=pList.get(i).getpName().substring(5, 7);
				object[Integer.parseInt(month)-1][1]=pList.get(i).getpPrice();
			}
			Platform.runLater(() -> {
				dateYearPriceChart.addChartData(object);
			});
		}
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
		
		if(year==Integer.parseInt(sf.format(date).substring(0, 4))) {
			JOptionPane.showMessageDialog(null, "다음해는 검색이 불가합니다.");
		}else {
			Platform.runLater(() -> {
				dateYearPriceChart.delChartData(year++);
			});
		}
		
	}
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == dateEnd) {
			propertyChangeDateEnd(evt);
		}
		if (evt.getSource() == dateStart) {
			propertyChangeDateStart(evt);
		}
	}
	protected void propertyChangeDateStart(PropertyChangeEvent evt) {
		
		System.out.println(pBarCountChart);
		if(dateStart!=null && dateEnd!=null && wDao!=null && map!=null) {
			map.put("dateStart", dateStart.getDate());
			map.put("dateEnd", dateEnd.getDate());
			
			pBarPriceChart.setWList(wDao.selectGuestBarChartPrice(map));
			pBarCountChart.setWList(wDao.selectGuestBarChartCount(map));
			
			Platform.runLater(() -> initFX(pBarPriceChart));
			Platform.runLater(() -> initFX(pBarCountChart));
		}
	}
	protected void propertyChangeDateEnd(PropertyChangeEvent evt) {
		if(dateStart!=null && dateEnd!=null && wDao!=null && map!=null) {
			map.put("dateStart", dateStart.getDate());
			map.put("dateEnd", dateEnd.getDate());
			
			pBarPriceChart.setWList(wDao.selectGuestBarChartPrice(map));
			pBarCountChart.setWList(wDao.selectGuestBarChartCount(map));
			
			
			Platform.runLater(() -> initFX(pBarPriceChart));
			Platform.runLater(() -> initFX(pBarCountChart));
		}
	}
	
	public void reloadData() {
		map = new HashMap<String, Date>();
		date = new Date();
		
		pBarPriceChart = new GuestCountBarChart();
		
		map.put("dateStart",new Date(date.getYear(),0,1));
		map.put("dateEnd",new Date(date.getYear(),11,31,23,59,59));
		
		dateStart.setDate(new Date(date.getYear(),0,1));
		dateEnd.setDate(new Date(date.getYear(),11,31,23,59,59));
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice(map));
		dateYearPriceChart.setWList(pDao.selectDateYearPriceChart(year));
		pBarCountChart.setWList(wDao.selectGuestBarChartCount(map));
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
		Platform.runLater(() -> initFX(dateYearPriceChart));
	}
	
	protected void actionPerformedBtnAllDay(ActionEvent e) {
		
		map.put("dateStart", new Date(date.getYear()-100,0,1));
		map.put("dateEnd", new Date());
		
		System.out.println(map.get("dateStart"));
		System.out.println(map.get("dateEnd"));
		
		pBarPriceChart.setWList(wDao.selectGuestBarChartPrice(map));
		pBarCountChart.setWList(wDao.selectGuestBarChartCount(map));
		
		
		Platform.runLater(() -> initFX(pBarPriceChart));
		Platform.runLater(() -> initFX(pBarCountChart));
	}
}
