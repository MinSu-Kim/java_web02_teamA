package kr.or.yi.hairshop.panel;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import kr.or.yi.hairshop.dto.Designer;

import javax.swing.JLabel;

public class PanelDesignerScheduleBlock extends JPanel implements MouseListener {
	JTable jtable;
	private JLabel lblDesigner;

	public PanelDesignerScheduleBlock() {
		setLayout(new BorderLayout());
		final String[] columns = { "시간", "작업명"};
		final String[][] data = { { "09:00", "손님1"}, { "10:00", "손님2"}, { "11:00", "손님3"} };

		DefaultTableModel model = new DefaultTableModel(data, columns);

		jtable = new JTable(model);

		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
		jtable.addMouseListener(this);
		JScrollPane spane = new JScrollPane(jtable);
		add(spane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		lblDesigner = new JLabel("디자이너이름");
		panel.add(lblDesigner);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("JTable Test");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelDesignerScheduleBlock jt = new PanelDesignerScheduleBlock();
		f.getContentPane().add(jt);
		f.setSize(300, 200);
		f.setVisible(true);
	}

	public void mouseClicked(MouseEvent me) {
		int row = jtable.getSelectedRow();
		int column = jtable.getSelectedColumn();
		System.out.println(lblDesigner.getText());
		System.out.println(row + "행, " + column + "열 : " + jtable.getValueAt(row, column) + " 선택했음");
		
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public void setDisigner(Designer designer) {
		lblDesigner.setText(designer.getdName());
		
	}
}