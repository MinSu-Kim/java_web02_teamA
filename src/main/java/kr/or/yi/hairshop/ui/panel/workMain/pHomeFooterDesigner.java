package kr.or.yi.hairshop.ui.panel.workMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import kr.or.yi.hairshop.dao.DesignerMapper;
import kr.or.yi.hairshop.dao.DesignerMapperImpl;
import kr.or.yi.hairshop.dao.GuestMapper;
import kr.or.yi.hairshop.dao.GuestMapperImpl;
import kr.or.yi.hairshop.dao.WorkDialogMapper;
import kr.or.yi.hairshop.dao.WorkDialogMapperImpl;
import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.dto.Guest;
import kr.or.yi.hairshop.dto.Level;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.dto.WorkDialog;

public class pHomeFooterDesigner extends JPanel implements ActionListener, KeyListener {

	private JTextField tfgName;
	private JTextField tfpPrice;
	private JButton btnUpdate;
//	private JSpinner jSpinwWorkTime;
	private JSpinner jSpinwReserveTime;
	private JButton btnCancel;

	private JComboBox<Event> cmbEvent;
	private JComboBox<Designer> cmbDesigner;
	private DefaultComboBoxModel<Event> cmbEventModel;
	private DefaultComboBoxModel<Designer> cmbDesignerModel;

	List<JButton> btnList = new ArrayList<JButton>();
	// 테이블 패널들
	private pHomeProductTable panelProduct;
	private pHomeWorkProductTable panelWorkProduct;
	private pHomeTfgNameTable panelTfgNameTable;

	private List<Product> workProductList;
	private JLabel lblPriceList;
	private JLabel lblProductList;
	private int gNo=-1;

	private JTextField tfgTel;
	WorkDialogMapper wDao = new WorkDialogMapperImpl();
	private JButton btnDelete;
	private int wNo;

	private pHomeSectionForm parent;
	private GuestMapper gDao = new GuestMapperImpl();;

	public void setParent(pHomeSectionForm parent) {
		this.parent = parent;
	}

	public pHomeFooterDesigner() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 10, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));

		panelProduct = new pHomeProductTable();
		panel_6.add(panelProduct);
		panelProduct.setParent(this);
		panelProduct.setBorder(new TitledBorder(null, "상품 리스트", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProduct.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelWorkProduct2 = new JPanel();
		panel_6.add(panelWorkProduct2);
		panelWorkProduct2.setLayout(new BorderLayout(0, 0));

		panelWorkProduct = new pHomeWorkProductTable();
		panelWorkProduct.setParent(this);
		panelWorkProduct.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\uC791\uC5C5\uB9AC\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelWorkProduct.reloadData();
		panelWorkProduct2.add(panelWorkProduct, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblProduct = new JLabel("상품 :");
		panel_4.add(lblProduct, BorderLayout.WEST);

		lblProductList = new JLabel("");
		panel_4.add(lblProductList);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPrice = new JLabel("총액 :");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblPrice);

		lblPriceList = new JLabel("0");
		panel_7.add(lblPriceList);

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelData = new JPanel();
		panel.add(panelData, BorderLayout.CENTER);
		panelData.setLayout(new GridLayout(0, 2, 0, 20));

		JLabel lblgDname = new JLabel("손님");
		panelData.add(lblgDname);
		lblgDname.setHorizontalAlignment(SwingConstants.CENTER);

		tfgName = new JTextField();
		tfgName.addKeyListener(this);
		panelData.add(tfgName);
		tfgName.setColumns(10);

		JLabel lblgTel = new JLabel("전화번호");
		panelData.add(lblgTel);
		lblgTel.setHorizontalAlignment(SwingConstants.CENTER);

		tfgTel = new JTextField();
		panelData.add(tfgTel);

		JLabel lbldName = new JLabel("디자이너");
		panelData.add(lbldName);
		lbldName.setHorizontalAlignment(SwingConstants.CENTER);

		cmbDesigner = new JComboBox<Designer>();
		panelData.add(cmbDesigner);

//		tfdName = new JTextField();
//		panelData.add(tfdName);
//		tfdName.setColumns(10);

//		JLabel lblwWorkTime = new JLabel("작업완료일");
//		panelData.add(lblwWorkTime);
//		lblwWorkTime.setHorizontalAlignment(SwingConstants.CENTER);

//		tfwWorkTime = new JTextField();
//		tfwWorkTime.setColumns(10);
//		panel.add(tfwWorkTime);

//		jSpinwWorkTime = new JSpinner();
//		panelData.add(jSpinwWorkTime);
//		jSpinwWorkTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));

		JLabel lblwReservTime = new JLabel("작업일예약");
		panelData.add(lblwReservTime);
		lblwReservTime.setHorizontalAlignment(SwingConstants.CENTER);

//		tfwReservTime = new JTextField();
//		panelData.add(tfwReservTime);
//		tfwReservTime.setColumns(10);

		jSpinwReserveTime = new JSpinner();
		panelData.add(jSpinwReserveTime);
		jSpinwReserveTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));

		JLabel lbleName = new JLabel("이벤트명");
		panelData.add(lbleName);
		lbleName.setHorizontalAlignment(SwingConstants.CENTER);

		cmbEvent = new JComboBox<Event>();
		panelData.add(cmbEvent);

		JLabel lblpPrice = new JLabel("가격");
		panelData.add(lblpPrice);
		lblpPrice.setHorizontalAlignment(SwingConstants.CENTER);

		tfpPrice = new JTextField();
		panelData.add(tfpPrice);
		tfpPrice.setColumns(10);

//		dchWorkTime = new JDateChooser();
//		dchWorkTime.setDateFormatString("yyyy. M. d. hh. mm");
//		panelData.add(dchWorkTime);
//		
//		dchReserveTime = new JDateChooser();
//		dchReserveTime.setDateFormatString("yyyy. M. d. hh. mm");
//		panelData.add(dchReserveTime);

		JPanel panelBtn = new JPanel();
		panel.add(panelBtn, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		panelBtn.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));

		btnUpdate = new JButton("추가");
		btnUpdate.addActionListener(this);
		panel_5.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panel_5.add(btnDelete);
		btnDelete.setVisible(false);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_5.add(btnCancel);

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));

		panelTfgNameTable = new pHomeTfgNameTable();
		panelTfgNameTable.setParent(this);
		panel_8.add(panelTfgNameTable);

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
	}

	public void setBaseTf(List<Event> event, List<Designer> designer, List<Product> product) {

		cmbEventModel = new DefaultComboBoxModel<Event>(new Vector<Event>(event));
		cmbEvent.setModel(cmbEventModel);
		cmbDesignerModel = new DefaultComboBoxModel<Designer>(new Vector<Designer>(designer));
		cmbDesigner.setModel(cmbDesignerModel);

		panelProduct.setItemList(product);
		panelProduct.reloadData();
	}

	public void clearTf() {
		gNo = -1;
		wNo = -1;
		tfgTel.setEnabled(true);
		btnDelete.setVisible(false);
		tfgTel.setText("");
		lblPriceList.setText("0");
		lblProductList.setText("");
		tfgName.setEnabled(true);
		btnUpdate.setText("추가");
		tfgName.setText("");
		tfpPrice.setText("");
		jSpinwReserveTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
//		jSpinwWorkTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		cmbDesigner.setSelectedIndex(-1);
		cmbEvent.setSelectedIndex(-1);
		revalidate();
		repaint();
	}

	public void setTfWork(WorkDialog workDialog) {
		wNo = workDialog.getwNo();
		gNo = workDialog.getwGNo().getgNo();
		btnUpdate.setText("수정");
		btnDelete.setVisible(true);
		tfgTel.setText(workDialog.getwGNo().getgTel());
		tfgTel.setEditable(false);
		cmbDesigner.setSelectedItem(new Designer(workDialog.getwDNo().getdNo()));
		cmbEvent.setSelectedItem(new Event(workDialog.getwEName().geteName()));
		tfgName.setText(workDialog.getwGNo().getgName());
		tfgName.setEnabled(false);
		tfpPrice.setText(workDialog.getwPriceTotal() + "");

		panelWorkProduct.setItemList(workDialog.getProductList());
		panelWorkProduct.reloadData();
		panelWorkProduct.setBorder(new TitledBorder(null, workDialog.getwGNo().getgName() + "님의 작업리스트",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		Date date = new Date();
		if (workDialog.getwReserveTime() != null)
			jSpinwReserveTime
					.setModel(new SpinnerDateModel(workDialog.getwReserveTime(), null, null, Calendar.HOUR_OF_DAY));
		else {
			jSpinwReserveTime.setModel(new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY));
		}
//		if (workDialog.getwWorkTime() != null)
//			jSpinwWorkTime.setModel(new SpinnerDateModel(workDialog.getwWorkTime(), null, null, Calendar.HOUR_OF_DAY));
//		else
//			jSpinwWorkTime.setModel(new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY));

	}

	public void setTfGuest(Guest guest) {
		gNo = guest.getgNo();
		tfgName.setText(guest.getgName());
		tfgTel.setText(guest.getgTel());
		tfgTel.setEnabled(false);
		tfgName.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnUpdate) {
			if (e.getActionCommand().equals("추가"))
				actionPerformedBtnAdd(e);
			if (e.getActionCommand().equals("수정"))
				actionPerformedBtnUpdate(e);
		}
	}

	public WorkDialog getWork() {
		WorkDialog work = new WorkDialog();
		Designer designer = (Designer) cmbDesigner.getSelectedItem();
		Event event = (Event) cmbEvent.getSelectedItem();

		work.setwReservTime((Date) jSpinwReserveTime.getValue());
//		work.setwWorkTime((Date)jSpinwWorkTime.getValue());
		if (!tfpPrice.getText().equals(""))
			work.setwPriceTotal(Integer.parseInt(tfpPrice.getText()));

		work.setwDNo(designer);
		work.setwGNo(new Guest(gNo));
		work.setwEName(event);
		return work;
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {

		WorkDialog work = getWork();

		List<Product> productList = panelWorkProduct.getProductList();

		int confirm = JOptionPane.showConfirmDialog(null, "정말 추가 하시겠습니까?", "추가", JOptionPane.YES_NO_OPTION);// 예 0 /아니오1

		if (confirm == 0) {

			if (tfgName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "손님을 입력해 주세요");
				return;
			}
			if (tfgTel.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요");
				return;
			}

			if (cmbDesigner.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "디자이너를 선택해 주세요");
				return;
			}

			if (cmbEvent.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "이벤트를 선택해 주세요");
				return;
			}
			System.out.println(gNo);
			if(gNo<0) {
				Guest guest = new Guest();
				guest.setgTel(tfgTel.getText());
				guest.setgName(tfgName.getText());
				gNo = gDao.insertGuestByWorkMain(guest);
			}
			System.out.println(gNo);
			if (gNo > 0) {
				int result = -1;
				if (productList.size() > 0) {
					Date date = new Date();
					work.setwWorkTime(date);
					work.setwGNo(new Guest(gNo));
					result = wDao.insertWorkDialogResWNo(work);
				} else {
					JOptionPane.showMessageDialog(null, "상품을 입력해 주세요!");
				}

				if (result > 0) {
					for (int i = 0; i < productList.size(); i++) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("wNo", result + "");
						map.put("pName", productList.get(i).getpName());
						wDao.insertChoice(map);
					}
				}

				parent.refresh(parent.start);
				panelWorkProduct.clearProduct();
				clearTf();
			}else {
				JOptionPane.showMessageDialog(null, "손님 데이터를 정확히 입력해주세요");
			}
		}
	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		WorkDialog work = getWork();
		work.setwNo(wNo);
		List<Product> list = panelWorkProduct.getProductList();

		wDao.deleteChoice(wNo);
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("wNo", wNo + "");
			map.put("pName", list.get(i).getpName());
			wDao.insertChoice(map);
		}
		wDao.updateWorkDialog(work);
		clearTf();
		parent.refresh(parent.start);
		panelWorkProduct.clearProduct();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearTf();
	}

	public void setWorkProduct(Product product) {
		panelWorkProduct.addProduct(product);
		setPriceSub();
	}

	public void setPriceSub() {
		workProductList = panelWorkProduct.getProductList();
		int price = 0;
		String product = "";

		for (int i = 0; i < workProductList.size(); i++) {
			if (i == 0)
				product = workProductList.get(i).getpName();
			else {
				product += "," + workProductList.get(i).getpName();
			}
			price += workProductList.get(i).getpPrice();
		}
		lblPriceList.setText(price + "");
		lblProductList.setText(product);
		tfpPrice.setText(price + "");
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == tfgName) {
			keyTypedTfgName(e);
		}
	}

	protected void keyTypedTfgName(KeyEvent e) {

		List<Guest> gList = gDao.selectGuestBygName(tfgName.getText());
		panelTfgNameTable.setItemList(gList);
		if (gList != null)
			panelTfgNameTable.reloadData();
	}

	protected void actionPerformedBtnDelete(ActionEvent e) {
		int res1 = wDao.deleteChoice(wNo);
		int res2 = wDao.deleteWorkDialog(wNo);
		parent.refresh(parent.start);
		
	}
}