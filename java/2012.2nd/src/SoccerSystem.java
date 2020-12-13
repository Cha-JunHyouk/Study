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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class SoccerModel extends AbstractTableModel {
	Object[][] data; int row,col; String[] columnName;
	void setRow(ResultSet rs) {//행갯수를 설정하는 메서드
		try {
			rs.last();	row = rs.getRow();	rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {//2차원배열에 DB조회결과를 저장하는메서드
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
				for(int i=0; i<col; i++) {
					data[r][i] = rs.getObject(i + 1);
				}
				r++;
			}
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

class SoccerDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into fb_player values(?,?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from fb_player where 1=1 ";
	
	ResultSet selectAll1() {//next()만 가능한 ResultSet리턴
		try {
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	ResultSet selectAll2() {//last()가 가능한 ResultSet리턴
		try {
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	
	ResultSet select2(SoccerPlayer sp) {//last()가능한 ResultSet리턴
		try {
			if( !sp.getTeam_name().equals("")) {//팀명이 입력된경우
				select=
					select + " and team_name='"+sp.getTeam_name()+"'";
			}
			if( !sp.getName().equals("")) {//선수명이 입력된 경우
				select=select+" and name='"+sp.getName()+"'";
			}
			if( sp.getBack_num() != null) {//등번호가 입력된 경우
				select=select+" and back_num="+sp.getBack_num();
			}
			if( !sp.getPosition().equals("")) {//포지션이 입력된 경우
				select=select+" and position='"+sp.getPosition()+"'";
			}
			if( sp.getGoal()!=null) {//득점수가 입력된 경우
				select = select + " and goal="+sp.getGoal();
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs2;
	}
	ResultSet select1(SoccerPlayer sp) {//next()만가능한ResultSet리턴
		try {
			if( !sp.getTeam_name().equals("")) {//팀명이 입력된경우
				select=
					select + " and team_name='"+sp.getTeam_name()+"'";
			}
			if( !sp.getName().equals("")) {//선수명이 입력된 경우
				select=select+" and name='"+sp.getName()+"'";
			}
			if( sp.getBack_num() != null) {//등번호가 입력된 경우
				select=select+" and back_num="+sp.getBack_num();
			}
			if( !sp.getPosition().equals("")) {//포지션이 입력된 경우
				select=select+" and position='"+sp.getPosition()+"'";
			}
			if( sp.getGoal()!=null) {//득점수가 입력된 경우
				select = select + " and goal="+sp.getGoal();
			}
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
		}catch(Exception e) {}
		return rs;
	}
	
	boolean insert(SoccerPlayer player) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, player.getTeam_name());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getBack_num());
			pstmt.setString(4, player.getPosition());
			pstmt.setInt(5, player.getGoal());
			pstmt.executeUpdate();//DB에 삽입
			flag = true;
		}catch(Exception e) {
			
		}
		return flag;//성공이면 true, 실패이면 false 리턴
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
class SoccerPlayer {
	private String team_name;//팀이름
	private String name;//선수이름
	private Integer back_num;//등번호
	private String position;//포지션
	private Integer goal;//득점수
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBack_num() {
		return back_num;
	}
	public void setBack_num(Integer back_num) {
		this.back_num = back_num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
}
public class SoccerSystem extends JFrame 
	implements ActionListener, MouseListener{
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//클릭한 곳의 행번호를 찾는다.
		int row = table.getSelectedRow();
		//1열 부터 5열까지의 데이터를 텍스트필드에 출력한다.
		txts[0].setText(table.getValueAt(row, 0)+"");//1열 출력
		txts[1].setText(table.getValueAt(row, 1)+"");//2열출력
		txts[2].setText(table.getValueAt(row, 2)+"");//3열 출력
		txts[3].setText(table.getValueAt(row, 3)+"");//4열 출력
		txts[4].setText(table.getValueAt(row, 4)+"");//5열 출력
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btns[0]) {//선수 등록 버튼을 누른 경우
			boolean flag = true;//모든 항목에 데이터가 입력된 경우 true
			for(int i=0; i<txts.length; i++) {
				if(txts[i].getText().equals("")) {//데이터가 없는경우
					JOptionPane.showMessageDialog(this, 
						titles[i]+"이(가) 입력되지 않았습니다.");
					flag = false;//데이터가 입력되지 않았슴을 의미
					break;//반복을 종료
				}
			}//모든 텍스트필드를 반복하면서 검사
			if(flag) {//flag가 true인 경우,즉 모든 데이터가 입력된경우
				//DTO에 입력데이터를 입력하고, DB에 삽입한다.
				SoccerDB db = new SoccerDB();
				SoccerPlayer sp = new SoccerPlayer();//DTO생성
				sp.setTeam_name(txts[0].getText());
				sp.setName(txts[1].getText());
				sp.setBack_num(Integer.parseInt(txts[2].getText()));
				sp.setPosition(txts[3].getText());
				sp.setGoal(Integer.parseInt(txts[4].getText()));
				if(db.db_conn()) {
					int re = JOptionPane.showConfirmDialog(this, 
						"정말로 등록하시겠습니까?");
					if(re == JOptionPane.OK_OPTION) {//예를 선택한경우
						boolean y = db.insert(sp);
						ResultSet rs1 = db.selectAll1();//next()가능
						ResultSet rs2 = db.selectAll2();//last()가능
						SoccerModel sm = new SoccerModel();
						sm.setRow(rs2);
						sm.setData(rs1);
						table.setModel(sm);
						table.updateUI();
						db.db_disconn();//DB연결 해제
						if(y) {//등록이 성공한 경우
							JOptionPane.showMessageDialog(this, 
								"선수가 등록되었습니다.");
						}else {//등록이 실패한 경우
							JOptionPane.showMessageDialog(this, 
								"선수가 등록되지 않았습니다.");
						}
					}
				}else {
					JOptionPane.showMessageDialog(this, 
						"DB와 연결되지 않았습니다.");
				}
			}else {//모든 데이터가 입력되지 않은 경우
				//이미 메세지가 출력되었으므로 아무일도 하지 않는다.
			}
		}else if(obj == btns[1]) {//선수 조회 버튼을 누른 경우
			SoccerDB db = new SoccerDB();
			SoccerPlayer sp = new SoccerPlayer();//DTO생성
			sp.setTeam_name(txts[0].getText());
			sp.setName(txts[1].getText());
			if(txts[2].getText().equals("")) {//등번호가 입력되지 않음
				sp.setBack_num(null);
			}else {
				sp.setBack_num(Integer.parseInt(txts[2].getText()));
			}
			sp.setPosition(txts[3].getText());
			if(txts[4].getText().equals("")) {//득점수가 입력되지 않음
				sp.setGoal(null);
			}else {
				sp.setGoal(Integer.parseInt(txts[4].getText()));
			}
			if(db.db_conn()) {
				//DB에서 검색->검색결과를 모델로전송->JTable에 출력
				ResultSet rs1 = db.select1(sp);
				ResultSet rs2 = db.select2(sp);
				SoccerModel sm = new SoccerModel();
				sm.setRow(rs2);//last()가 가능한 ResultSet을 전달
				sm.setData(rs1);//next()만 가능한 ResultSet을 전달
				table.setModel(sm);//JTable에 모델을 설정
				table.updateUI();//JTable 갱신
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB와 연결되지 않았습니다.");
			}
		}
	}
	String[] titles = {"팀이름","선수명","등번호","포지션","득점수"};
	String[] btnTitles = {"선수등록", "선수조회"};
	JLabel[] lbls; JTextField[] txts; JButton[] btns;
	JTable table; JScrollPane span; JPanel[] pans;
	JPanel centerPan; JPanel centerLeft; Font font;
	public SoccerSystem(String str) {
		super(str);
		font = new Font("고딕체",Font.BOLD, 20);
		makeLabel(); makeTextField(); makeButton(); makePanel();
		makeWindow();
	}
	void makeWindow() {
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));//1행 2열
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 800, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(6,1));//6행1열
		pans = new JPanel[6];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			if(i == 5) {//6번째 패널인 경우
				pans[i].add(btns[0]); pans[i].add(btns[1]);
			}else {//6번째 패널이 아닌 경우
				pans[i].add(lbls[i]); pans[i].add(txts[i]);
			}
			centerLeft.add(pans[i]);//생성한 패널을 centerLeft에 붙임
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].setFont(font);//생성된 버튼에 폰트 적용
			btns[i].addActionListener(this);
		}
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i = 0; i< lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
			lbls[i].setFont(font);//생성된 레이블에 폰트 적용
		}
	}
	void makeTextField() {
		txts = new JTextField[titles.length];
		for(int i=0; i < txts.length; i++) {
			txts[i] = new JTextField(20);
			txts[i].setFont(font);//생성된 텍스트필드에 폰트 적용
		}
	}
	public static void main(String[] args) {
		new SoccerSystem("축구선수 관리 시스템 ver1.0");
	}
}












