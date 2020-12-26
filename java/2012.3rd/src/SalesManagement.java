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
			pstmt.executeUpdate();//DB�� ����
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
					"��¥�� �ݵ�� �����ؾ� �մϴ�.");
			}else {
				int y = JOptionPane.showConfirmDialog(this, 
					"������ �����Ͻðڽ��ϱ�?");
				if(y == JOptionPane.OK_OPTION) {//OK�� ������ ���
					Sales sales = new Sales();//DTO����
					sales.setYyyymmdd(input.getText());
					if(morning.getText().equals("")) {//�Է��� �ȵȰ��
						sales.setMorning(0);
					}else {//�Է��� �Ȱ��
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
						yn = db.insert(sales);//DB�� ����
						db.db_disconn();//DB�� ���� ����
					}
					if(yn) {
						JOptionPane.showMessageDialog(this, 
							"���������� ��ϵǾ����ϴ�.");
					}else {
						JOptionPane.showMessageDialog(this, 
							"�������� ��Ͽ� ������ �߻��߽��ϴ�.");
					}
				}
			}
		}else if(obj == select) {
			if(input.getText().equals("")) {
				JOptionPane.showMessageDialog(this, 
					"��ȸ�� ��¥�� �����ϼ���.");
			}else {
				SalesDB db = new SalesDB();
				if(db.db_conn()) {
					Sales sales = db.select(input.getText());
					if(sales == null) {
						JOptionPane.showMessageDialog(this, 
							"��ȸ�� ����� �������� �ʽ��ϴ�.");
					}else {
						input.setText(sales.getYyyymmdd());
						morning.setText(sales.getMorning()+"");
						afternoon.setText(sales.getAfternoon()+"");
						evening.setText(sales.getEvening()+"");
					//���ⵥ���ʹ� �����̹Ƿ� ���ڿ��� �ٲ㼭 ����Ѵ�.
					}
					db.db_disconn();//DB�� ���� ����
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB�� ���ӵ��� �ʾҽ��ϴ�.");
				}
			}
		}
	}
	JPanel pan; JButton btn; JTextField input;
	JButton save, select; JTextField morning,afternoon,evening;
	public SalesManagement(String str) {
		super(str);
		btn = new JButton(" �޷� "); btn.addActionListener(this);
		input = new JTextField(10); input.setEditable(false);
		save = new JButton(" ���� "); 
		select = new JButton(" ��ȸ ");
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
		new SalesManagement("���� ���� �ý��� ver1.0");
	}
}







