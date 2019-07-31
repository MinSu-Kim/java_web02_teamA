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
import kr.or.yi.hairshop.dto.WorkDialog;

public abstract class AbstractBarChart<T> extends JFXPanel implements InitScene{
	private BarChart<String, Number> barChart;
	protected List<T> wList;
	
	public void setWList(List<T> wList) {
		this.wList=wList;
	}
	
	
	
	public XYChart.Series<String, Number> getChartData(Object[][] obj) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		int top=0;
		if(obj.length>9)
			top=10;
		else
			top=obj.length;
		
		dataSeries.setName("고객이름");
		for(int i=0; i<top; i++) {
			
			dataSeries.getData().add(new XYChart.Data<>(obj[i][0]+"",Integer.parseInt(obj[i][1]+"")));
			
		}
			
		return dataSeries;
	}
//	한(국어) 컬럼에 몇명을 표시할지
	protected abstract ObservableList<XYChart.Series<String, Number>> getChartData();
	
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel(setBottomName());

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(setLeftName());

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle(setTitle());
		
		barChart.setPrefSize(600, 400);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);

		return scene;
	}



	protected abstract String setBottomName();
	
	protected abstract String setTitle();

	protected abstract String setLeftName();
}
