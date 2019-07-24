package kr.or.yi.hairshop.ui.panel.product;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
	private JTable tableWoker;
	
	private List<Product> proList;
	private List<Event> eventList;
	private List<Designer> workerList;
	
	private ProductMapper pdao = new ProductMapperImpl();
	private EventMapper edao = new EventMapperImpl();
	private JPanel panel;
	private JPanel Section;
	private pCalendar pCalandar;
	private pProductMgnBtn pBtn;
	
	public pProductMgn() {
		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		Section = new JPanel();
		Section.setBorder(null);
		add(Section);
		Section.setLayout(new BorderLayout(0, 0));
		
		pProduct = new JPanel();
		pProduct.setBorder(new TitledBorder(null, "작업 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Section.add(pProduct, BorderLayout.CENTER);
		pProduct.setLayout(new BorderLayout(0, 0));

		
		JScrollPane scrollPaneWork = new JScrollPane();
		
		pProduct.add(scrollPaneWork);
		tableProduct = new JTable();
		scrollPaneWork.setViewportView(tableProduct);
		
		JPanel pRight = new JPanel();
		Section.add(pRight, BorderLayout.EAST);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		pWorker = new JPanel();
		pWorker.setBorder(new TitledBorder(null, "디자이너 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRight.add(pWorker);
		
		pEvent = new JPanel();
		pEvent.setBorder(new TitledBorder(null, "이벤트 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRight.add(pEvent);
		JScrollPane scrollPaneEvent = new JScrollPane();
		JScrollPane scrollPaneWorker = new JScrollPane();
		
		pWorker.add(scrollPaneWorker);
		tableWoker = new JTable();
		scrollPaneWorker.setViewportView(tableWoker);		
		
		pEvent.add(scrollPaneEvent);
		tableEvent = new JTable();
		scrollPaneEvent.setViewportView(tableEvent);				
		
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
		//workerList = dao.selectWorkerByAll();
	}
	
	public void setProductList(List<Product> proList) {
		this.proList = proList;
	}
	
	public void reloadData() {
		tableProduct.setModel(new DefaultTableModel(getRowsProduct(), getColumnNamesProduct()));
		tableCellAlignmentProduct(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidthProduct(100, 100, 100);
		
		tableEvent.setModel(new DefaultTableModel(getRowsEvent(), getColumnNamesEvent()));
		tableCellAlignmentEvent(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidthEvent(100, 100, 100, 100);
		
//		tableWorker.setModel(new DefaultTableModel(getRowsWoker(), getColumnNamesWoker()));
//		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
//		tableSetWidth(100, 100, 100);

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
//			rows[i] = workerList.get(i).toArray();
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
		return new String[] { "이름", "가격", "분류" };
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

		TableColumnModel model = tableWoker.getColumnModel();
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
		TableColumnModel cModel = tableWoker.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	
	
}

























