package kr.or.yi.hairshop.ui.chart;

import java.util.List;

import javax.swing.JOptionPane;

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
	private String year;
	
	public void setWList(List<Product> pList) {
		this.pList=pList;
		year = pList.get(0).getpName().substring(0, 4);
	}
	public void setYear(int year) {
		this.year=year+"";
	}
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		xAxis = new CategoryAxis();
		xAxis.setLabel("년도");
		
				
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("총매출");

		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(1200, 300);
		lineChart.setData(getChartData());
		
		lineChart.setTitle("연 매출");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치

		root.getChildren().add(lineChart);

		return scene;
	}
	
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
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
			System.out.println("1111111111");
			System.out.println(month);
			object[Integer.parseInt(month)][1]=pList.get(i).getpPrice();
		}
		
		list.add(getChartData(object));
		
		
		return list;
	}
	public void addChartData(Object[][] obj) {
		lineChart.getData().add(getChartData(obj));
	}
	public XYChart.Series<String, Number> getChartData(Object[][] obj) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		dataSeries.setName(year);
		for(int i=0; i<12; i++) {
			dataSeries.getData().add(new XYChart.Data<>(obj[i][0].toString(),Integer.parseInt(obj[i][1]+"")));
			
		}
		
		return dataSeries;
	}

}
