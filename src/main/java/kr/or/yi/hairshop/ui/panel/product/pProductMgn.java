package kr.or.yi.hairshop.ui.panel.product;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.EventMapper;
import kr.or.yi.hairshop.dao.EventMapperImpl;
import kr.or.yi.hairshop.dao.ProductMapper;
import kr.or.yi.hairshop.dao.ProductMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.panel.MyTableModel;
import kr.or.yi.hairshop.panel.pCalendar;
import kr.or.yi.hairshop.ui.frame.DesignerFrame;

@SuppressWarnings("serial")
public class pProductMgn extends JPanel implements ActionListener, MouseListener {

	public pProductMgn ProductMgn;

	private JPanel pWorker;
	private JPanel pEvent;
	private JPanel pProduct;

	private JTable tableProduct;
	private JTable tableEvent;
	private JTable tableWorker;

	private int selectedEvent;
	private int selectedProduct;
	private int selectedWorker;

	private List<Product> proList;
	private List<Event> eventList;
	private List<Designer> workerList;

	private ProductMapper pdao = new ProductMapperImpl();
	private EventMapper edao = new EventMapperImpl();
	private DesignerMapper wdao = new DesignerMapperImpl();

	private JPanel panel;
	private JPanel Section;
	private pCalendar pCalandar;
	private JPanel pTop;
	private JPanel panel_1;
	private JLabel lblEventName;
	private JTextField tfEventName;
	private JLabel lblEventStartDate;
	private JLabel lblEventEndDate;
	private JLabel lblEventSale;
	private JPanel pEventTF;
	private JPanel panel_3;
	private JButton btnEvent;
	private JLabel lblNewLabel_1;
	private JLabel label_3;
	private JSpinner spEventSale;
	private JPanel panel_4;
	private JLabel lblNewLabel;

	private JPopupMenu popupMenuEvent;
	private JPopupMenu popupMenuProduct;
	private JPopupMenu popupMenuWorker;

	private JMenuItem mntmPopEventUpdate;
	private JMenuItem mntmPopEventDelete;
	private JMenuItem mntmPopEventAdd;

	private JMenuItem mntmPopProductUpdate;
	private JMenuItem mntmPopProductDelete;
	private JMenuItem mntmPopProductAdd;

	private JPanel pProductTF;
	private JLabel lblNewLabel_2;
	private JTextField tfProductName;
	private JLabel label;
	private JSpinner spProductPrice;
	private JLabel label_1;
	private JPanel panel_2;
	private JPanel panel_5;
	private JButton btnProduct;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField tfDivision;
	private JDateChooser dcEventStartDate;
	private JDateChooser dcEventEndDate;

	private JMenuItem mntmPopWorkerAdd;
	private JMenuItem mntmPopWorkerUpdate;
	private JMenuItem mntmPopWorkerDelete;
	private DesignerFrame DesignerFrame;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnSearchName;
	private JTextField tfPName;
	private JButton btnSearchAll;

	public pProductMgn() {
		DesignerFrame = new DesignerFrame();
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

		pEventTF = new JPanel();
		panel_1.add(pEventTF);
		pEventTF.setLayout(new GridLayout(0, 2, 0, 0));

		lblEventName = new JLabel("이벤트 제목");
		lblEventName.setHorizontalAlignment(SwingConstants.CENTER);
		pEventTF.add(lblEventName);

		tfEventName = new JTextField();
		pEventTF.add(tfEventName);
		tfEventName.setColumns(10);

		lblEventStartDate = new JLabel("시작일");
		lblEventStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		pEventTF.add(lblEventStartDate);

		dcEventStartDate = new JDateChooser();
		pEventTF.add(dcEventStartDate);

		lblEventEndDate = new JLabel("종료일");
		lblEventEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		pEventTF.add(lblEventEndDate);

		dcEventEndDate = new JDateChooser();
		pEventTF.add(dcEventEndDate);

		lblEventSale = new JLabel("할인율");
		lblEventSale.setHorizontalAlignment(SwingConstants.CENTER);
		pEventTF.add(lblEventSale);

		spEventSale = new JSpinner();
		spEventSale.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		pEventTF.add(spEventSale);

		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		label_3 = new JLabel("");
		panel_3.add(label_3);

		btnEvent = new JButton("등 록");
		btnEvent.addActionListener(this);
		panel_3.add(btnEvent);

		lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		JScrollPane scrollPaneEvent = new JScrollPane();

		pEvent.add(scrollPaneEvent);
		tableEvent = new JTable();
		tableEvent.addMouseListener(this);
		scrollPaneEvent.setViewportView(tableEvent);

		pProduct = new JPanel();
		pTop.add(pProduct);
		pProduct.setBorder(new TitledBorder(null, "작업 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pProduct.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneProduct = new JScrollPane();

		pProduct.add(scrollPaneProduct);
		tableProduct = new JTable();
		tableProduct.addMouseListener(this);
		scrollPaneProduct.setViewportView(tableProduct);

		pWorker = new JPanel(); // 디자이너
		Section.add(pWorker);
		pWorker.setBorder(new TitledBorder(null, "디자이너 관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pWorker.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneWorker = new JScrollPane();

		pWorker.add(scrollPaneWorker);
		tableWorker = new JTable();
		tableWorker.addMouseListener(this);
		scrollPaneWorker.setViewportView(tableWorker);

		panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		pCalandar = new pCalendar();
		panel.add(pCalandar, BorderLayout.NORTH);
		pCalandar.setLayout(new GridLayout(1, 0, 0, 0));

		panel_4 = new JPanel();
		panel.add(panel_4);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\home.jpg"));
		panel_4.add(lblNewLabel);

		popupMenuEventInit(scrollPaneEvent);
		popupMenuProductInit(scrollPaneProduct);

		panel_6 = new JPanel();
		pProduct.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));

		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "\uC774\uB984 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		panel_6.add(panel_7, BorderLayout.NORTH);

		tfPName = new JTextField();
		panel_7.add(tfPName);
		tfPName.setColumns(10);

		btnSearchName = new JButton("검색");
		btnSearchName.addActionListener(this);
		panel_7.add(btnSearchName);

		btnSearchAll = new JButton("전체 검색");
		btnSearchAll.addActionListener(this);
		panel_7.add(btnSearchAll);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uC791\uC5C5 \uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		panel_6.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		pProductTF = new JPanel();
		panel_2.add(pProductTF, BorderLayout.CENTER);
		pProductTF.setLayout(new GridLayout(0, 2, 0, 0));

		lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		pProductTF.add(lblNewLabel_2);

		tfProductName = new JTextField();
		pProductTF.add(tfProductName);
		tfProductName.setColumns(10);

		label = new JLabel("가격");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		pProductTF.add(label);

		spProductPrice = new JSpinner();
		spProductPrice.setModel(new SpinnerNumberModel(new Integer(5000), new Integer(0), null, new Integer(5000)));
		pProductTF.add(spProductPrice);

		label_1 = new JLabel("분류");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		pProductTF.add(label_1);

		tfDivision = new JTextField();
		pProductTF.add(tfDivision);
		tfDivision.setColumns(10);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		lblNewLabel_6 = new JLabel("");
		panel_5.add(lblNewLabel_6);

		btnProduct = new JButton("등 록");
		btnProduct.addActionListener(this);
		panel_5.add(btnProduct);

		lblNewLabel_5 = new JLabel("");
		panel_5.add(lblNewLabel_5);
		popupMenuWorkerInit(scrollPaneWorker);

	}

	private void popupMenuProductInit(JScrollPane scrollPaneProduct) {
		popupMenuProduct = new JPopupMenu();

		mntmPopProductAdd = new JMenuItem("등록");
		mntmPopProductAdd.addActionListener(this);
		popupMenuProduct.add(mntmPopProductAdd);

		mntmPopProductUpdate = new JMenuItem("수정");
		mntmPopProductUpdate.addActionListener(this);
		popupMenuProduct.add(mntmPopProductUpdate);

		mntmPopProductDelete = new JMenuItem("삭제");
		mntmPopProductDelete.addActionListener(this);
		popupMenuProduct.add(mntmPopProductDelete);

		tableProduct.setComponentPopupMenu(popupMenuProduct);
		scrollPaneProduct.setComponentPopupMenu(popupMenuProduct);

	}

	public void popupMenuEventInit(JScrollPane scrollPaneEvent) {
		popupMenuEvent = new JPopupMenu();

		mntmPopEventAdd = new JMenuItem("등록");
		mntmPopEventAdd.addActionListener(this);
		popupMenuEvent.add(mntmPopEventAdd);

		mntmPopEventUpdate = new JMenuItem("수정");
		mntmPopEventUpdate.addActionListener(this);
		popupMenuEvent.add(mntmPopEventUpdate);

		mntmPopEventDelete = new JMenuItem("삭제");
		mntmPopEventDelete.addActionListener(this);
		popupMenuEvent.add(mntmPopEventDelete);

		tableEvent.setComponentPopupMenu(popupMenuEvent);
		scrollPaneEvent.setComponentPopupMenu(popupMenuEvent);
	}

	public void popupMenuWorkerInit(JScrollPane scrollPaneWorker) {
		popupMenuWorker = new JPopupMenu();

		mntmPopWorkerAdd = new JMenuItem("등록");
		mntmPopWorkerAdd.addActionListener(this);
		popupMenuWorker.add(mntmPopWorkerAdd);

		mntmPopWorkerUpdate = new JMenuItem("수정");
		mntmPopWorkerUpdate.addActionListener(this);
		popupMenuWorker.add(mntmPopWorkerUpdate);

		mntmPopWorkerDelete = new JMenuItem("삭제");
		mntmPopWorkerDelete.addActionListener(this);
		popupMenuWorker.add(mntmPopWorkerDelete);

		tableWorker.setComponentPopupMenu(popupMenuWorker);
		scrollPaneWorker.setComponentPopupMenu(popupMenuWorker);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchAll) {
			actionPerformedBtnSearchAll(e);
		}
		if (e.getSource() == btnSearchName) {
			actionPerformedBtnSearchName(e);
		}
		if (e.getSource() == btnProduct) {
			actionPerformedBtnProduct(e);
		}
		if (e.getSource() == btnEvent) {
			actionPerformedBtnEvent(e);
		}

		/* ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ event 팝업 ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ */
		if (e.getSource() == mntmPopEventAdd) {
			clearEventTf();
			btnEvent.setText("등록");
			tfEventName.setEditable(true);
		}
		if (e.getSource() == mntmPopEventUpdate) {
//			int i = tableEvent.getSelectedRow();
			Event selectEvent = eventList.get(selectedEvent);
			setEventTf(selectEvent);
			btnEvent.setText("수정");
			tfEventName.setEditable(false);
		}
		if (e.getSource() == mntmPopEventDelete) {
			deleteEventUI();
			clearEventTf();
			btnEvent.setText("등록");
			tfEventName.setEditable(true);
		}

		/* ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ product 팝업 ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ */
		if (e.getSource() == mntmPopProductAdd) {
			clearProductTf();
			btnProduct.setText("등록");
			tfProductName.setEditable(true);
		}
		if (e.getSource() == mntmPopProductUpdate) {
//			int i = tableProduct.getSelectedRow();
			Product selectProduct = proList.get(selectedProduct);
			setProductTf(selectProduct);
			btnProduct.setText("수정");
			tfProductName.setEditable(false);
		}
		if (e.getSource() == mntmPopProductDelete) {
			deleteProductUI();
			clearProductTf();
			btnProduct.setText("등록");
			tfProductName.setEditable(true);
		}

		/* ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ worker 팝업 ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ */
		if (e.getSource() == mntmPopWorkerDelete) {
			deleteDesigner();
		}
		if (e.getSource() == mntmPopWorkerAdd) { // 디자이너 등록
			DesignerFrameView();
		}
		if (e.getSource() == mntmPopWorkerUpdate) { // 디자이너 수정
//			int i = tableWorker.getSelectedRow();
			Designer worker = workerList.get(selectedWorker);
//			System.out.println("============================================"+i);
//			System.out.println("============================================"+worker.toString2());
			DesignerFrame.setProductMgn(this);
			DesignerFrame.setText(worker);
			setWorker(worker);
		}
	}

	private void DesignerFrameView() { // 등록
		DesignerFrame.setBtnText("등록");
		DesignerFrame.setProductMgn(this);
		DesignerFrame.setVisible(true);
	}

	private void setWorker(Designer worker) { // 수정
		DesignerFrame.setBtnText("수정");
		DesignerFrame.setVisible(true);
	}

	private void deleteDesigner() {
		int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.CLOSED_OPTION) {
			// 취소
		} else if (result == JOptionPane.YES_OPTION) {
			// 예
//			int i = tableWorker.getSelectedRow();
			Designer designer = workerList.get(selectedWorker);
			System.out.println(designer);
			System.out.println(wdao);
			wdao.deleteDesigner(designer.getdNo());
			clearList();
			reloadData();
		} else {
			// 아니오
		}
	}

	private void deleteProductUI() {
		int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.CLOSED_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {// 예

//			int i = tableProduct.getSelectedRow();
			Product selectProduct = proList.get(selectedProduct);
			pdao.deleteByName(selectProduct.getpName());
			clearEventTf();
			clearList();
			reloadData();
		} else { // 아니오

		}

	}

	// product 등록 버튼
	private void actionPerformedBtnProduct(ActionEvent e) {
		if (tfProductName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "모두 입력하세요");
		} else {
			if (btnProduct.getText().equals("수정")) {
				String pName = tfProductName.getText();
				int pPrice = (int) spProductPrice.getValue();
				String pDivision = tfDivision.getText();

				Product pro = new Product(pPrice, pName, pDivision);

				pdao.updateByName(pro);
				btnProduct.setText("등록");
				tfProductName.setEditable(true);
				clearProductTf();
				clearList();
				reloadData();
			} else {
				String pName = tfProductName.getText();
				int pPrice = (int) spProductPrice.getValue();
				String pDivision = tfDivision.getText();
				Product pro = new Product(pPrice, pName, pDivision);
				pdao.insert(pro);
				clearProductTf();
				clearList();
				reloadData();
			}
		}
	}

	// event 등록 버튼
	protected void actionPerformedBtnEvent(ActionEvent e) {
		if (tfEventName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "모두 입력하세요");
		} else {
			if (btnEvent.getText().equals("수정")) {
				String eName = tfEventName.getText();
				Date eStartDay = dcEventStartDate.getDate();
				Date eEndDay = dcEventEndDate.getDate();

				if (eEndDay.compareTo(eStartDay) == -1) {
					JOptionPane.showMessageDialog(null, "날짜를 잘못입력하였습니다.");
					return;
				}

				int eSale = (int) spEventSale.getValue();

				Event event = new Event(eName, eStartDay, eEndDay, eSale);
				edao.updateByName(event);
				btnEvent.setText("등록");
				tfEventName.setEditable(true);
				clearEventTf();
				clearList();
				reloadData();

			} else {
				String eName = tfEventName.getText();
				Date eStartDay = dcEventStartDate.getDate();
				Date eEndDay = dcEventEndDate.getDate();
				int eSale = (int) spEventSale.getValue();
				if (eEndDay.compareTo(eStartDay) == -1) {
					JOptionPane.showMessageDialog(null, "날짜를 잘못입력하였습니다.");
					return;
				}
				Event event = new Event(eName, eStartDay, eEndDay, eSale);
				edao.insert(event);
				clearEventTf();
				clearList();
				reloadData();
			}
		}
	}

	private void setProductTf(Product selectProduct) {
		tfProductName.setText(selectProduct.getpName());
		spProductPrice.setValue(selectProduct.getpPrice());
		tfDivision.setText(selectProduct.getpDivision());
	}

	private void clearProductTf() {
		tfProductName.setText("");
		spProductPrice.setValue(0);
		tfDivision.setText("");
	}

	private void deleteEventUI() {
		int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.CLOSED_OPTION) {
			// 취소 선택

		} else if (result == JOptionPane.YES_OPTION) {
			// 예 선택
//			int i = tableEvent.getSelectedRow();
			Event selectEvent = eventList.get(selectedEvent);
			edao.deleteByName(selectEvent.geteName());
			clearEventTf();
			clearList();
			reloadData();
		} else {
			// 아니오 선택
		}

	}

	private void setEventTf(Event e) {
		tfEventName.setText(e.geteName());
		dcEventStartDate.setDate(e.geteStartDay());
		dcEventEndDate.setDate(e.geteEndDay());
		spEventSale.setValue(e.geteSale());
	}

	private void clearEventTf() {
		tfEventName.setText("");
		dcEventStartDate.setDate(new Date());
		dcEventEndDate.setDate(new Date());
		spEventSale.setValue(0);
	}

	public void clearList() {
		proList = pdao.selectProductByAll();
		eventList = edao.selectEventByAll();
		workerList = wdao.selectDesignerByMgn();
	}

	public void setProductList(List<Product> proList) {
		this.proList = proList;
	}

//	public void reloadData() {
//		tableProduct.setModel(new DefaultTableModel(getRowsProduct(), getColumnNamesProduct()));
//		tableProduct.setSize(100, 100);
//		tableCellAlignmentProduct(SwingConstants.CENTER, 0, 1, 2);
//		tableSetWidthProduct(80, 80, 80);
//
//		tableEvent.setModel(new DefaultTableModel(getRowsEvent(), getColumnNamesEvent()));
//		tableCellAlignmentEvent(SwingConstants.CENTER, 0, 1, 2, 3);
//		tableSetWidthEvent(80, 80, 120, 120);
//		
//		MyTableModel model = new MyTableModel(getRowsWoker(), getColumnNamesWoker());
//		tableWorker.setModel(model);
//		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
//		tableWorker.setRowSorter(sorter);
//		tableCellAlignmentWoker(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
//		tableSetWidthWoker(50, 50, 60, 60, 60, 60, 60);
//
//	}

	public void reloadData() {
		MyTableModel model2 = new MyTableModel(getRowsProduct(), getColumnNamesProduct());
		tableProduct.setModel(model2);
		tableProduct.setSize(100, 100);
		RowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(model2);
		tableProduct.setRowSorter(sorter2);
		tableCellAlignmentProduct(SwingConstants.CENTER, 0, 1, 2);
		tableSetWidthProduct(80, 80, 80);

		MyTableModel model1 = new MyTableModel(getRowsEvent(), getColumnNamesEvent());
		tableEvent.setModel(model1);
		RowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(model1);
		tableEvent.setRowSorter(sorter1);
		tableCellAlignmentEvent(SwingConstants.CENTER, 0, 1, 2, 3);
		tableSetWidthEvent(80, 80, 120, 120);

		MyTableModel model = new MyTableModel(getRowsWoker(), getColumnNamesWoker());
		tableWorker.setModel(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		tableWorker.setRowSorter(sorter);
		tableCellAlignmentWoker(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		tableSetWidthWoker(50, 50, 60, 60, 60, 60, 60);

	}

	private Object[][] getRowsProduct() {
		if (proList == null) {
			proList = new ArrayList<Product>();
		}
		Object[][] rows = new Object[proList.size()][];
		for (int i = 0; i < proList.size(); i++) {
			rows[i] = proList.get(i).toArray();
		}
		return rows;
	}

	private Object[][] getRowsEvent() {
		if (eventList == null) {
			eventList = new ArrayList<Event>();
		}
		Object[][] rows = new Object[eventList.size()][];
		for (int i = 0; i < eventList.size(); i++) {
			rows[i] = eventList.get(i).toArray();
		}
		return rows;
	}

	public Object[][] getRowsWoker() {
		if (workerList == null) {
			workerList = new ArrayList<Designer>();
		}
		Object[][] rows = new Object[workerList.size()][];
		for (int i = 0; i < workerList.size(); i++) {
			rows[i] = workerList.get(i).toArrayMgn();
		}
		return rows;
	}

	private String[] getColumnNamesProduct() {
		return new String[] { "이름", "가격", "소모품 사영여부" };
	}

	private String[] getColumnNamesEvent() {
		return new String[] { "이름", "시작일", "종료일", "할인율" };
	}

	private String[] getColumnNamesWoker() {
		return new String[] { "직급", "아이디", "이름", "전화번호", "비상연락망", "생일", "메모" };
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

	public void setWorkList(List<Designer> ds) {
		this.workerList = ds;
	}

	public void mouseClicked(MouseEvent e) {
		selectedEvent = tableEvent.getSelectedRow();
		selectedProduct = tableProduct.getSelectedRow();
		selectedWorker = tableWorker.getSelectedRow();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == tableWorker) {
			mouseExitedTableWorker(e);
		}
		if (e.getSource() == tableProduct) {
			mouseExitedTableProduct(e);
		}
		if (e.getSource() == tableEvent) {
			mouseExitedTableEvent(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseExitedTableEvent(MouseEvent e) {
		tableEvent.clearSelection();
	}

	protected void mouseExitedTableProduct(MouseEvent e) {
		tableProduct.clearSelection();
	}

	protected void mouseExitedTableWorker(MouseEvent e) {
		tableWorker.clearSelection();
	}
	protected void actionPerformedBtnSearchName(ActionEvent e) {
		String name = tfPName.getText();
		proList = pdao.searchByName(name);
		reloadData();
		tfPName.setText("");
	}
	protected void actionPerformedBtnSearchAll(ActionEvent e) {
		clearList();
		reloadData();		
	}
}
