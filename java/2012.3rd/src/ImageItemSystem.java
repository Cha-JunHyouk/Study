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
	ImageItem select(String code) {//code에 입력된 번호로 조회
		//조회결과는 최대 1건, 왜? 상품코드는 상품마다 다르므로
		ImageItem dto = new ImageItem();//DTO생성
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, code);//첫번째 물음표에 상품코드 설정
			rs = pstmt.executeQuery();//DB에서 상품코드로 조회
			if(rs.next()) {//조회 결과로 이동이 되면, 결과가 존재함
				dto.setCode(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setIntro(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				dto.setOrigin(rs.getString(5));
				dto.setPath(rs.getString(6));
			}else {//조회 결과로 이동이 안되면, 조회결과가 없슴
				dto = null;//조회결과가 없으므로, dto객체에 널을 설정
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
			pstmt.executeUpdate();//DB에 삽입
			flag = true;//삽입 성공을 의미
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
		if(obj == btns[0]) {//등록버튼을 누른 경우
			//입력되지 않은 항목이 있는지 검사
			//상품코드inputs[0],이름inputs[1],가격inputs[2],
			//원산지inputs[4]
			boolean flag = true;//false:누락된 항목이 있음,true:없슴
			for(int i=0; i<5; i++) {//상품코드,이름,가격 검사
				if(i == 3) continue;//다음반복 즉, i=4로 진행
				if(inputs[i].getText().equals("")) {
					JOptionPane.showMessageDialog(this, 
						titles[i]+"항목에 데이터가 있어야 합니다.");
					flag = false;
					break;
				}
			}
			if(flag == true) {//모든 항목에 데이터가 입력된 경우
				int r = JOptionPane.showConfirmDialog(this, 
							"정말로 저장하시겠습니까?");
				if(r == JOptionPane.OK_OPTION) {
					ImageItemDB db = new ImageItemDB();
					ImageItem dto = new ImageItem();//DTO생성
					dto.setCode(inputs[0].getText());//상품코드설정
					dto.setName(inputs[1].getText());//이름설정
					dto.setPrice(Integer.parseInt(inputs[2].getText()));
					dto.setIntro(inputs[3].getText());//상품소개설정
					dto.setOrigin(inputs[4].getText());//원산지설정
					dto.setPath(inputs[5].getText());//이미지파일명
					if(db.db_conn()) {
						boolean y=db.insert(dto);//DB에 삽입
						if(y) JOptionPane.showMessageDialog(this, 
								"상품이 등록되었습니다.");
						else JOptionPane.showMessageDialog(this, 
								"상품이 등록되지 않았습니다.");
						db.db_disconn();//DB접속 해제
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB와 연결되지 않았습니다.");
					}
				}
			}
		}else if(obj == btns[1]) {//조회버튼을 누른 경우
			if(inputs[0].getText().equals("")) {
				JOptionPane.showMessageDialog(this, 
					"상품번호가 입력되어야 합니다.");
			}else {
				ImageItemDB db = new ImageItemDB();
				if(db.db_conn()) {
					ImageItem dto = db.select(inputs[0].getText());
					if(dto == null) {//조회결과가 없는 경우
						JOptionPane.showMessageDialog(this, 
							"조회 결과가 존재하지 않습니다.");
					}else {//조회결과가 있는 경우
						inputs[0].setText(dto.getCode());
						inputs[1].setText(dto.getName());
						inputs[2].setText(dto.getPrice()+"");
						inputs[3].setText(dto.getIntro());
						inputs[4].setText(dto.getOrigin());
						inputs[5].setText(dto.getPath());
						centerPanel.setPath(dto.getPath());
						System.out.println(dto.getPath());
						centerPanel.repaint();//이미지패널 갱신
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB와 연결되지 않았습니다.");
				}
			}
		}else if(obj == btns[2]) {//이미지 로드 버튼을 누른 경우
			fd = new FileDialog(this,"이미지 로드",FileDialog.LOAD);
			fd.setVisible(true);
			String path=fd.getDirectory()+fd.getFile();
			inputs[5].setText(path);//여섯번째 텍스트필드에 경로출력
			centerPanel.setPath(path);
			centerPanel.repaint();
		}
	}
	FileDialog fd;
	String[] titles = {"상품코드","상품이름","상품가격","상품소개",
			"원산지","이미지"};
	String[] btnTitles = {" 상품 등록 "," 상품 조회 ","이미지 로드"};
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
		leftPanel.setLayout(new GridLayout(7,1));//7행 1열
		southPanel = new JPanel();//버튼용 패널
		southPanel.add(btns[0]);southPanel.add(btns[1]);
		pans = new JPanel[7];//패널7개를 위한 배열 생성
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			switch(i) {
			case 6 : pans[i].add(btns[2]);//마지막 패널에 이미지로드버튼
					break;
			default : pans[i].add(lbls[i]);
					  pans[i].add(inputs[i]);
			}
			leftPanel.add(pans[i]);//7개 패널을 leftPanel에 담는다.
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
		new ImageItemSystem("상품관리 시스템 ver2.0");
	}

}











