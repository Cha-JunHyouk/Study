package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class MyDB {
	//DB접속,해제,CRUD
	InsertDataWindow idw;//윈도우 객체 선언
	Connection conn; PreparedStatement pstmt;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String insert = "insert into remember_jaegu "
		+ "values(?,?,?,?,?,?,?,?)";
	String delete = "delete from remember_jaegu where 1=1 ";
	String select = "select * from remember_jaegu where id=?";
	String update = "update remember_jaegu set password=?,"
			+ "gender=?, address=?,name=?,phonenumber=?,star=? "
			+ "where id = ?";
	ResultSet rs;
	
	public boolean change(Remeber_jaegu jaegu){
		boolean flag = false;//true:변경성공,false:변경실패
		try {
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, jaegu.getPassword());//암호설정
			pstmt.setString(2, jaegu.getGender());//성별설정
			pstmt.setString(3, jaegu.getAddress());//주소설정
			pstmt.setString(4, jaegu.getName());//이름설정
			pstmt.setString(5, jaegu.getPhonenumber());//연락처설정
			pstmt.setString(6, jaegu.getStar());//별자리 설정
			pstmt.setString(7, jaegu.getId());//계정설정
			pstmt.executeUpdate();//DB에서 변경실행
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	public Remeber_jaegu select(String id){
		Remeber_jaegu jaegu = new Remeber_jaegu();//DTO생성
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);//?에 입력된 계정을 설정
			rs = pstmt.executeQuery();//조회결과를 ResultSet에 저장
			if(rs.next()) {//조회결과가 존재하는 경우
				jaegu.setId(rs.getString("id"));
				jaegu.setPassword(rs.getString("password"));
				jaegu.setGender(rs.getString(3));
				jaegu.setAddress(rs.getString(4));
				jaegu.setName(rs.getString("name"));
				jaegu.setPhonenumber(rs.getString(6));
				jaegu.setJoindate(rs.getString(7));//7번째는 가입일
				jaegu.setStar(rs.getString(8));
			}else {//조회결과가 존재하지 않는 경우
				jaegu = null;
			}
		}catch(Exception e) {
			
		}
		return jaegu;//조회결과가 담긴 DTO를 리턴한다.
	}
	public void delete(Remeber_jaegu r) {
		if( ! r.getId().equals("")) {
			delete = delete + "and id='"+r.getId()+"' ";
		}//계정이 입력된 경우
		if( ! r.getPassword().equals("")) {
			delete=delete+" and password='"+r.getPassword()+"' ";
		}//암호가 입력된 경우
		if( ! r.getGender().equals("")) {
			delete=delete+" and gender='"+r.getGender()+"' ";
		}//성별이 입력된 경우
		if(! r.getAddress().equals("")) {
			delete=delete+" and address='"+r.getAddress()+"' ";
		}//주소가 입력된 경우
		if(! r.getName().equals("")) {
			delete=delete+" and name='"+r.getName()+"' ";
		}//이름이 입력된 경우
		if(! r.getPhonenumber().equals("")) {
			delete=delete+" and phonenumber='"+
					r.getPhonenumber()+"' ";
		}//전화번호가 입력된 경우
		if(! r.getStar().equals("")) {
			delete=delete+" and star='"+r.getStar()+"' ";
		}//별자리가 입력된 경우
		try {
			pstmt = conn.prepareStatement(delete);
			int cnt=pstmt.executeUpdate();//DB에서 삭제
			JOptionPane.showMessageDialog(idw, 
				"성공적으로 수행되었습니다. "
				+ "삭제된 건수는 "+cnt+"입니다.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(idw, 
				"입력된 정보가 삭제되지 않았습니다.");
		}
	}
	public MyDB() {
		
	}//생성자-생성자의 오버로딩
	public MyDB(InsertDataWindow idw) {
		this.idw = idw;//생성된 윈도우 객체를 받는다.
	}//생성자
	public void insert(Remeber_jaegu r) {
		try {
			pstmt = conn.prepareStatement(insert);
			//쿼리에 있는 물음표에 해당 데이터를 할당한다.
			pstmt.setString(1, r.getId());//계정
			pstmt.setString(2, r.getPassword());//암호
			pstmt.setString(3, r.getGender());//성별
			pstmt.setString(4, r.getAddress());//주소
			pstmt.setString(5, r.getName());//이름
			pstmt.setString(6, r.getPhonenumber());//연락처
			pstmt.setString(7, getToday());
			pstmt.setString(8, r.getStar());//별자리
			pstmt.executeUpdate();//DB에 삽입
			JOptionPane.showMessageDialog(idw, 
				"삽입되었습니다.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(idw, 
				"삽입되지 않았습니다. 관리자에게 문의하세요.");
		}
	}
	private String getToday() {
		GregorianCalendar gc = new GregorianCalendar();
		int yyyy=gc.get(Calendar.YEAR);
		int mm = gc.get(Calendar.MONTH) + 1;
		int dd = gc.get(Calendar.DATE);
		String today = yyyy+"/"+mm+"/"+dd;
		return today;
	}
	public void db_disconn() {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}catch(Exception e) {}
	}
	public boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(
					url,"hr","hr");
			flag = true;
		}catch(Exception e) {
		}
		return flag;
	}
}














