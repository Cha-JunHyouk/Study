package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

//remember_jaegu ���̺��� �����͸� ��� �˻��ؼ�,
//List�� �����ϰ�, List�� ����� �˻������ �ַܼ� ���
class Guest {//�������� DTO ��ü
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
			rs = pstmt.executeQuery();//DB���� ��ȸ(��ü��ȸ)
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
	//DB�� �����ϴ� �޼���
	boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"hr","hr");
			flag = true;
		}catch(Exception e) {}
		return flag;
	}
	//DB�� ���������ϴ� �޼���
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
				System.out.println("��ȣ:"+guest.getPassword());
				System.out.println("����:"+guest.getGender());
				System.out.println("�ּ�:"+guest.getAddress());
				System.out.println("�̸�:"+guest.getName());
				System.out.println("����ó:"+guest.getPhonenumber());
				System.out.println("������:"+guest.getJoindate());
				System.out.println("���ڸ�:"+guest.getStar());
			}//while�� ��
			util.db_dicconn();//DB�� ��������
		}//if�� ��
	}//main �޼����� ��
}//SelectTest Ŭ������ ��

















