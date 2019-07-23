package kr.or.yi.hairshop.UI.Panel;

import java.awt.BorderLayout;
import java.awt.Event;
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

import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Product;

public class pProductMgn extends JPanel {
	
	private JPanel pWorker;
	private JPanel pEvent;
	private JPanel pProduct;
	
	private JTable tableProduct;
	private JTable tableEvent;
	private JTable tableWorker;
	
	private List<Event> eventList;
	private List<Product> proList;
	private List<Designer> workerList;
	
	private ProductMapper dao = new ProductMapperImpl();
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
		Section.setBorder(new TitledBorder(null, "제품 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(Section);
		Section.setLayout(new BorderLayout(0, 0));
		
		pProduct = new JPanel();
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
		pRight.add(pWorker);
		
		pEvent = new JPanel();
		pRight.add(pEvent);
		JScrollPane scrollPaneEvent = new JScrollPane();
		JScrollPane scrollPaneWorker = new JScrollPane();
		
		pWorker.add(scrollPaneWorker);
		tableWorker = new JTable();
		scrollPaneWorker.setViewportView(tableWorker);		
		
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

	public void clearProductList() {
		proList = dao.selectProductByAll();
	}
	
	public void setProductList(List<Product> proList) {
		this.proList = proList;
	}
	
	public void reloadData() {
		tableProduct.setModel(new DefaultTableModel(getRows(), getColumnNames()));
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidth(100, 100, 100);
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[proList.size()][];
		for (int i = 0; i < proList.size(); i++) {
			rows[i] = proList.get(i).toArray();
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[] { "이름", "가격", "분류" };
	}

	// 테이블 셀 내용의 정렬
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = tableProduct.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 셀의 폭 설정
	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = tableProduct.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
}

























