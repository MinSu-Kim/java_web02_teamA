package kr.or.yi.hairshop.ui.chart;


import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;

@SuppressWarnings("serial")
public class GuestCountBarChart extends AbstractBarChart<WorkDialog>{

	
	public GuestCountBarChart() {
		
	}
	
//	한(국어) 컬럼에 몇명을 표시할지
	@Override
	public ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		
		Object[][] object = new Object[wList.size()][2];
		
		for(int i=0; i<object.length; i++) {
			object[i][0]=wList.get(i).getwGNo().getgName(); //가로 이름
			object[i][1]=wList.get(i).getwPriceTotal(); //값
		}
		
		list.add(getChartData(object));
		
		
		
//		list.add(getChartData(work))
		
//		가로로 셋팅이 됩니다.
//		WorkDialog work = new WorkDialog("S001", "현빈", 90, 60,70);
//		WorkDialog work2 = new WorkDialog("S002", "박신혜", 60, 55,88);
		
//		list.add(getChartData(work));
//		list.add(getChartData(work2));
		
		return list;
	}

	@Override
	protected String setLeftName() {
		return "미용 횟수";
	}

	@Override
	protected String setTitle() {
		return "고객 방문 통계";
	}

	@Override
	protected String setBottomName() {
		return "";
	}

}
