package senior;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
class ImageItemDB {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection conn; PreparedStatement pstmt;
	String insert = "insert into kosea_hrd values(?,?,?,?,?,?)";
	String select = "select * from kosea_hrd where code=?";
	ResultSet rs;	
	ImageItem select(String code) {//code�� �Էµ� ��ȣ�� ��ȸ
		//��ȸ����� �ִ� 1��, ��? ��ǰ�ڵ�� ��ǰ���� �ٸ��Ƿ�
		ImageItem dto = new ImageItem();//DTO����
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, code);//ù��° ����ǥ�� ��ǰ�ڵ� ����
			rs = pstmt.executeQuery();//DB���� ��ǰ�ڵ�� ��ȸ
			if(rs.next()) {//��ȸ ����� �̵��� �Ǹ�, ����� ������
				dto.setCode(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setIntro(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				dto.setOrigin(rs.getString(5));
				dto.setPath(rs.getString(6));
			}else {//��ȸ ����� �̵��� �ȵǸ�, ��ȸ����� ����
				dto = null;//��ȸ����� �����Ƿ�, dto��ü�� ���� ����
			}
		}catch(Exception e) {	}
		return dto;
	}
	boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			flag = true;
		}catch(Exception e) {}
		return flag;
	}
	void db_disconn() {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
	boolean insert(ImageItem ii) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, ii.getCode());
			pstmt.setString(2, ii.getName());
			pstmt.setString(3, ii.getIntro());
			pstmt.setInt(4, ii.getPrice());
			pstmt.setString(5, ii.getOrigin());
			pstmt.setString(6, ii.getPath());
			pstmt.executeUpdate();//DB�� ����
			flag = true;//���� ������ �ǹ�
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
class ImageItem{
	private String code;
	private String name;
	private String intro;
	private Integer price;
	private String origin;
	private String path;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}

public class ImageItemSystem extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//��Ϲ�ư�� ���� ���
			//�Էµ��� ���� �׸��� �ִ��� �˻�
			//��ǰ�ڵ�inputs[0],�̸�inputs[1],����inputs[2],
			//������inputs[4]
			boolean flag = true;//false:������ �׸��� ����,true:����
			for(int i=0; i<5; i++) {//��ǰ�ڵ�,�̸�,���� �˻�
				if(i == 3) continue;//�����ݺ� ��, i=4�� ����
				if(inputs[i].getText().equals("")) {
					JOptionPane.showMessageDialog(this, 
						titles[i]+"�׸� �����Ͱ� �־�� �մϴ�.");
					flag = false;
					break;
				}
			}
			if(flag == true) {//��� �׸� �����Ͱ� �Էµ� ���
				int r = JOptionPane.showConfirmDialog(this, 
							"������ �����Ͻðڽ��ϱ�?");
				if(r == JOptionPane.OK_OPTION) {
					ImageItemDB db = new ImageItemDB();
					ImageItem dto = new ImageItem();//DTO����
					dto.setCode(inputs[0].getText());//��ǰ�ڵ弳��
					dto.setName(inputs[1].getText());//�̸�����
					dto.setPrice(Integer.parseInt(inputs[2].getText()));
					dto.setIntro(inputs[3].getText());//��ǰ�Ұ�����
					dto.setOrigin(inputs[4].getText());//����������
					dto.setPath(inputs[5].getText());//�̹������ϸ�
					if(db.db_conn()) {
						boolean y=db.insert(dto);//DB�� ����
						if(y) JOptionPane.showMessageDialog(this, 
								"��ǰ�� ��ϵǾ����ϴ�.");
						else JOptionPane.showMessageDialog(this, 
								"��ǰ�� ��ϵ��� �ʾҽ��ϴ�.");
						db.db_disconn();//DB���� ����
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB�� ������� �ʾҽ��ϴ�.");
					}
				}
			}
		}else if(obj == btns[1]) {//��ȸ��ư�� ���� ���
			if(inputs[0].getText().equals("")) {
				JOptionPane.showMessageDialog(this, 
					"��ǰ��ȣ�� �ԷµǾ�� �մϴ�.");
			}else {
				ImageItemDB db = new ImageItemDB();
				if(db.db_conn()) {
					ImageItem dto = db.select(inputs[0].getText());
					if(dto == null) {//��ȸ����� ���� ���
						JOptionPane.showMessageDialog(this, 
							"��ȸ ����� �������� �ʽ��ϴ�.");
					}else {//��ȸ����� �ִ� ���
						inputs[0].setText(dto.getCode());
						inputs[1].setText(dto.getName());
						inputs[2].setText(dto.getPrice()+"");
						inputs[3].setText(dto.getIntro());
						inputs[4].setText(dto.getOrigin());
						inputs[5].setText(dto.getPath());
						centerPanel.setPath(dto.getPath());
						System.out.println(dto.getPath());
						centerPanel.repaint();//�̹����г� ����
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB�� ������� �ʾҽ��ϴ�.");
				}
			}
		}else if(obj == btns[2]) {//�̹��� �ε� ��ư�� ���� ���
			fd = new FileDialog(this,"�̹��� �ε�",FileDialog.LOAD);
			fd.setVisible(true);
			String path=fd.getDirectory()+fd.getFile();
			inputs[5].setText(path);//������° �ؽ�Ʈ�ʵ忡 ������
			centerPanel.setPath(path);
			centerPanel.repaint();
		}
	}
	FileDialog fd;
	String[] titles = {"��ǰ�ڵ�","��ǰ�̸�","��ǰ����","��ǰ�Ұ�",
			"������","�̹���"};
	String[] btnTitles = {" ��ǰ ��� "," ��ǰ ��ȸ ","�̹��� �ε�"};
	JLabel[] lbls; JTextField[] inputs; JButton[] btns;
	LoadImage centerPanel; 
	JPanel leftPanel, southPanel; JPanel[] pans;
	void makeWindow() {
		this.add("West",leftPanel);
		this.add("South",southPanel);
		this.add("Center",centerPanel);
		this.setBounds(200, 100, 700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		centerPanel = new LoadImage();
		leftPanel = new JPanel(); 
		leftPanel.setLayout(new GridLayout(7,1));//7�� 1��
		southPanel = new JPanel();//��ư�� �г�
		southPanel.add(btns[0]);southPanel.add(btns[1]);
		pans = new JPanel[7];//�г�7���� ���� �迭 ����
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			switch(i) {
			case 6 : pans[i].add(btns[2]);//������ �гο� �̹����ε��ư
					break;
			default : pans[i].add(lbls[i]);
					  pans[i].add(inputs[i]);
			}
			leftPanel.add(pans[i]);//7�� �г��� leftPanel�� ��´�.
		}
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
		}
	}
	void makeTextField() {
		inputs = new JTextField[titles.length];
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new JTextField(15);
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	public ImageItemSystem(String str) {
		super(str);
		makeLabel(); makeTextField(); makeButton(); makePanel();
		makeWindow();
	}
	public static void main(String[] args) {
		new ImageItemSystem("��ǰ���� �ý��� ver2.0");
	}

}











