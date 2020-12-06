package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

//remember_jaegu 테이블의 데이터를 모두 검색해서,
//List에 저장하고, List에 저장된 검색결과를 콘솔로 출력
class Guest {//고객정보용 DTO 객체
	private String id;
	private String password;
	private String gender;
	private String address;
	private String name;
	private String phonenumber;
	private String joindate;
	private String star;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
}
class DBUtility {
	Connection conn; PreparedStatement pstmt; ResultSet rs;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String select="select * from remember_jaegu";
	ArrayList<Guest> select(){
		ArrayList<Guest> al = new ArrayList<Guest>();
		try {
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();//DB에서 조회(전체조회)
			while(rs.next()) {
				Guest guest = new Guest();
				guest.setId(rs.getString("id"));
				guest.setPassword(rs.getString("password"));
				guest.setGender(rs.getString(3));
				guest.setAddress(rs.getString(4));
				guest.setName(rs.getString(5));
				guest.setPhonenumber(rs.getString(6));
				guest.setJoindate(rs.getString(7));
				guest.setStar(rs.getString("star"));
				al.add(guest);
			}
		}catch(Exception e) {
			
		}
		return al;
	}
	//DB와 접속하는 메서드
	boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			flag = true;
		}catch(Exception e) {}
		return flag;
	}
	//DB와 접속해제하는 메서드
	void db_dicconn() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
}
public class SelectTest {
	public static void main(String[] args) {
		DBUtility util = new DBUtility();
		if(util.db_conn()) {
			ArrayList<Guest> al = util.select();
			Iterator it = al.iterator();
			while(it.hasNext()) {
				Guest guest = (Guest)it.next();
				System.out.println("ID:"+guest.getId());
				System.out.println("암호:"+guest.getPassword());
				System.out.println("성별:"+guest.getGender());
				System.out.println("주소:"+guest.getAddress());
				System.out.println("이름:"+guest.getName());
				System.out.println("연락처:"+guest.getPhonenumber());
				System.out.println("가입일:"+guest.getJoindate());
				System.out.println("별자리:"+guest.getStar());
			}//while의 끝
			util.db_dicconn();//DB와 접속해제
		}//if의 끝
	}//main 메서드의 끝
}//SelectTest 클래스의 끝

















