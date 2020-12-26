import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SalesDB{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection conn; PreparedStatement pstmt;
	String insert = "insert into sales_management values(?,?,?,?)";
	String select = "select * from sales_management where yyyymmdd=?";
	ResultSet rs;	
	Sales select(String ymd) {
		Sales sales = new Sales();
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, ymd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sales.setYyyymmdd(rs.getString("yyyymmdd"));
				sales.setMorning(rs.getInt("morning"));
				sales.setAfternoon(rs.getInt("afternoon"));
				sales.setEvening(rs.getInt("evening"));
			}else {
				sales = null;
			}
		}catch(Exception e) {}
		return sales;
	}
	boolean insert(Sales sales){
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, sales.getYyyymmdd());
			pstmt.setInt(2, sales.getMorning());
			pstmt.setInt(3, sales.getAfternoon());
			pstmt.setInt(4, sales.getEvening());
			pstmt.executeUpdate();//DB에 삽입
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
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
}

class Sales {
	private String yyyymmdd;
	private Integer morning;
	private Integer afternoon;
	private Integer evening;
	public String getYyyymmdd() {
		return yyyymmdd;
	}
	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}
	public Integer getMorning() {
		return morning;
	}
	public void setMorning(Integer morning) {
		this.morning = morning;
	}
	public Integer getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(Integer afternoon) {
		this.afternoon = afternoon;
	}
	public Integer getEvening() {
		return evening;
	}
	public void setEvening(Integer evening) {
		this.evening = evening;
	}
}

public class SalesManagement extends JFrame implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btn) {
			new CalendarBySwing(this);
		}else if(obj == save) {
			if(input.getText().equals("")) {
				JOptionPane.showMessageDialog(this, 
					"날짜는 반드시 선택해야 합니다.");
			}else {
				int y = JOptionPane.showConfirmDialog(this, 
					"정말로 저장하시겠습니까?");
				if(y == JOptionPane.OK_OPTION) {//OK를 선택한 경우
					Sales sales = new Sales();//DTO생성
					sales.setYyyymmdd(input.getText());
					if(morning.getText().equals("")) {//입력이 안된경우
						sales.setMorning(0);
					}else {//입력이 된경우
						sales.setMorning(
							Integer.parseInt(morning.getText()));
					}
					if(afternoon.getText().equals("")) {
						sales.setAfternoon(0);
					}else {
						sales.setAfternoon(
							Integer.parseInt(afternoon.getText()));
					}
					if(evening.getText().equals("")) {
						sales.setEvening(0);
					}else {
						sales.setEvening(
							Integer.parseInt(evening.getText()));
					}
					SalesDB db = new SalesDB();
					boolean yn = false;
					if(db.db_conn()) {
						yn = db.insert(sales);//DB에 삽입
						db.db_disconn();//DB와 접속 해제
					}
					if(yn) {
						JOptionPane.showMessageDialog(this, 
							"매출정보가 등록되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"매출정보 등록에 문제가 발생했습니다.");
					}
				}
			}
		}else if(obj == select) {
			if(input.getText().equals("")) {
				JOptionPane.showMessageDialog(this, 
					"조회할 날짜를 선택하세요.");
			}else {
				SalesDB db = new SalesDB();
				if(db.db_conn()) {
					Sales sales = db.select(input.getText());
					if(sales == null) {
						JOptionPane.showMessageDialog(this, 
							"조회된 결과가 존재하지 않습니다.");
					}else {
						input.setText(sales.getYyyymmdd());
						morning.setText(sales.getMorning()+"");
						afternoon.setText(sales.getAfternoon()+"");
						evening.setText(sales.getEvening()+"");
					//매출데이터는 숫자이므로 문자열로 바꿔서 출력한다.
					}
					db.db_disconn();//DB와 접속 해제
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB와 접속되지 않았습니다.");
				}
			}
		}
	}
	JPanel pan; JButton btn; JTextField input;
	JButton save, select; JTextField morning,afternoon,evening;
	public SalesManagement(String str) {
		super(str);
		btn = new JButton(" 달력 "); btn.addActionListener(this);
		input = new JTextField(10); input.setEditable(false);
		save = new JButton(" 저장 "); 
		select = new JButton(" 조회 ");
		save.addActionListener(this);
		select.addActionListener(this);
		morning = new JTextField(5);
		afternoon = new JTextField(5);
		evening = new JTextField(5);
		pan = new JPanel();
		pan.add(input); pan.add(btn);
		pan.add(morning); pan.add(afternoon); pan.add(evening);
		pan.add(save); pan.add(select);
		this.add("South", pan);
		this.setBounds(200, 100, 600, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SalesManagement("매출 관리 시스템 ver1.0");
	}
}







