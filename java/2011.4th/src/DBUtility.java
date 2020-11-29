package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtility {
	private Connection conn; 
	private PreparedStatement pstmt;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String insert="insert into kosea_hrd "
					+ "values(?,?,?,?,?)";
	public int insert(Item item) {
		int flag = 0;//�����̸� > 0, ���� 0
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, item.getCode());//��ǰ�ڵ�
			pstmt.setString(2, item.getName());//��ǰ�̸�
			pstmt.setString(3, item.getIntro());//��ǰ����
			pstmt.setInt(4, item.getPrice());//����(����)
			pstmt.setString(5, item.getOrigin());//������
			pstmt.executeUpdate();//DB�� ����
			flag = 1;
		}catch(Exception e) {
			e.printStackTrace();//������ ������ ���
			flag = 0;
		}
		return flag;
	}
	public boolean db_conn() {
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(
					url,"hr","hr");
			flag = true;
		}catch(Exception e) {}
		return flag;
	}
	public void db_disconn() {
		try {
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
}














