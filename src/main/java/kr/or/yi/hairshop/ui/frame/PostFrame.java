package kr.or.yi.hairshop.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.yi.hairshop.dao.PostMapper;
import kr.or.yi.hairshop.dao.PostMapperImpl;
import kr.or.yi.hairshop.dto.Post;

@SuppressWarnings("serial")
public class PostFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JList<String> JList;
	private JButton btnNewButton_1;
	private JTextField textField;
	private PostMapper dao;
	private List<Post> pList;
	private String[] arr_pLists;
	private DesignerFrame designerFrame;
	private JPanel panel;
	private JPanel panel_1;
	
	public PostFrame() {
		dao = new PostMapperImpl();
		pList = null;
		initComponents();
	}
	
	private void initComponents() {
		setTitle("주소 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("'도로명'으로 검색 ex)'성당로', '대명로60길', '국채보상로'");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel.setBounds(12, 10, 377, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 27, 317, 29);
		panel.add(textField);
		textField.setColumns(10);
		javax.swing.UIManager.put("Button.defaultButtonFollowsFocus", true);
		
		btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(332, 27, 80, 29);
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 66, 400, 175);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JList = new JList<>();
		panel_1.add(JList);
		JScrollPane scrollPane = new JScrollPane(JList);
		panel_1.add(scrollPane);
		
		btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(332, 251, 80, 30);
		panel.add(btnNewButton_1);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton | arg0.getSource() == btnNewButton) { //검색
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnNewButton_1) { //확인
			actionPerformedBtnNewButton_1(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) { //검색
		if(textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 주소를 입력하세요.");
		}else {
			Post post = new Post();
			post.setpDoro(textField.getText().trim());
			pList = dao.selectPostBypDoro(post);
			
			if(pList.size() == 0) {
				JOptionPane.showMessageDialog(null, "검색하신 주소가 없습니다.");
				clear();
			}else {
				arrayList(pList.size());
			}
		}
	}
	
	public void arrayList(int size) {
		arr_pLists = new String[size];
		for (int i = 0; i < size ; i++) {
			arr_pLists[i] = pList.get(i).toString();
		}
		JList.setListData(arr_pLists);
	}

	public void clear() {
		textField.setText("");
		arrayList(0);
	}
	
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) { //확인
		setVisible(false);
		String addr = JList.getSelectedValue();
		designerFrame.setAddr(addr);
	}
	
	public void setParent(DesignerFrame parent) {
		designerFrame=parent;
	}
}
























