package calendar;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class SalesDTO {
	private String yyyymmdd;
	private Integer morning;
	private Integer afternoon;
	private Integer evening;
	private Integer total;

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}

class SalesDB {
	Connection conn;
	PreparedStatement pre;
	ResultSet rs;
	ResultSet rs1;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String insert = "insert into sales_system values(?,?,?,?,?)";
	private String select = "select * from sales_system where yyyymmdd=?";
	private String select1 = "select * from sales_system where 2=2";
	private String delete = "delete from sales_system where 2=2";
	private String update = "update sales_system set morning=?, afternoon=?, evening=?, total=? where yyyymmdd=?";

	boolean update(SalesDTO dto) {
		boolean flag = true;
		try {
			pre = conn.prepareStatement(update);
			pre.setInt(1, dto.getMorning());
			pre.setInt(2, dto.getAfternoon());
			pre.setInt(3, dto.getEvening());
			pre.setInt(4, dto.getTotal());
			pre.setString(5, dto.getYyyymmdd());
			pre.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	boolean delete(SalesDTO dto) {
		boolean flag = false;
		try {
			if (!dto.getYyyymmdd().equals("")) {
				delete = delete + " and yyyymmdd='" + dto.getYyyymmdd() + "'";
			}
			if (dto.getMorning() != null) {
				delete = delete + " and morning=" + dto.getMorning();
			}
			if (dto.getAfternoon() != null) {
				delete = delete + " and afternoon=" + dto.getAfternoon();
			}
			if (dto.getEvening() != null) {
				delete = delete + " and evening=" + dto.getEvening();
			}
			if (dto.getTotal() != null) {
				delete = delete + " and total=" + dto.getTotal();
			}
			pre = conn.prepareStatement(delete);
			pre.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	ResultSet select2() {
		try {
			pre = conn.prepareStatement(select1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs1 = pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs1;
	}

	ResultSet select1() {
		try {
			pre = conn.prepareStatement(select1);
			rs = pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	SalesDTO select(String ymd) {
		SalesDTO sales = new SalesDTO();
		try {
			pre = conn.prepareStatement(select);
			pre.setString(1, ymd);
			rs = pre.executeQuery();
			if (rs.next()) {
				sales.setYyyymmdd(rs.getString("yyyymmdd"));
				sales.setMorning(rs.getInt("morning"));
				sales.setAfternoon(rs.getInt("afternoon"));
				sales.setEvening(rs.getInt("evening"));
				sales.setTotal(rs.getInt("total"));
			} else {
				sales = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sales;
	}

	boolean insert(SalesDTO dto) {
		boolean flag = false;
		try {
			pre = conn.prepareStatement(insert);
			pre.setString(1, dto.getYyyymmdd());
			pre.setInt(2, dto.getMorning());
			pre.setInt(3, dto.getAfternoon());
			pre.setInt(4, dto.getEvening());
			pre.setInt(5, dto.getTotal());
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

public class SalesSystem extends JFrame implements ActionListener {

	int[] data = { 0, 0, 0 };// �׷������� ����� ������
	int[] angle = new int[3];// 4���� ������Ʈ�� ����
	Color[] color = { Color.GRAY, Color.BLACK, Color.DARK_GRAY };// 4�� ������Ʈ���� ����� ��
	String[] title = { "����", "����", "����" };// 4�� ������Ʈ ����

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
		if (o == btn) {
			new CalendarBySwing(this);

		}
		if (o == save) {
			if (txt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��¥�� �������ּ���");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "���� ����?");
				if (input == JOptionPane.OK_OPTION) {
					SalesDB db = new SalesDB();
					SalesDTO dto = new SalesDTO();
					dto.setYyyymmdd(txt.getText());
					if (morning.getText().equals("")) {// �Է� �ȵ� ���
						dto.setMorning(0);
					} else {// �Է��� �� ���
						dto.setMorning(Integer.parseInt(morning.getText()));
					}
					if (afternoon.getText().equals("")) {
						dto.setAfternoon(0);
					} else {
						dto.setAfternoon(Integer.parseInt(afternoon.getText()));
					}
					if (evening.getText().equals("")) {
						dto.setEvening(0);
					} else {
						dto.setEvening(Integer.parseInt(evening.getText()));
					}
					int total = 0;
					total = total + Integer.parseInt(morning.getText()) + Integer.parseInt(afternoon.getText())
							+ Integer.parseInt(evening.getText());
					dto.setTotal(total);
					if (db.db_conn()) {
						boolean b = db.insert(dto);
						if (b) {
							JOptionPane.showMessageDialog(this, "���� ����");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "���� ����");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdb����");
					}
				}
			}
		}
		if (o == select) {
			SalesDB db = new SalesDB();

			if (db.db_conn()) {
				SalesDTO dto = db.select(txt.getText());
				if (dto == null) {
					JOptionPane.showMessageDialog(this, "��ȸ�� ��� ����");
				} else {
					txt.setText(dto.getYyyymmdd());
					morning.setText(dto.getMorning() + "");
					afternoon.setText(dto.getAfternoon() + "");
					evening.setText(dto.getEvening() + "");

					// ���� �����ϴ� �����̹Ƿ� ���ڿ��� �ٲ㼭 ����Ѵ�.
					bc.setDate(dto.getMorning(), dto.getAfternoon(), dto.getEvening());
					bc.repaint();// ���� �׷��� �׸���
					////// ���� ��Ʈ �׸��� ����
					data[0] = dto.getMorning();
					data[1] = dto.getAfternoon();
					data[2] = dto.getEvening();
					int sum = data[0] + data[1] + data[2];
					if (sum == 0) {// �����Ͱ� ������ �޼��� ����
						return;
					}
					for (int i = 0; i < data.length; i++) {
						angle[i] = (int) Math.round((double) data[i] / (double) sum * 360);
					}
					pc.repaint();
				}
				db.db_disconn();
			} else {
				JOptionPane.showMessageDialog(this, "dbdbdb");
			}

		}
		if (o == cancel) {
			txt.setText("");
			morning.setText("");
			afternoon.setText("");
			evening.setText("");
		}
		if (o == update) {
			if (txt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��¥�� �������ּ���");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?");
				if (input == JOptionPane.OK_OPTION) {
					SalesDB db = new SalesDB();
					SalesDTO dto = new SalesDTO();
					if (db.db_conn()) {
						dto.setYyyymmdd(txt.getText());
						dto.setMorning(Integer.parseInt(morning.getText()));
						dto.setAfternoon(Integer.parseInt(afternoon.getText()));
						dto.setEvening(Integer.parseInt(evening.getText()));
						int total = 0;
						total = total + Integer.parseInt(morning.getText()) + Integer.parseInt(afternoon.getText())
								+ Integer.parseInt(evening.getText());
						dto.setTotal(total);
						boolean b = db.update(dto);
						if (b) {
							JOptionPane.showMessageDialog(this, "���� �Ϸ�");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "���� ����");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdb����");
					}
				}
			}
		}
		if (o == delete) {
			if (txt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��¥�� �������ּ���");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?");
				if (input == JOptionPane.OK_OPTION) {
					SalesDB db = new SalesDB();
					SalesDTO dto = new SalesDTO();
					if (db.db_conn()) {
						dto.setYyyymmdd(txt.getText());
						boolean b = db.delete(dto);
						if (b) {
							JOptionPane.showMessageDialog(this, "���� �Ϸ�");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "���� ����");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdbdb����");
					}
				}
			}
		}
	}

	PieChart pc;
	JPanel center;

	JTable table;
	JScrollPane scroll;
	JButton btn;
	JPanel panel;
	JTextField txt;
	JButton save, select, cancel, delete, update;
	JTextField morning, afternoon, evening;
	BarChart bc;

	public SalesSystem(String name) {
		super(name);
		btn = new JButton("�޷�");
		btn.addActionListener(this);

		save = new JButton("����");
		save.addActionListener(this);

		select = new JButton("��ȸ");
		select.addActionListener(this);

		cancel = new JButton("�ʱ�ȭ");
		cancel.addActionListener(this);

		delete = new JButton("����");
		delete.addActionListener(this);

		update = new JButton("����");
		update.addActionListener(this);

		txt = new JTextField(10);
		txt.setEditable(false);

		morning = new JTextField(5);
		afternoon = new JTextField(5);
		evening = new JTextField(5);

		panel = new JPanel();
		panel.add(txt);
		panel.add(btn);
		panel.add(morning);
		panel.add(afternoon);
		panel.add(evening);
		panel.add(save);
		panel.add(select);
		panel.add(new JLabel("                          "));
		panel.add(cancel);
		panel.add(update);
		panel.add(delete);

		pc = new PieChart();
		bc = new BarChart();

		center = new JPanel();
		center.setLayout(new GridLayout(1, 2));
		center.add(bc);// ������Ʈ
		center.add(pc);// ������Ʈ

		this.add("Center", center);
		this.add("South", panel);
		this.setBounds(200, 0, 800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SalesSystem("������� �ý���");
	}

	class BarChart extends JPanel {
		private int data1, data2, data3;

		public void setDate(int d1, int d2, int d3) {
			data1 = d1;
			data2 = d2;
			data3 = d3;
		}// ����׷����� ���� ������ 3���� ���޹޴´�

		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			// �׷����� �׸��� ���� �г��� ������ �����
			g.drawLine(50, 250, 350, 250);// ������ �׸���
			for (int i = 1; i < 11; i++) {
				g.drawString(i * 10 + "", 25, 255 - 20 * i);// ���� ����,x,y
				g.drawLine(50, 250 - 20 * i, 350, 250 - 20 * i);// ����
			} // ������ ���� 10���� �׸���
			g.drawString("��(��)", 10, 20);
			g.drawLine(50, 20, 50, 250);// �������� �׸���.
			g.setColor(Color.BLACK);
			g.drawString("����", 100, 270);// ù ��° ����׷����� ����
			g.drawString("����", 200, 270);// �� ��° ����׷����� ����
			g.drawString("����", 300, 270);// �� ��° ����׷����� ����
			g.setColor(Color.ORANGE);
			if (data1 > 0) {// ����׷���
				g.fillRect(110, 250 - data1 * 2, 10, data1 * 2);
				// x y �α� ����
			}
			if (data2 > 0) {
				g.fillRect(210, 250 - data2 * 2, 10, data2 * 2);
			}
			if (data3 > 0) {
				g.fillRect(310, 250 - data3 * 2, 10, data3 * 2);
			}
		}

	}
}
