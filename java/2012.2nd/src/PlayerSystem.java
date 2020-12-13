package senior;

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

class BaseballModel extends AbstractTableModel {
	Object[][] data; int row, col; String[] columnName;
	void setRow(ResultSet rs) {//last()가능한 ResultSet
		try {
			rs.last();
			row = rs.getRow();
			rs.close();
		}catch(Exception e) {}
	}
	void setData(ResultSet rs) {//next()만 가능한 ResultSet
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			col = rsmd.getColumnCount();
			columnName = new String[col];
			for(int x=0; x<col; x++) {
				columnName[x] = rsmd.getColumnName(x + 1);
			}
			data = new Object[row][col];
			int r = 0;
			while(rs.next()) {
				for(int k = 0; k < col; k++) {
					data[r][k] = rs.getObject(k + 1);
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}
}

class BaseballDB {
	Connection conn; PreparedStatement pstmt; 
	ResultSet rs; ResultSet rs2;
	String insert = "insert into bb_player values(?,?,?,?)";
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String select = "select * from bb_player where 1=1 ";
	ResultSet select2(BaseballPlayer bp) {
		try {
			if( ! bp.getTeam().equals("")) {//팀이름이 입력된 경우
				select = select + " and team='"+bp.getTeam()+"'";
			}
			if( bp.getNum() != null) {//등번호가 null이 아닌 경우
				select = select + " and num="+bp.getNum();
			}
			if( ! bp.getName().equals("")) {//선수이름이 입력된 경우
				select = select + " and name='"+bp.getName()+"'";
			}
			if( ! bp.getPosition().equals("")) {//포지션이 입력된경우
				select = select + " and position='"+bp.getPosition()+"'";
			}
			pstmt = conn.prepareStatement(select,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs2 = pstmt.executeQuery();//last()가 가능한 ResultSet
		}catch(Exception e) {
			
		}
		return rs2;
	}
	ResultSet select1(BaseballPlayer bp) {
		try {
			if( ! bp.getTeam().equals("")) {//팀이름이 입력된 경우
				select = select + " and team='"+bp.getTeam()+"'";
			}
			if( bp.getNum() != null) {//등번호가 null이 아닌 경우
				select = select + " and num="+bp.getNum();
			}
			if( ! bp.getName().equals("")) {//선수이름이 입력된 경우
				select = select + " and name='"+bp.getName()+"'";
			}
			if( ! bp.getPosition().equals("")) {//포지션이 입력된경우
				select = select + " and position='"+bp.getPosition()+"'";
			}
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();//next()만 가능한 ResultSet
		}catch(Exception e) {
			
		}
		return rs;
	}
	
	
	int insert(BaseballPlayer bp) {
		int flag = 0;
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, bp.getTeam());
			pstmt.setInt(2, bp.getNum());
			pstmt.setString(3, bp.getName());
			pstmt.setString(4, bp.getPosition());
			pstmt.executeUpdate();//DB에 삽입
		}catch(Exception e) {
			flag = 1;
		}
		return flag;//0이면 삽입성공, 1이면 실패
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

class BaseballPlayer{
	private String team;//팀이름
	private Integer num;//선수 등번호
	private String name;//선수 이름
	private String position;//선수 포지션
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
public class PlayerSystem extends JFrame 
	implements ActionListener, MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//마우스로 클릭한 JTable에 행번호와 열번호를 찾는다.
		int row=table.getSelectedRow();//클릭한 행번호
		int col=table.getSelectedColumn();//클릭한 열번호
		//선택한 행의 1열을 첫번째 텍스트필드에 출력한다.
		txts[0].setText(table.getValueAt(row, 0)+"");
		//선택한 행의 2열을 두번째 텍스트필드에 출력한다.
		txts[1].setText(table.getValueAt(row, 1)+"");
		//선택한 행의 3열을 세번째 텍스트필드에 출력한다.
		txts[2].setText(table.getValueAt(row, 2)+"");
		//선택한 행의 4열을 네번째 텍스트필드에 출력한다.
		txts[3].setText(table.getValueAt(row, 3)+"");
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
		if(obj == btns[0]) {//선수 등록을 누른 경우
			boolean flag = true;
			for(int i=0; i<txts.length; i++) {
				if(txts[i].getText().equals("")) {
					JOptionPane.showMessageDialog(this, 
						titles[i]+"가 입력되지 않았습니다.");
					flag = false;
					break;//반복종료
				}
			}//모든 입력사항에 데이터가 입력되었는지 검사
			if(flag) {//모든 항목이 입력된 경우
				int j = JOptionPane.showConfirmDialog(this, 
					"정말로 저장하시겠습니까?");
				if(j == JOptionPane.OK_OPTION) {//예를 누른경우
					BaseballPlayer bp = new BaseballPlayer();//DTO생성
					bp.setTeam(txts[0].getText());
					bp.setNum(Integer.parseInt(txts[1].getText()));
					bp.setName(txts[2].getText());
					bp.setPosition(txts[3].getText());
					BaseballDB db = new BaseballDB();
					if(db.db_conn()) {
						int get = db.insert(bp);
						if(get == 0) {//삽입성공
							JOptionPane.showMessageDialog(this, 
								"선수정보가 등록되었습니다.");
							db.db_disconn();//DB와 연결해제
						}else {//삽입실패
							JOptionPane.showMessageDialog(this, 
								"선수등록이 되지 않았습니다.");
						}//삽입성공유무if의 끝
					}else {
						JOptionPane.showMessageDialog(this, 
							"DB와 접속되지 않았습니다.");
					}//db연결 if의 끝
				}//예를 누른경우의 끝
			}
		}else if(obj == btns[1]) {//선수 조회를 누른 경우
			BaseballDB db = new BaseballDB();
			//입력한 데이터를 읽어서 DTO에 저장한다.
			BaseballPlayer bp = new BaseballPlayer();//DTO생성
			bp.setTeam(txts[0].getText());
			//선수 등번호는 입력이 안된경우는 0으로 설정
			if(txts[1].getText().equals("")) {
				bp.setNum(null);
			}else {
				bp.setNum(Integer.parseInt(txts[1].getText()));
			}
			bp.setName(txts[2].getText());
			bp.setPosition(txts[3].getText());
			//DTO를 사용해서 DB에서 조회한다.
			if(db.db_conn()) {
				ResultSet rs1 = db.select1(bp);
				ResultSet rs2 = db.select2(bp);//last()가능
				BaseballModel bm = new BaseballModel();
				bm.setRow(rs2);
				bm.setData(rs1);
				table.setModel(bm);//JTable에 모델 설정
				table.updateUI();//JTable 갱신
				db.db_disconn();//DB와 연결 해제
			}else {
				JOptionPane.showMessageDialog(this, 
					"DB와 연결되지 않았습니다.");
			}
		}
	}
	JLabel[] lbls; JTextField[] txts; JButton[] btns;
	JPanel[] pans; JTable table; JScrollPane span;
	String[] titles = {"팀이름","등번호","선수이름","포지션"};
	String[] btnTitles = {"선수 등록","선수 조회"};
	JPanel centerPan; JPanel centerLeft;
	void makeWindow() {
		table = new JTable(); 
		table.addMouseListener(this);
		span = new JScrollPane(table);
		centerPan = new JPanel(); 
		centerPan.setLayout(new GridLayout(1,2));
		centerPan.add(centerLeft); centerPan.add(span);
		this.add("Center", centerPan);
		this.setBounds(100, 150, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void makePanel() {
		centerLeft = new JPanel();
		centerLeft.setLayout(new GridLayout(5,1));//5행 1열
		pans = new JPanel[5];
		for(int i=0; i<pans.length; i++) {
			pans[i] = new JPanel();
			if(i == 4) {//마지막 패널에는 버튼을 붙인다.
				pans[i].add(btns[0]); pans[i].add(btns[1]);
			}else {//마지막 패널을 제외한 패널에 레이블,텍스트필드를 붙임
				pans[i].add(lbls[i]);//패널에 레이블을 붙임
				pans[i].add(txts[i]);//패널에 텍스트필드 붙임
			}
			centerLeft.add(pans[i]);//centerLeft에 패널을 붙인다.
		}//centerLeft에 들어갈 패널 5개 생성
	}
	void makeLabel() {
		lbls = new JLabel[titles.length];
		for(int i=0; i < lbls.length; i++) {
			lbls[i] = new JLabel(titles[i]);
		}
	}
	void makeButton() {
		btns = new JButton[btnTitles.length];
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
		}
	}
	void makeTextField() {
		txts = new JTextField[titles.length];
		for(int i=0; i< txts.length; i++) {
			txts[i] = new JTextField(20);
		}
	}
	public PlayerSystem(String str) {
		super(str);
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		makeWindow();
	}
	public static void main(String[] args) {
		new PlayerSystem("야구선수관리 시스템 ver1.0");
	}

}












