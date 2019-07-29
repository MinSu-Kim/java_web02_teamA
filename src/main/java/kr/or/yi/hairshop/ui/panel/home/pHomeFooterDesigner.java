package kr.or.yi.hairshop.ui.panel.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import kr.or.yi.hairshop.dto.Designer;
import kr.or.yi.hairshop.dto.Event;
import kr.or.yi.hairshop.dto.Product;
import kr.or.yi.hairshop.dto.WorkDialog;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class pHomeFooterDesigner extends JPanel implements ActionListener{

	private JTextField tfgName;
	private JTextField tfwReservTime;
	private JTextField tfpPrice;
	private JButton btnUpdate;
	private JSpinner jSpinwWorkTime;
	private final String[] columns = { "작업일", "작업명","금액"};
	private JSpinner jSpinwReserveTime;
	private JDateChooser dchWorkTime;
	private JDateChooser dchReserveTime;
	private JButton btnCancel;

	private JComboBox<Event> cmbEvent;
	private JComboBox<Designer> cmbDesigner;
	private DefaultComboBoxModel<Event> cmbEventModel;
	private DefaultComboBoxModel<Designer> cmbDesignerModel;

	private List<JLabel> productLabel=new ArrayList<JLabel>();
	List<JButton> btnList = new ArrayList<JButton>();
	private JTable table;
	private pHomeProductTable panelProduct;
	private pHomeWorkProductTable panelWorkProduct;
	private List<Product> productList;
	private JLabel lblPriceList;
	private JLabel lblProductList;




	public pHomeFooterDesigner() {

		initComponents();
	}
	private void initComponents() {




		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelData = new JPanel();
		panel.add(panelData, BorderLayout.NORTH);
		panelData.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblgDname = new JLabel("손님");
		panelData.add(lblgDname);
		lblgDname.setHorizontalAlignment(SwingConstants.CENTER);

		tfgName = new JTextField();
		panelData.add(tfgName);
		tfgName.setColumns(10);

		JLabel lbldName = new JLabel("디자이너");
		panelData.add(lbldName);
		lbldName.setHorizontalAlignment(SwingConstants.CENTER);


		cmbDesigner = new JComboBox<Designer>();
		panelData.add(cmbDesigner);

//		tfdName = new JTextField();
//		panelData.add(tfdName);
//		tfdName.setColumns(10);

		JLabel lblwWorkTime = new JLabel("작업완료일");
		panelData.add(lblwWorkTime);
		lblwWorkTime.setHorizontalAlignment(SwingConstants.CENTER);

//		tfwWorkTime = new JTextField();
//		tfwWorkTime.setColumns(10);
//		panel.add(tfwWorkTime);

		jSpinwWorkTime = new JSpinner();
		panelData.add(jSpinwWorkTime);
		jSpinwWorkTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));

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
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		btnUpdate = new JButton("추가");
		btnUpdate.addActionListener(this);
		panel_5.add(btnUpdate);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_5.add(btnCancel);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
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
		panelWorkProduct.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC791\uC5C5\uB9AC\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
	}

	public void setBaseTf(List<Event> event,List<Designer> designer,List<Product> product) {

		cmbEventModel=new DefaultComboBoxModel<Event>(new Vector<Event>(event));
		cmbEvent.setModel(cmbEventModel);
		cmbDesignerModel=new DefaultComboBoxModel<Designer>(new Vector<Designer>(designer));
		cmbDesigner.setModel(cmbDesignerModel);

		panelProduct.setItemList(product);
		panelProduct.reloadData();
		revalidate();
		repaint();
	}

	public void cearTf() {
		lblPriceList.setText("0");
		lblProductList.setText("");
		tfgName.setEnabled(true);
		btnUpdate.setText("추가");
		tfgName.setText("");
		tfpPrice.setText("");
		jSpinwReserveTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		jSpinwWorkTime.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
		cmbDesigner.setSelectedIndex(-1);
		cmbEvent.setSelectedIndex(-1);
		revalidate();
		repaint();
	}
	public void setTfWork(WorkDialog workDialog) {
		btnUpdate.setText("수정");
		cmbDesigner.setSelectedItem(new Designer(workDialog.getwDNo().getdNo()));
		cmbEvent.setSelectedItem(new Event(workDialog.getwEName().geteName()));
		tfgName.setText(workDialog.getwGNo().getgName());
		tfgName.setEnabled(false);
		tfpPrice.setText(workDialog.getwPriceTotal()+"");

		panelWorkProduct.setItemList(workDialog.getProductList());	
		panelWorkProduct.reloadData();
		panelWorkProduct.setBorder(new TitledBorder(null, workDialog.getwGNo().getgName()+"님의 작업리스트", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		Date date= new Date(new Date().getYear(),0,1);

		if(workDialog.getwReserveTime()!=null)
			jSpinwReserveTime.setModel(new SpinnerDateModel(workDialog.getwReserveTime(), null, null, Calendar.HOUR_OF_DAY));
//			dchReserveTime.setDate(workDialog.getwReserveTime());
		if(workDialog.getwWorkTime()!=null)
			jSpinwWorkTime.setModel(new SpinnerDateModel(workDialog.getwWorkTime(), null, null, Calendar.HOUR_OF_DAY));
//			dchWorkTime.setDate(workDialog.getwWorkTime());
		else
			jSpinwWorkTime.setModel(new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY));		


		setTfProductName(workDialog.getProductList());


	}
	public void setTfProductName(List<Product> productList) {
		String pName="";
		for(int i=0; i<productList.size(); i++) {
			if(i!=productList.size()-1) {
				pName+=productList.get(i).getpName()+",";
				continue;
			}
			pName+=productList.get(i).getpName();
		}
//		tfpName.setText(pName);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {

	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		cearTf();
	}
	protected void itemStateChangedCmbProduct(ItemEvent e) {
		String pName=e.getItem().toString();
		JLabel label=new JLabel(pName);
		JButton btn = new JButton("x");
	}
	public void setWorkProduct(Product product) {
		panelWorkProduct.addProduct(product);
		setPriceSub();
	}
	public void setPriceSub() {
		productList = panelWorkProduct.getProductList();
		int price=0;
		String product="";

		for(int i=0; i<productList.size(); i++) {
			if(i==0)
				product=productList.get(i).getpName();
			else {
				product+=","+productList.get(i).getpName();
			}
			price+=productList.get(i).getpPrice();
		}
		lblPriceList.setText(price+"");
		lblProductList.setText(product);
	}
} 