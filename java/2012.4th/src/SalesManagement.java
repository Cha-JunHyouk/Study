import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

class SalesDB{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection conn; PreparedStatement pstmt;
	String insert = "insert into sales_management values(?,?,?,?,?)";
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
				sales.setShoes(rs.getInt("shoes"));
				sales.setClothing(rs.getInt("clothing"));
				sales.setAccesory(rs.getInt("accesory"));
				sales.setFood(rs.getInt("food"));
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
			pstmt.setInt(2, sales.getShoes());
			pstmt.setInt(3, sales.getClothing());
			pstmt.setInt(4, sales.getAccesory());
			pstmt.setInt(5, sales.getFood());
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
	private Integer shoes;
	private Integer clothing;
	private Integer accesory;
	private Integer food;
	public String getYyyymmdd() {
		return yyyymmdd;
	}
	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}
	public Integer getShoes() {
		return shoes;
	}
	public void setShoes(Integer shoes) {
		this.shoes = shoes;
	}
	public Integer getClothing() {
		return clothing;
	}
	public void setClothing(Integer clothing) {
		this.clothing = clothing;
	}
	public Integer getAccesory() {
		return accesory;
	}
	public void setAccesory(Integer food) {
		this.accesory = accesory;
	}
	public Integer getFood() {
		return food;
	}
	public void setFood(Integer food) {
		this.food = food;
	}
}

public class SalesManagement extends JFrame implements ActionListener{
	int[] data = {0,0,0,0};
	int[] angle = new int[4];
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
	String[] title = {"신발","옷","악세서리","음식"};
	class PieChart extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int startAngle = 0;
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);
				g.drawString(title[i]+" "+
						Math.round(angle[i]*100./360.)+"%", 
						50 + i * 100, 20);
			}
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, angle[i]);
				startAngle = startAngle + angle[i];
			}
		}
	}
	
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
				if(y == JOptionPane.OK_OPTION) {
					Sales sales = new Sales();
					sales.setYyyymmdd(input.getText());
					if(shoes.getText().equals("")) {
						sales.setShoes(0);
					}else {
						sales.setShoes(
							Integer.parseInt(shoes.getText()));
					}
					if(clothing.getText().equals("")) {
						sales.setClothing(0);
					}else {
						sales.setClothing(
							Integer.parseInt(clothing.getText()));
					}
					if(accesory.getText().equals("")) {
						sales.setAccesory(0);
					}else {
						sales.setAccesory(
							Integer.parseInt(accesory.getText()));
					}
					if(food.getText().equals("")) {
						sales.setAccesory(0);
					}else {
						sales.setAccesory(
								Integer.parseInt(food.getText()));
					}
					SalesDB db = new SalesDB();
					boolean yn = false;
					if(db.db_conn()) {
						yn = db.insert(sales);
						db.db_disconn();
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
						shoes.setText(sales.getShoes()+"");
						clothing.setText(sales.getClothing()+"");
						accesory.setText(sales.getAccesory()+"");
						food.setText(sales.getFood()+"");
						bc.setData(sales.getShoes(),
								sales.getClothing(),
								sales.getAccesory(),
								sales.getFood());
						bc.repaint();
						data[0] = sales.getShoes();
						data[1] = sales.getClothing();
						data[2] = sales.getAccesory();
						data[3] = sales.getFood();
						int sum = data[0] + data[1] + data[2] + data[3];
						if(sum == 0) return;
						for(int i=0; i<data.length; i++) {
							angle[i]=(int)Math.round(
								(double)data[i]/(double)sum * 360);
						}
						pc.repaint();

					}
					db.db_disconn();
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB와 접속되지 않았습니다.");
				}
			}
		}
	}
	JPanel pan; JButton btn; public JTextField input;
	JButton save, select; JTextField shoes, clothing, accesory, food;
	BarChart bc; PieChart pc; JPanel center;
	public SalesManagement(String str) {
		super(str);
		btn = new JButton(" 달력 "); btn.addActionListener(this);
		input = new JTextField(10); input.setEditable(false);
		save = new JButton(" 저장 "); 
		select = new JButton(" 조회 ");
		save.addActionListener(this);
		select.addActionListener(this);
		shoes = new JTextField(5);
		clothing = new JTextField(5);
		accesory = new JTextField(5);
		food = new JTextField(5);
		pan = new JPanel(); bc = new BarChart(); pc = new PieChart();
		pan.add(input); pan.add(btn);
		pan.add(shoes); pan.add(clothing); pan.add(accesory); pan.add(food);
		pan.add(save); pan.add(select);
		center = new JPanel(); center.setLayout(new GridLayout(1,2)); 
		center.add(bc); center.add(pc);
		this.add("Center", center);
		this.add("South", pan);
		this.setBounds(200, 100, 1000, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		new SalesManagement("매출 관리 시스템 ver1.0");
	}
}
class BarChart extends JPanel{
	private int data1,data2,data3,data4;
	public void setData(int d1, int d2, int d3, int d4) {
		data1 = d1; data2 = d2; data3 = d3; data4 = d4;
	}
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		//그래프를 그리기 전에 패널의 내용을 지운다.
		g.drawLine(50, 250, 450, 250);
		for(int cnt=1; cnt<11; cnt++) {
			g.drawString(cnt*10+"", 25, 255-20*cnt);
			g.drawLine(50, 250-20*cnt, 450, 250-20*cnt);
		}
		g.drawLine(50, 20, 50, 250);
		g.drawString("신발", 100, 270);
		g.drawString("의류", 200, 270);
		g.drawString("장신구", 300, 270);
		g.drawString("음식", 400, 270);
		g.setColor(Color.RED);
		if(data1 > 0) {
			g.fillRect(110, 250-data1*2, 10, data1*2);
		}
		if(data2 > 0) {
			g.fillRect(210, 250-data2*2, 10, data2*2);
		}
		if(data3 > 0) {
			g.fillRect(310, 250-data3*2, 10, data3*2);
		}
		if(data4 > 0) {
			g.fillRect(410, 250-data4*2, 10, data4*2);
		}
	}
}





























