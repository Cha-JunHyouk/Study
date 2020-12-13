package senior;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class UsedCarModel extends AbstractTableModel {
	Object[][] data; int row,col; String[] columnName;
	void setRow(ResultSet rs) {
		try {
			rs.last(); row = rs.getRow(); rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			columnName = new String[col];
			for(int i=0; i<col; i++) {
				columnName[i] = rsmd.getColumnName(i + 1);
			}
			data = new Object[row][col];
			int r = 0;
			while(rs.next()) {
				for(int i = 0; i<col; i++) {
					data[r][i] = rs.getObject(i + 1);
				}
				r++;
			}
			rs.close();
		}catch(Exception e) {}
	}
	@Override
	public int getColumnCount() {
		return col;
	}
	@Override
	public int getRowCount() {
		return row;
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}
	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}
}

class UsedCarDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into used_car values(?,?,?,?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from used_car where 1=1 ";
	
	ResultSet selectAllLast() {
		try {
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	ResultSet selectAllNext() {
		try {
			pstmt = conn.prepareStatement(select);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	ResultSet selectLast(UsedCar uc) {
		try {
			if( ! uc.getNum().equals("")) {//차량번호가 입력된 경우
				select=select+" and num='"+uc.getNum()+"'";
			}
			if( uc.getMaker() != null) {//제조사가 입력된 경우(콤보)
				select=select+" and maker='"+uc.getMaker()+"'";
			}
			//데이터를 입력하는 것이 아니고, 콤보박스에서 선택하는 것이므로
			//입력한 내용이 없는지(길이가 없는 문자열)를 비교하는 것이 아니라,
			//선택했는지를 비교하는 것이므로 null과 비교해야 한다.
			if( ! uc.getModel().equals("")) {//모델명이 입력된 경우
				select=select+" and model='"+uc.getModel()+"'";
			}
			if( uc.getMake_year() != null) {//제조년이 입력된경우(콤보)
				select=select+" and make_year='"+uc.getMake_year()+"'";
			}
			if(uc.getKm() != null) {//주행거리(정수)가 입력된 경우
				select=select+" and km="+uc.getKm();
			}
			if( uc.getFuel() != null) {//연료종류가 입력된 경우(콤보)
				select=select+" and fuel='"+uc.getFuel()+"'";
			}
			if(uc.getPrice() != null) {//가격이 입력된 경우
				select=select+" and price="+uc.getPrice();
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;//last()가 가능한 ResultSet을 리턴
	}
	ResultSet selectNext(UsedCar uc) {
		try {
			if( ! uc.getNum().equals("")) {//차량번호가 입력된 경우
				select=select+" and num='"+uc.getNum()+"'";
			}
			if( uc.getMaker() != null) {//제조사가 입력된 경우
				select=select+" and maker='"+uc.getMaker()+"'";
			}
			if( ! uc.getModel().equals("")) {//모델명이 입력된 경우
				select=select+" and model='"+uc.getModel()+"'";
			}
			if( uc.getMake_year() != null) {//제조년이 입력된경우
				select=select+" and make_year='"+uc.getMake_year()+"'";
			}
			if(uc.getKm() != null) {//주행거리(정수)가 입력된 경우
				select=select+" and km="+uc.getKm();
			}
			if( uc.getFuel() != null) {//연료종류가 입력된 경우
				select=select+" and fuel='"+uc.getFuel()+"'";
			}
			if(uc.getPrice() != null) {//가격이 입력된 경우
				select=select+" and price="+uc.getPrice();
			}
			pstmt = conn.prepareStatement(select);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {
			
		}
		return rs2;//next()가 가능한 ResultSet을 리턴
	}
	
	boolean insert(UsedCar uc) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, uc.getNum());
			pstmt.setString(2, uc.getMaker());
			pstmt.setString(3, uc.getModel());
			pstmt.setString(4, uc.getMake_year());
			pstmt.setInt(5, uc.getKm());
			pstmt.setString(6, uc.getFuel());
			pstmt.setInt(7, uc.getPrice());
			pstmt.executeUpdate();//DB에 삽입
			flag = true;//삽입 성공을 의미
		}catch(Exception e) {
			
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
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
}
class UsedCar {
	private String num;//차량번호
	private String maker;//제조사
	private String model;//모델명
	private String make_year;//제조년
	private Integer km;//주행거리
	private String fuel;//연료종류
	private Integer price;//가격
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake_year() {
		return make_year;
	}
	public void setMake_year(String make_year) {
		this.make_year = make_year;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}

public class UsedCarSystem extends JFrame 
	implements ActionListener, MouseListener{
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();//선택한 행번호 획득
		txts[0].setText(table.getValueAt(row, 0)+"");//첫번째 열출력
		combos[0].setSelectedItem(table.getValueAt(row, 1));
		//지정된 데이터와 일치하는 항목으로 콤보박스를 출력한다.
		txts[1].setText(table.getValueAt(row, 2)+"");//세번째 열출력
		combos[1].setSelectedItem(table.getValueAt(row, 3));
		txts[2].setText(table.getValueAt(row, 4)+"");//다섯번째 열출력
		combos[2].setSelectedItem(table.getValueAt(row, 5));
		txts[3].setText(table.getValueAt(row, 6)+"");//여섯번째 열출력
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//차량 등록을 누른경우
			//모든 항목이 입력이 되었는지 검사한다.
			boolean flag = true;
			for(int i=0; i<titles.length; i++) {
				switch(i) {
				case 0: if(txts[0].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[0]+"이 입력되지 않았습니다.");
							flag = false;
						}
						break;
				case 1: 
						int pos = combos[0].getSelectedIndex();
						if(pos == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[1]+"가 선택되지 않았습니다.");
							flag = false;
						}
						break;
				case 2: if(txts[1].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[2]+"이 입력되지 않았습니다.");
							flag = false;
						}
						break;
				case 3:
						int pos1 = combos[1].getSelectedIndex();
						if(pos1 == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[3]+"가 선택되지 않았습니다.");
							flag = false;
						}
						break;
				case 4:if(txts[2].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[4]+"가 입력되지 않았습니다.");
							flag = false;
						}
						break;
				case 5: 
						int pos2 = combos[2].getSelectedIndex();
						if(pos2 == 0) {
							JOptionPane.showMessageDialog(this, 
								titles[5]+"가 선택되지 않았습니다.");
							flag = false;
						}
						break;
				case 6: if(txts[3].getText().equals("")) {
							JOptionPane.showMessageDialog(this, 
								titles[6]+"이 입력되지 않았습니다.");
							flag = false;
						}//end of if
				}//end of switch
				if(flag == false) break;//반복 중단
			}//end of for
			if(flag) {//flag가 true인 경우,즉, 모든 항목이 입력된 경우
				int j = JOptionPane.showConfirmDialog(this, 
					"정말로 등록하시겠습니까?");
				if(j == JOptionPane.OK_OPTION) {//예를 선택한 경우
					UsedCarDB db = new UsedCarDB();
					UsedCar uc = new UsedCar();//DTO생성
					uc.setNum(txts[0].getText());//차량번호
					uc.setMaker(combos[0].getSelectedItem()+"");
					uc.setModel(txts[1].getText());//모델명
					uc.setMake_year(combos[1].getSelectedItem()+"");
					uc.setKm(Integer.parseInt(txts[2].getText()));
					uc.setFuel(combos[2].getSelectedItem()+"");
					uc.setPrice(Integer.parseInt(txts[3].getText()));
					if(db.db_conn()) {//DB접속 성공
						boolean result = db.insert(uc);//DB에 삽입

						ResultSet rsLast = db.selectAllLast();
						ResultSet rsNext = db.selectAllNext();
						UsedCarModel um = new UsedCarModel();
						um.setRow(rsLast);
						um.setData(rsNext);
						table.setModel(um);
						table.updateUI();
						
						db.db_disconn();//DB와 접속 해제
						if(result) {//삽입이 성공한 경우
							JOptionPane.showMessageDialog(this, 
								"차량정보가 등록되었습니다.");
						}else {//삽입이 실패한 경우
							JOptionPane.showMessageDialog(this, 
								"차량정보 등록이 되지 않았습니다.");
						}
					}else {//DB접속 실패 
						JOptionPane.showMessageDialog(this, 
							"DB와 연결되지 않았습니다.");
					}
				}
			}else {//flag가 false인 경우 즉,모든 항목이 입력되지 않은경우
				
			}
		}else if(obj == btns[1]) {//차량 조회를 누른경우
			UsedCar uc = new UsedCar();//DTO 생성
			//생성된 DTO에 화면에 입력된 데이터를 넣는다.
			uc.setNum(txts[0].getText());
			if(combos[0].getSelectedIndex()!=0) {//제조사를 선택한경우
				uc.setMaker(combos[0].getSelectedItem()+"");
			}
			uc.setModel(txts[1].getText());
			if(combos[1].getSelectedIndex()!=0) {//제조년을선택한경우
				uc.setMake_year(combos[1].getSelectedItem()+"");
			}
			if(txts[2].getText().equals("")) {//주행거리가 없는경우
				uc.setKm(null);
			}else {//주행거리가 있는 경우
				uc.setKm(Integer.parseInt(txts[2].getText()));
			}
			if(combos[2].getSelectedIndex()!=0) {//연료를선택한경우
				uc.setFuel(combos[2].getSelectedItem()+"");
			}
			if(txts[3].getText().equals("")) {//가격을입력하지않은경우
				uc.setPrice(null);
			}else {
				uc.setPrice(Integer.parseInt(txts[3].getText()));
			}
			UsedCarDB db = new UsedCarDB();
			if(db.db_conn()) {
				ResultSet rsLast = db.selectLast(uc);
				ResultSet rsNext = db.selectNext(uc);
				UsedCarModel model = new UsedCarModel();
				model.setRow(rsLast);
				model.setData(rsNext);
				table.setModel(model);
				table.updateUI();
				db.db_disconn();//DB와 연결 해제
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB와 연결되지 않았습니다.");
			}
		}
	}
	String[] titles= {"차량번호","제조사","모델명","제조년","주행거리",
			"연료종류","가 격"};
	String[] btnTitles = {"차량 등록","차량 조회"};
	JTextField[] txts; JComboBox[] combos; JPanel[] pans;
	JLabel[] lbls; Font font; JButton[] btns;
	JPanel centerPan, centerLeft; JTable table; JScrollPane span; 
	String[] makerNames = {"제조사를 선택하세요","현대","기아","쌍용","벤츠","BMW","아우디",
			"도요타","니싼","혼다"};
	String[] fuelNames = {"연료종류를 선택하세요","경유","휘발유","배터리"};
	void makeWindow() {
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));//1행 2열
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(8,1));//8행 1열
		for(int i=0; i<pans.length; i++) {
			centerLeft.add(pans[i]);
		}//centerLeft에 패널8개를 붙인다.
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		pans = new JPanel[8];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			switch(i) {
			case 0:pans[i].add(lbls[0]); pans[i].add(txts[0]);break;
			case 1:pans[i].add(lbls[1]); pans[i].add(combos[0]);break;
			case 2:pans[i].add(lbls[2]); pans[i].add(txts[1]);break;
			case 3:pans[i].add(lbls[3]); pans[i].add(combos[1]);break;
			case 4:pans[i].add(lbls[4]); pans[i].add(txts[2]);break;
			case 5:pans[i].add(lbls[5]); pans[i].add(combos[2]);break;
			case 6:pans[i].add(lbls[6]); pans[i].add(txts[3]);break;
			case 7:pans[i].add(btns[0]); pans[i].add(btns[1]);break;
			}
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i = 0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].setFont(font);
			btns[i].addActionListener(this);
		}
	}
	void makeCombo() {//제조사,제조년,연료종류를 콤보박스로 한다.
		combos = new JComboBox[3];
		for(int i=0; i<combos.length; i++) {
			combos[i] = new JComboBox(); combos[i].setFont(font);
			switch(i) {
			case 0: for(int x=0; x<makerNames.length; x++) {
						combos[i].addItem(makerNames[x]);
					}//첫번째 콤보박스에 제조사이름을 넣는다.
					break;
			case 1: combos[i].addItem("제조년을 선택하세요");
					for(int x=2020; x>=1980; x--) {
						combos[i].addItem(x+"");
					}//두번째 콤보박스에 2020부터 1980을 넣는다.
					break;
			case 2: for(int x=0; x<fuelNames.length; x++) {
						combos[i].addItem(fuelNames[x]);
					}//세번째 콤보박스에 경유,휘발유,배터리를 넣는다.
			}
		}
	}
	void makeTextField() {
		txts = new JTextField[4];//차량번호,모델명,주행거리,가격용
		for(int i=0; i<txts.length; i++) {
			txts[i] = new JTextField(15);
			txts[i].setFont(font);
		}
	}
	public UsedCarSystem(String str) {
		super(str);
		font = new Font("고딕체",Font.BOLD, 14);
		makeLabel(); makeTextField(); makeCombo(); makeButton();
		makePanel(); makeWindow();
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i<lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);
		}
	}
	public static void main(String[] args) {
		new UsedCarSystem("중고차 등록,조회 시스템 ver1.0");
	}
}











