package kr.or.yi.hairshop.ui.chart;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.dto.WorkDialog;

public class DateYearPriceLineChart extends JFXPanel implements InitScene{
	private LineChart<String, Number> lineChart;
	private CategoryAxis xAxis;
	private List<Product> pList;
	
	public void setWList(List<Product> pList) {
		this.pList=pList;
	}
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		xAxis = new CategoryAxis();
		xAxis.setLabel("2019년");
		
				
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("총매출");

		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(500, 250);
		lineChart.setData(getChartData());
		
		lineChart.setTitle("Line Chart");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치

		root.getChildren().add(lineChart);

		return scene;
	}
	
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		Object[][] object = new Object[pList.size()][2];
		
		for(int i=0; i<object.length; i++) {
			object[i][0]=pList.get(i).getpName().substring(5, 7)+"월";
			object[i][1]=pList.get(i).getpPrice();
		}
		
		list.add(getChartData(object));
		
		
		return list;
	}
	
	public XYChart.Series<String, Number> getChartData(Object[][] obj) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();

		
		dataSeries.setName("이름");
		for(int i=0; i<pList.size(); i++) {
			
			dataSeries.getData().add(new XYChart.Data<>(obj[i][0]+"",Integer.parseInt(obj[i][1]+"")));
			
		}
			
		
		
		return dataSeries;
	}

}
