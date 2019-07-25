package kr.or.yi.hairshop.ui.panel.product;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.EventMapper;
import kr.or.yi.hairshop.dao.EventMapperImpl;
import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.panel.pCalendar;

public class pProductMgn extends JPanel {

	private JPanel pWorker;
	private JPanel pEvent;
	private JPanel pProduct;

	private JTable tableProduct;
	private JTable tableEvent;
	private JTable tableWorker;

	private List<Product> proList;
	private List<Event> eventList;
	private List<Designer> workerList;

	private ProductMapper pdao = new ProductMapperImpl();
	private EventMapper edao = new EventMapperImpl();
	private DesignerMapper wdao = new DesignerMapperImpl();
	private JPanel panel;
	private JPanel Section;
	private pCalendar pCalandar;
	private pProductMgnBtn pBtn;
	private JPanel pTop;
	private JPanel panel_1;
	private JLabel lblName;
	private JTextField textField;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel label_2;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnProductAdd;
	private JButton btnProductUpdate;
	private JButton btnProductDelete;
	private JLabel lblNewLabel_1;
	private JLabel label_3;
	private JSpinner spStartDate;
	private JSpinner spEndDate;
	private JSpinner spinner;

	public pProductMgn() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		Section = new JPanel();
		Section.setBorder(null);
		add(Section);
		Section.setLayout(new GridLayout(0, 1, 0, 0));

		pTop = new JPanel();
		Section.add(pTop);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));

		pEvent = new JPanel();
		pTop.add(pEvent);
		pEvent.setBorder(new TitledBorder(null, "이벤트 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pEvent.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		pEvent.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblName = new JLabel("이벤트 제목");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblName);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		lblStartDate = new JLabel("시작일");
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblStartDate);
		
		spStartDate = new JSpinner();
		spStartDate.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		panel_2.add(spStartDate);
		
		lblEndDate = new JLabel("종료일");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblEndDate);
		
		spEndDate = new JSpinner();
		spEndDate.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		panel_2.add(spEndDate);
		
		label_2 = new JLabel("할인율");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_2);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		panel_2.add(spinner);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		label_3 = new JLabel("");
		panel_3.add(label_3);
		
		btnProductAdd = new JButton("등 록");
		panel_3.add(btnProductAdd);
		
		btnProductUpdate = new JButton("수 정");
		panel_3.add(btnProductUpdate);
		
		btnProductDelete = new JButton("삭 제");
		panel_3.add(btnProductDelete);
		
		lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		JScrollPane scrollPaneEvent = new JScrollPane();

		pEvent.add(scrollPaneEvent);
		tableEvent = new JTable();
		scrollPaneEvent.setViewportView(tableEvent);

		pProduct = new JPanel();
		pTop.add(pProduct);
		pProduct.setBorder(new TitledBorder(null, "작업 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pProduct.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneWork = new JScrollPane();

		pProduct.add(scrollPaneWork);
		tableProduct = new JTable();
		scrollPaneWork.setViewportView(tableProduct);

		pWorker = new JPanel();
		Section.add(pWorker);
		pWorker.setBorder(new TitledBorder(null, "디자이너 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pWorker.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneWorker = new JScrollPane();

		pWorker.add(scrollPaneWorker);
		tableWorker = new JTable();
		scrollPaneWorker.setViewportView(tableWorker);

		panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		pCalandar = new pCalendar();
		panel.add(pCalandar);

		pBtn = new pProductMgnBtn();
		panel.add(pBtn);

	}

	public void clearList() {
		proList = pdao.selectProductByAll();
		eventList = edao.selectEventByAll();
		workerList = wdao.selectDesignerByMgn();
	}

	public void setProductList(List<Product> proList) {
		this.proList = proList;
	}

	public void reloadData() {
		tableProduct.setModel(new DefaultTableModel(getRowsProduct(), getColumnNamesProduct()));
		tableProduct.setSize(100, 100);
		tableCellAlignmentProduct(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidthProduct(80, 80, 80);

		tableEvent.setModel(new DefaultTableModel(getRowsEvent(), getColumnNamesEvent()));
		tableCellAlignmentEvent(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidthEvent(80, 80, 120, 120);

		tableWorker.setModel(new DefaultTableModel(getRowsWoker(), getColumnNamesWoker()));
		tableCellAlignmentWoker(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidthWoker(80, 80, 120, 120);

	}

	private Object[][] getRowsProduct() {
		Object[][] rows = new Object[proList.size()][];
		for (int i = 0; i < proList.size(); i++) {
			rows[i] = proList.get(i).toArray();
		}
		return rows;
	}

	private Object[][] getRowsEvent() {
		Object[][] rows = new Object[eventList.size()][];
		for (int i = 0; i < eventList.size(); i++) {
			rows[i] = eventList.get(i).toArray();
		}
		return rows;
	}

	private Object[][] getRowsWoker() {
		Object[][] rows = new Object[workerList.size()][];
		for (int i = 0; i < workerList.size(); i++) {
			rows[i] = workerList.get(i).toArrayMgn();
		}
		return rows;
	}

	private String[] getColumnNamesProduct() {
		return new String[] { "이름", "가격", "분류" };
	}

	private String[] getColumnNamesEvent() {
		return new String[] { "이름", "시작일", "종료일", "할인율" };
	}

	private String[] getColumnNamesWoker() {
		return new String[] { "직급", "이름", "전화번호", "비상연락망" };
	}

	// 테이블 셀 내용의 정렬
	protected void tableCellAlignmentProduct(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = tableProduct.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableCellAlignmentEvent(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = tableEvent.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableCellAlignmentWoker(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = tableWorker.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 셀의 폭 설정
	protected void tableSetWidthProduct(int... width) {
		TableColumnModel cModel = tableProduct.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void tableSetWidthEvent(int... width) {
		TableColumnModel cModel = tableEvent.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void tableSetWidthWoker(int... width) {
		TableColumnModel cModel = tableWorker.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

}
