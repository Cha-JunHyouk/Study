package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;


//DTO(��ǰ����)��ü
class Item {
	private String code;
	private String name;
	private String intro;
	private Integer price;
	private String origin;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
}
class ItemDB{
	private Connection conn; private ResultSet rs;
	private PreparedStatement pstmt;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String select="select * from kosea_hrd";
	ArrayList<Item> select(){
		ArrayList<Item> al = new ArrayList<Item>();//Item�� �����
		try {
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();//DB���� ��ȸ
			while(rs.next()) {
				Item item = new Item();
				item.setCode(rs.getString(1));
				item.setName(rs.getString("name"));
				item.setIntro(rs.getString(3));
				item.setPrice(rs.getInt(4));
				item.setOrigin(rs.getString(5));
				al.add(item);
			}
		}catch(Exception e) {
			
		}
		return al;
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
public class SelectTest2 {
//kosea_hrd ���̺� ����� ��ü ��ǰ ������ �˻� �� ���
	public static void main(String[] args) {
		ItemDB db = new ItemDB();
		if(db.db_conn()) {
			ArrayList<Item> list = db.select();
			Iterator it = list.iterator();
			int count = 1;
			while(it.hasNext()) {
				Item item = (Item)it.next();
				System.out.println("***"+count+"��° ��ǰ***");
				System.out.println("��ǰ�ڵ�:"+item.getCode());
				System.out.println("��ǰ�̸�:"+item.getName());
				System.out.println("��ǰ����:"+item.getIntro());
				System.out.println("��ǰ����:"+item.getPrice());
				System.out.println("������:"+item.getOrigin());
				count++;
			}//while�� ��
		}else {
			System.out.println("DB ���� ����! ");
		}//if�� ��
	}//main�� ��
}//SelectTest2�� ��

















