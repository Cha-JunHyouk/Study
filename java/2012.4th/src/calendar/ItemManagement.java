package calendar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
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

class DTO {
	private String yyyymmdd;
	private Integer shoes;
	private Integer clothing;
	private Integer accessory;
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

	public Integer getAccessory() {
		return accessory;
	}

	public void setAccessory(Integer accessory) {
		this.accessory = accessory;
	}

	public Integer getFood() {
		return food;
	}

	public void setFood(Integer food) {
		this.food = food;
	}

}

class Database {
	Connection conn;
	PreparedStatement pre;
	ResultSet rs;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String insert = "insert into item_management values(?,?,?,?,?)";
	private String select = "select * from item_management where yyyymmdd=?";

	DTO select(String ymd) {
		DTO dto = new DTO();
		try {
			pre = conn.prepareStatement(select);
			pre.setString(1, ymd);
			rs = pre.executeQuery();
			if (rs.next()) {
				dto.setYyyymmdd(rs.getString("yyyymmdd"));
				dto.setShoes(rs.getInt("shoes"));
				dto.setClothing(rs.getInt("clothing"));
				dto.setAccessory(rs.getInt("accessory"));
				dto.setFood(rs.getInt("food"));
			} else {
				dto = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	boolean insert(DTO dto) {
		boolean flag = false;
		try {
			pre = conn.prepareStatement(insert);
			pre.setString(1, dto.getYyyymmdd());
			pre.setInt(2, dto.getShoes());
			pre.setInt(3, dto.getClothing());
			pre.setInt(4, dto.getAccessory());
			pre.setInt(5, dto.getFood());
			pre.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "hr", "hr");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	void db_disconn() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pre != null) {
				pre.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class BAR extends JPanel {
	private int data1, data2, data3, data4;

	public void setData(int d1, int d2, int d3, int d4) {
		data1 = d1;
		data2 = d2;
		data3 = d3;
		data4 = d4;
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(50, 250, 350, 250);
		for (int i = 0; i < 11; i++) {
			g.drawString(i * 10 + "", 25, 255 - 20 * i);
			g.drawLine(50, 250 - 20 * i, 350, 250 - 20 * i);
		}
		g.drawString("����", 10, 20);
		g.drawLine(50, 20, 50, 250);
		g.drawString("�Ź�", 80, 270);
		g.drawString("��", 140, 270);
		g.drawString("��ű�", 190, 270);
		g.drawString("����", 260, 270);
		g.setColor(Color.orange);
		if (data1 > 0) {
			g.fillRect(80, 250 - data1 * 2, 20, data1 * 2);
		}
		if (data2 > 0) {
			g.fillRect(140, 250 - data2 * 2, 20, data2 * 2);
		}
		if (data3 > 0) {
			g.fillRect(200, 250 - data3 * 2, 20, data3 * 2);
		}
		if (data4 > 0) {
			g.fillRect(260, 250 - data4 * 2, 20, data4 * 2);
		}
	}

}

public class ItemManagement extends JFrame implements ActionListener {
	int[] data = { 0, 0, 0, 0 };// �׷������� ����� ������
	int[] angle = new int[4];// 4���� ������Ʈ�� ����
	Color[] color = { Color.GRAY, Color.BLACK, Color.DARK_GRAY, Color.ORANGE };// 4�� ������Ʈ���� ����� ��
	String[] title = { "�Ź�", "��", "��ű�", "����" };// 4�� ������Ʈ ����

	class PieChart extends JPanel {// Ŭ���� ���� Ŭ���� ����Ŭ����
		// panitComponent
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);// �������� �ȵ�//�г��� ���� �ٽñ׸�
			int startAngle = 0;
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);// �����͸��� �ٸ����� ����
				g.drawString(title[i] + " " + Math.round(angle[i] * 100. / 360.) + "%", 50 + i * 100, 20);
			} // ������ �������� ������ŭ �׸���.
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);// �����͸��� �ٸ����� ����
				g.fillArc(100, 70, 200, 200, startAngle, angle[i]);
				startAngle = startAngle + angle[i];
			} // ������Ʈ�� �������� ������ŭ �׸���
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btn[0]) {
			new CalendarBySwing(this);
		}
		if (o == btn[1]) {
			boolean flag = true;
			if (flag == false) {

				for (int i = 0; i < 5; i++) {
					if (txt[0].getText().equals("")) {
						JOptionPane.showMessageDialog(this, "��¥ �Է�");
						flag = false;
						break;
					}
					if (txt[1].getText().equals("")) {
						JOptionPane.showMessageDialog(this, "�Է�");
						flag = false;
						break;
					}
					if (txt[2].getText().equals("")) {
						JOptionPane.showMessageDialog(this, "�Է�");
						flag = false;
						break;
					}
					if (txt[3].getText().equals("")) {
						JOptionPane.showMessageDialog(this, "�Է�");
						flag = false;
						break;
					}
					if (flag == false) {
						break;
					}
				}
			} else {
				int input = JOptionPane.showConfirmDialog(this, "���� ����Ͻðڽ��ϱ�?");
				if (input == JOptionPane.OK_OPTION) {
					Database db = new Database();
					DTO dto = new DTO();
					if (db.db_conn()) {
						dto.setYyyymmdd(txt[0].getText());
						if (txt[1].getText().equals("")) {
							dto.setShoes(0);
						} else {
							dto.setShoes(Integer.parseInt(txt[1].getText()));
						}
						if (txt[2].getText().equals("")) {
							dto.setClothing(0);
						} else {
							dto.setClothing(Integer.parseInt(txt[2].getText()));
						}
						if (txt[3].getText().equals("")) {
							dto.setAccessory(0);
						} else {
							dto.setAccessory(Integer.parseInt(txt[3].getText()));
						}
						if (txt[4].getText().equals("")) {
							dto.setFood(0);
						} else {
							dto.setFood(Integer.parseInt(txt[4].getText()));
						}

						boolean b = db.insert(dto);
						if (b) {
							JOptionPane.showMessageDialog(this, "��� �Ϸ�");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "��Ͻ���");
						}
					} else {
						JOptionPane.showMessageDialog(this, "db����");
					}
				}
			}

		}
		if (o == btn[2]) {// ��ȸ
			Database db = new Database();
			if (db.db_conn()) {
				DTO dto = db.select(txt[0].getText());
				txt[0].setText(dto.getYyyymmdd());
				txt[1].setText(dto.getShoes() + "");
				txt[2].setText(dto.getClothing() + "");
				txt[3].setText(dto.getAccessory() + "");
				txt[4].setText(dto.getFood() + "");
				bar.setData(dto.getShoes(), dto.getClothing(), dto.getAccessory(), dto.getFood());
				bar.repaint();

				data[0] = dto.getShoes();
				data[1] = dto.getClothing();
				data[2] = dto.getAccessory();
				data[3] = dto.getFood();

				int sum = data[0] + data[1] + data[2] + data[3];
				if (sum == 0) {
					return;
				}
				for (int i = 0; i < data.length; i++) {
					angle[i] = (int) Math.round((double) data[i] / (double) sum * 360);
				}
				pc.repaint();

				db.db_disconn();
			} else {
				JOptionPane.showMessageDialog(this, "db����");
			}
		}
	}

	JButton[] btn;
	String[] btn_name = { "�޷�", "����", "��ȸ" };
	JTextField[] txt;
	JPanel panel;
	JPanel center;
	BAR bar;
	PieChart pc;

	void makebtn() {
		btn = new JButton[btn_name.length];
		for (int i = 0; i < btn_name.length; i++) {
			btn[i] = new JButton(btn_name[i]);
			btn[i].addActionListener(this);
		}
	}

	void maketxt() {
		txt = new JTextField[5];
		for (int i = 0; i < txt.length; i++) {
			txt[i] = new JTextField(8);
		}
		txt[0].setEditable(false);
	}

	void makepanel() {
		panel = new JPanel();

		bar = new BAR();
		pc = new PieChart();
		center = new JPanel();
		center.setLayout(new GridLayout(1, 2));
		center.add(bar);
		center.add(pc);

		panel.add(txt[0]);
		panel.add(btn[0]);
		panel.add(txt[1]);
		panel.add(txt[2]);
		panel.add(txt[3]);
		panel.add(txt[4]);
		panel.add(btn[1]);
		panel.add(btn[2]);
	}

	void makewindow() {
		this.add("Center", center);
		this.add("South", panel);
		this.setBounds(0, 0, 850, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ItemManagement(String name) {
		super(name);
		makebtn();
		maketxt();
		makepanel();
		makewindow();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ItemManagement("ǰ�� ������� �ý���");
	}

}
