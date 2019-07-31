package kr.or.yi.hairshop.ui.panel.chart.designer;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.WorkDialog;

@SuppressWarnings("serial")
public class pPieChartAll extends JFXPanel implements InitScene {

	public pPieChartAll() {
		super();
	}

	private PieChart pieChart;
	private WorkDialogMapper dao = new WorkDialogMapperImpl();

	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);

		pieChart = new PieChart();
		pieChart.setPrefSize(600, 400);
		pieChart.setData(getChartData());
		pieChart.setTitle("총 매출 (디자이너별 비율)");
		pieChart.setLegendVisible(true); // 범례 표시 유무
		pieChart.setLegendSide(Side.RIGHT);// 범례 위치
		pieChart.setLabelLineLength(15); // 원의 둘레 가장자리와 라벨간의 거리 지정
		pieChart.setClockwise(true); // 시계방향 배치여부
		pieChart.setLabelsVisible(true); // 레이블 표시여부

//		pieChart.getData().forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), " %")));
		for (Data d : pieChart.getData()) {
			d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " %"));
		}

		root.getChildren().add(pieChart);

		return scene;
	}

	public ObservableList<Data> getChartData() {
		ObservableList<Data> list = FXCollections.observableArrayList();
		List<WorkDialog> li = dao.selectByDName();

		int size = li.size();
		String[] name = new String[size];
		int[] money = new int[size];
		int i = 0;
		float all = 0;

		for (WorkDialog w : li) {
			name[i] = w.getwDNo().getdName();
			money[i] = w.getwPriceTotal();
			all += money[i];
			i++;
		}

		for (int j = 0; j < size; j++) {
			list.add(new PieChart.Data(name[j], Math.round(100 / (all / money[j])) / 1));
		}

		return list;
	}

	public void addChartData(String title, int count) {
		Data d = new PieChart.Data(title, count);
		pieChart.getData().add(d);
		d.nameProperty().bind(Bindings.concat(d.getName(), " ", d.pieValueProperty(), " 원"));
	}

	public void delChartData(String title) {
		ObservableList<Data> list = pieChart.getData();
		for (int i = 0; i < list.size(); i++) {
			Data d = list.get(i);
			String[] strD = d.getName().split(" ");
			if (strD[0].equals(title)) {
				pieChart.getData().remove(i);
				break;
			}
		}
	}

	public void updateChartData(String title, int count) {
		ObservableList<Data> list = pieChart.getData();

		for (int i = 0; i < list.size(); i++) {
			Data s = list.get(i);
			String[] strD = s.getName().split(" ");
			if (strD[0].equals(title)) {
				s.setPieValue(count);
				break;
			}
		}
	}

	public void addAllChartData() {
		pieChart.setData(getChartData());
	}

	public void deleteAllData() {
		pieChart.getData().clear();
	}
}
