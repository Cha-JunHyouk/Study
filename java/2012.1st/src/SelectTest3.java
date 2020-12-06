package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;

//맛집정보 DTO
class Matjip{
	private Integer seqno;
	private String name;
	private String addr;
	private String tel;
	private String mobile;
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
class MatjipDB {
	private Connection conn; private ResultSet rs;
	private PreparedStatement pstmt;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String select="select * from remember_matjip";
	LinkedList<Matjip> select(){
		LinkedList<Matjip> list = new LinkedList<Matjip>();
		try {
			pstmt=conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Matjip matjip = new Matjip();
				matjip.setSeqno(rs.getInt(1));
				matjip.setName(rs.getString("name"));
				matjip.setAddr(rs.getString(3));
				matjip.setTel(rs.getString(4));
				matjip.setMobile(rs.getString("mobile"));
				list.add(matjip);
			}
		}catch(Exception e) {
			
		}
		return list;
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
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
}
public class SelectTest3 {

	public static void main(String[] args) {
		MatjipDB db = new MatjipDB();
		if(db.db_conn()) {
			LinkedList<Matjip> ll = db.select();
			Iterator it = ll.iterator();
			while(it.hasNext()) {
				Matjip matjip = (Matjip)it.next();
				System.out.println("맛집번호:"+matjip.getSeqno());
				System.out.println("맛집이름:"+matjip.getName());
				System.out.println("맛집주소:"+matjip.getAddr());
				System.out.println("맛집전화번호:"+matjip.getTel());
				System.out.println("이동전화:"+matjip.getMobile());
				db.db_disconn();//DB접속 해제
			}
		}else {
			System.out.println("DB접속 실패!");
		}
	}
}












