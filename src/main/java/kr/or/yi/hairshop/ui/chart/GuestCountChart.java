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
public class GuestCountChart extends JFXPanel implements InitScene{

	private BarChart<String, Number> barChart;
	private List<WorkDialog> wList;
	
	public GuestCountChart() {
		
		
	}
	public void setWList(List<WorkDialog> wList) {
		this.wList = wList;
	}
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("미용횟수");

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("고객 현황");
		
		barChart.setPrefSize(500, 250);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);

		return scene;
	}
	public void deleteAllData() {
		barChart.getData().clear();
	}
	
	/** 해당 학생의 삭제
	 * @param work
	 */
//	public void delChartData(WorkDialog work) {
//		ObservableList<Series<String, Number>> list = barChart.getData();
//		Iterator<Series<String, Number>>  it = list.iterator();
//		while(it.hasNext()) {
//			Series<String, Number> s = it.next();
//			if (s.getName().equals(work.getworkName())) {
//				barChart.getData().remove(s);
//				break;
//			}
//		}
//	}
	

	/**
	 * 해당 학생 정보 갱신
	 * @param work
	 */
//	public void updateChartData(WorkDialog work) {
//		ObservableList<Series<String, Number>> list = barChart.getData();
//		
//		for(int i = 0; i<list.size(); i++) {
//			Series<String, Number> s = list.get(i);
//			if (s.getName().equals(work.getworkName())) {
//				s.getData().set(0, new XYChart.Data<>("국어", work.getKorScore()));
//				s.getData().set(1, new XYChart.Data<>("영어", work.getEngScore()));
//				s.getData().set(2, new XYChart.Data<>("수학", work.getMathScore()));	
//				break;
//			}
//		}
//	}
	
	/** getChartData() 를 이용하여 학생정보추가
	 * @param work
	 */
	public void addChartData() {
		System.out.println("아마 이건 실행안될거고");
//		barChart.getData().add();
	}
//	
	/**
	 * getChartData()에 의해 모든 데이터 추가
	 */
	public void addAllChartData() {
		barChart.setData(getChartData());
	}
	
	/**
	 * @param work
	 * @return
	 */
//	고정 가로 픽스
//	년도를 표시하기위해 가로 텍스트 셋팅일듯
//	가로를 몇칸으로 할지
	public XYChart.Series<String, Number> getChartData(WorkDialog work) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		

		dataSeries.setName(work.getwGNo().getgName());
		dataSeries.getData().add(new XYChart.Data<>("Top10",work.getwPriceTotal()));
		
		return dataSeries;
	}
//	한(국어) 컬럼에 몇명을 표시할지
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		
		int top=0;
		if(wList.size()>9)
			top=10;
		else
			top=wList.size();
		for(int i=0; i<top; i++) {
//			WorkDialog work = new WorkDialog(wList.get(i).getwNo(),wList.get(i).getwGNo(),wList.get(i).getwPriceTotal());
			list.add(getChartData(wList.get(i)));
		}
		
		
		
//		list.add(getChartData(work))
		
//		가로로 셋팅이 됩니다.
//		WorkDialog work = new WorkDialog("S001", "현빈", 90, 60,70);
//		WorkDialog work2 = new WorkDialog("S002", "박신혜", 60, 55,88);
		
//		list.add(getChartData(work));
//		list.add(getChartData(work2));
		
		return list;
	}

	

}
