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
		int flag = 0;//성공이면 > 0, 실패 0
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, item.getCode());//상품코드
			pstmt.setString(2, item.getName());//상품이름
			pstmt.setString(3, item.getIntro());//상품설명
			pstmt.setInt(4, item.getPrice());//가격(정수)
			pstmt.setString(5, item.getOrigin());//원산지
			pstmt.executeUpdate();//DB에 삽입
			flag = 1;
		}catch(Exception e) {
			e.printStackTrace();//예외의 상세정보 출력
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














