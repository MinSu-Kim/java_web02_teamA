package kr.or.yi.hairshop.ui.panel.chart.designer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;
import javax.swing.BoxLayout;

public class pDesignerChart extends JPanel implements ItemListener {
	private static pDesignerChart pDesignerChart;
	private JPanel pMain;
	private JFXPanel panel;
	private pPieChartAll pLeft;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbBtn0;
	private JRadioButton rbBtn1;
	private JRadioButton rbBtn2;
	private JRadioButton rbBtn3;
	private JRadioButton rbBtn4;
	private JRadioButton rbBtn5;
	private JRadioButton rbBtn6;
	private JRadioButton rbBtn7;
	private JRadioButton rbBtn8;
	private JRadioButton rbBtn9;
	private JRadioButton rbBtn10;
	private JRadioButton rbBtn11;
	private JPanel panel_1;
	private JPanel panel_2;
	
	private WorkDialogMapper dao = new WorkDialogMapperImpl();
	private JRadioButton rbBtn12;
	private ChartByProductPie ChartByProductPie;
	
	public pDesignerChart() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("디자이너 작업");
		panel.add(lblNewLabel);

		pMain = new JPanel();
		add(pMain);
		pMain.setLayout(new GridLayout(0, 2, 0, 0));

		pPieChartAll pLeftAll = new pPieChartAll();
		pMain.add(pLeftAll);
		pLeftAll.setLayout(new BorderLayout(0, 0));
		
		JPanel pRightMon = new JPanel();
		pMain.add(pRightMon);
		pRightMon.setLayout(new BorderLayout(0, 0));
		
		pPieChartMon pPieChartMon = new pPieChartMon();
		pRightMon.add(pPieChartMon);
		pPieChartMon.setParent(pDesignerChart.this);

		JPanel pRDB = new JPanel();
		pRightMon.add(pRDB, BorderLayout.SOUTH);
		pRDB.setLayout(new GridLayout(0, 7, 0, 0));
		
		rbBtn0 = new JRadioButton("1월");
		rbBtn0.addItemListener(this);
		pRDB.add(rbBtn0);
		buttonGroup.add(rbBtn0);
		
		rbBtn1 = new JRadioButton("2월");
		rbBtn1.addItemListener(this);
		pRDB.add(rbBtn1);
		buttonGroup.add(rbBtn1);
		
		rbBtn2 = new JRadioButton("3월");
		rbBtn2.addItemListener(this);
		pRDB.add(rbBtn2);
		buttonGroup.add(rbBtn2);
		
		rbBtn3 = new JRadioButton("4월");
		rbBtn3.addItemListener(this);
		pRDB.add(rbBtn3);
		buttonGroup.add(rbBtn3);
		
		rbBtn4 = new JRadioButton("5월");
		rbBtn4.addItemListener(this);
		pRDB.add(rbBtn4);
		buttonGroup.add(rbBtn4);
		
		rbBtn5 = new JRadioButton("6월");
		rbBtn5.addItemListener(this);
		pRDB.add(rbBtn5);
		buttonGroup.add(rbBtn5);
		
		rbBtn6 = new JRadioButton("7월");
		rbBtn6.addItemListener(this);
		pRDB.add(rbBtn6);
		buttonGroup.add(rbBtn6);
		
		rbBtn7 = new JRadioButton("8월");
		rbBtn7.addItemListener(this);
		pRDB.add(rbBtn7);
		buttonGroup.add(rbBtn7);
		
		rbBtn8 = new JRadioButton("9월");
		rbBtn8.addItemListener(this);
		pRDB.add(rbBtn8);
		buttonGroup.add(rbBtn8);
		
		rbBtn9 = new JRadioButton("10월");
		rbBtn9.addItemListener(this);
		pRDB.add(rbBtn9);
		buttonGroup.add(rbBtn9);
		
		rbBtn10 = new JRadioButton("11월");
		rbBtn10.addItemListener(this);
		pRDB.add(rbBtn10);
		buttonGroup.add(rbBtn10);
		
		rbBtn11 = new JRadioButton("12월");
		rbBtn11.addItemListener(this);
		pRDB.add(rbBtn11);
		buttonGroup.add(rbBtn11);
		
		rbBtn12 = new JRadioButton("전체 검색");
		rbBtn12.addItemListener(this);
		pRDB.add(rbBtn12);
		buttonGroup.add(rbBtn12);
		
		panel_2 = new JPanel();
		pMain.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		ChartByProductPie ch = new ChartByProductPie();
		panel_2.add(ch);
		
		
		
		Platform.runLater(() -> initFXAll(pLeftAll));
		Platform.runLater(() -> initFXMon(pPieChartMon));
		Platform.runLater(() -> initFX(ch));
	}

	public void initFXAll(pPieChartAll p) {
		Scene scene = p.createScene();
		panel = (JFXPanel) p;
		panel.setScene(scene);
	}
	
	public void initFXMon(pPieChartMon p) {
		Scene scene = p.createScene();
		panel = (JFXPanel) p;
		panel.setScene(scene);
	}
	
	public void initFX(ChartByProductPie pChart) {
		Scene scene = pChart.createScene();
		panel = (JFXPanel) pChart;
		panel.setScene(scene);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rbBtn12) {
			itemStateChangedRbBtn12(e);
		}
		if (e.getSource() == rbBtn11) {
			itemStateChangedRbBtn11(e);
		}
		if (e.getSource() == rbBtn10) {
			itemStateChangedRbBtn10(e);
		}
		if (e.getSource() == rbBtn9) {
			itemStateChangedRbBtn9(e);
		}
		if (e.getSource() == rbBtn8) {
			itemStateChangedRbBtn8(e);
		}
		if (e.getSource() == rbBtn7) {
			itemStateChangedRbBtn7(e);
		}
		if (e.getSource() == rbBtn6) {
			itemStateChangedRbBtn6(e);
		}
		if (e.getSource() == rbBtn5) {
			itemStateChangedRbBtn5(e);
		}
		if (e.getSource() == rbBtn4) {
			itemStateChangedRbBtn4(e);
		}
		if (e.getSource() == rbBtn3) {
			itemStateChangedRbBtn3(e);
		}
		if (e.getSource() == rbBtn2) {
			itemStateChangedRbBtn2(e);
		}
		if (e.getSource() == rbBtn1) {
			itemStateChangedRbBtn1(e);
		}
		if (e.getSource() == rbBtn0) {
			itemStateChangedRbBtn0(e);
		}
		
		
	}
	protected void itemStateChangedRbBtn0(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-01-01 00:00";
		String end = "2019-01-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn1(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-02-01 00:00";
		String end = "2019-02-28 23:59";
		
		map.put("start", start);
		map.put("end", end);
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}			
	}
	protected void itemStateChangedRbBtn2(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-03-01 00:00";
		String end = "2019-03-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn3(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-04-01 00:00";
		String end = "2019-04-30 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn4(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-05-01 00:00";
		String end = "2019-05-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}		
	}
	protected void itemStateChangedRbBtn5(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-06-01 00:00";
		String end = "2019-06-30 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}	
	}
	protected void itemStateChangedRbBtn6(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-07-01 00:00";
		String end = "2019-07-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn7(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-08-01 00:00";
		String end = "2019-08-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}		
	}
	protected void itemStateChangedRbBtn8(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-09-01 00:00";
		String end = "2019-09-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn9(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-10-01 00:00";
		String end = "2019-10-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn10(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-11-01 00:00";
		String end = "2019-11-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn11(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-12-01 00:00";
		String end = "2019-12-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		if(list.size() != 0) {
			Platform.runLater(() -> pPieChartMon.reloadAllData(list) );
		}
	}
	protected void itemStateChangedRbBtn12(ItemEvent e) {
		Map<String, String> map = new HashMap<String, String>();
		String start = "2019-01-01 00:00";
		String end = "2019-12-31 23:59";
		
		map.put("start", start);
		map.put("end", end);
		
		List<WorkDialog> list = dao.selectByDateForChartMon(map);
		Platform.runLater(() -> pPieChartMon.reloadAllData(list) );		
	}
}
