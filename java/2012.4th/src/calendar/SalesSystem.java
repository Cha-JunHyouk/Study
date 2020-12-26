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

	int[] data = { 0, 0, 0 };// 그래프에서 사용할 데이터
	int[] angle = new int[3];// 4개의 파이차트의 각도
	Color[] color = { Color.GRAY, Color.BLACK, Color.DARK_GRAY };// 4개 파이차트에서 사용할 색
	String[] title = { "오전", "오후", "저녁" };// 4개 파이차트 제목

	class PieChart extends JPanel {// 클래스 안의 클래스 내부클래스
		// panitComponent
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);// 빼먹으면 안됨//패널을 갱신 다시그림
			int startAngle = 0;
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);// 데이터마다 다른색을 지정
				g.drawString(title[i] + " " + Math.round(angle[i] * 100. / 360.) + "%", 50 + i * 100, 20);
			} // 제목을 데이터의 갯수만큼 그린다.
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);// 데이터마다 다른색을 지정
				g.fillArc(100, 70, 200, 200, startAngle, angle[i]);
				startAngle = startAngle + angle[i];
			} // 파이차트를 데이터의 갯수만큼 그린다
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
				JOptionPane.showMessageDialog(this, "날짜를 선택해주세요");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "정말 저장?");
				if (input == JOptionPane.OK_OPTION) {
					SalesDB db = new SalesDB();
					SalesDTO dto = new SalesDTO();
					dto.setYyyymmdd(txt.getText());
					if (morning.getText().equals("")) {// 입력 안된 경우
						dto.setMorning(0);
					} else {// 입력이 된 경우
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
							JOptionPane.showMessageDialog(this, "저장 성공");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "저장 실패");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdb오류");
					}
				}
			}
		}
		if (o == select) {
			SalesDB db = new SalesDB();

			if (db.db_conn()) {
				SalesDTO dto = db.select(txt.getText());
				if (dto == null) {
					JOptionPane.showMessageDialog(this, "조회된 결과 없음");
				} else {
					txt.setText(dto.getYyyymmdd());
					morning.setText(dto.getMorning() + "");
					afternoon.setText(dto.getAfternoon() + "");
					evening.setText(dto.getEvening() + "");

					// 매출 데이턴는 숫자이므로 문자열로 바꿔서 출력한다.
					bc.setDate(dto.getMorning(), dto.getAfternoon(), dto.getEvening());
					bc.repaint();// 막대 그래프 그리기
					////// 파이 차트 그리기 시작
					data[0] = dto.getMorning();
					data[1] = dto.getAfternoon();
					data[2] = dto.getEvening();
					int sum = data[0] + data[1] + data[2];
					if (sum == 0) {// 데이터가 없으면 메서드 종료
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
				JOptionPane.showMessageDialog(this, "날짜를 선택해주세요");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?");
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
							JOptionPane.showMessageDialog(this, "수정 완료");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "수정 실패");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdb오류");
					}
				}
			}
		}
		if (o == delete) {
			if (txt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "날짜를 선택해주세요");
			} else {
				int input = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?");
				if (input == JOptionPane.OK_OPTION) {
					SalesDB db = new SalesDB();
					SalesDTO dto = new SalesDTO();
					if (db.db_conn()) {
						dto.setYyyymmdd(txt.getText());
						boolean b = db.delete(dto);
						if (b) {
							JOptionPane.showMessageDialog(this, "삭제 완료");
							db.db_disconn();
						} else {
							JOptionPane.showMessageDialog(this, "삭제 실패");
						}
					} else {
						JOptionPane.showMessageDialog(this, "dbdbdb오류");
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
		btn = new JButton("달력");
		btn.addActionListener(this);

		save = new JButton("저장");
		save.addActionListener(this);

		select = new JButton("조회");
		select.addActionListener(this);

		cancel = new JButton("초기화");
		cancel.addActionListener(this);

		delete = new JButton("삭제");
		delete.addActionListener(this);

		update = new JButton("수정");
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
		center.add(bc);// 파이차트
		center.add(pc);// 막대차트

		this.add("Center", center);
		this.add("South", panel);
		this.setBounds(200, 0, 800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SalesSystem("매출관리 시스템");
	}

	class BarChart extends JPanel {
		private int data1, data2, data3;

		public void setDate(int d1, int d2, int d3) {
			data1 = d1;
			data2 = d2;
			data3 = d3;
		}// 막대그래프를 위한 테이터 3개를 전달받는다

		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			// 그래프를 그리기 전에 패널을 내용을 지운다
			g.drawLine(50, 250, 350, 250);// 수평선을 그린다
			for (int i = 1; i < 11; i++) {
				g.drawString(i * 10 + "", 25, 255 - 20 * i);// 수평선 제목,x,y
				g.drawLine(50, 250 - 20 * i, 350, 250 - 20 * i);// 수평선
			} // 나머지 수평선 10개를 그린다
			g.drawString("만(원)", 10, 20);
			g.drawLine(50, 20, 50, 250);// 수직선을 그린다.
			g.setColor(Color.BLACK);
			g.drawString("오전", 100, 270);// 첫 번째 막대그래프의 제목
			g.drawString("오후", 200, 270);// 두 번째 막대그래프의 제목
			g.drawString("저녁", 300, 270);// 세 번째 막대그래프의 제목
			g.setColor(Color.ORANGE);
			if (data1 > 0) {// 막대그래프
				g.fillRect(110, 250 - data1 * 2, 10, data1 * 2);
				// x y 두깨 높이
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
