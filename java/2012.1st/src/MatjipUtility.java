package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MatjipUtility {
	private Connection conn;
	private PreparedStatement pstmt;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url=	"jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String insert="insert into remember_matjip "
			+ "values(?,?,?,?,?)";
	private ResultSet rs;
	private String select="select * from remember_matjip "
			+ "where seqno=?";
	private String update="update remember_matjip set name=?,"+
			"addr=?, tel=?, mobile=? where seqno=?";
	public boolean change(Matjip matjip) {
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, matjip.getName());
			pstmt.setString(2, matjip.getAddr());
			pstmt.setString(3, matjip.getTel());
			pstmt.setString(4, matjip.getMobile());
			pstmt.setInt(5, matjip.getNumber());
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	public Matjip select(int number) {
		Matjip matjip = new Matjip();
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				matjip.setNumber(rs.getInt(1));
				matjip.setName(rs.getString(2));
				matjip.setAddr(rs.getString(3));
				matjip.setTel(rs.getString(4));
				matjip.setMobile(rs.getString(5));
			}else {
				matjip = null;
			}
		}catch(Exception e) {
			
		}
		return matjip;
	}
	
	public boolean insert1(Matjip matjip) {
		boolean flag = false;//삽입실패를 뜻함
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, matjip.getNumber());//맛집번호
			pstmt.setString(2, matjip.getName());//이름
			pstmt.setString(3, matjip.getAddr());//주소
			pstmt.setString(4, matjip.getTel());//연락처
			pstmt.setString(5, matjip.getMobile());//핸폰
			pstmt.executeUpdate();//DB에 삽입
			flag = true;//삽입성공을 뜻한.
		}catch(Exception e) {
		}
		return flag;//tru가 리턴되면 성공,false이면 실패
	}
	InsertMatjipWindow imw;//맛집 윈도우 객체
	public MatjipUtility(InsertMatjipWindow imw) {//생성자
		this.imw = imw;//이미 생성된 윈도우 인스턴스를 받음
	}
	public void insert2(Matjip matjip) {
		try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, matjip.getNumber());//맛집번호
			pstmt.setString(2, matjip.getName());//이름
			pstmt.setString(3, matjip.getAddr());//주소
			pstmt.setString(4, matjip.getTel());//연락처
			pstmt.setString(5, matjip.getMobile());//핸폰
			pstmt.executeUpdate();//DB에 삽입
			JOptionPane.showMessageDialog(imw, 
				"맛집 정보가 등록되었습니다.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(imw, 
				"맛집 정보가 등록되지 않았습니다.");
		}
	}
	public void db_disconn() {//DB접속 해제 메서드
		try {
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
	public boolean db_conn() {//DB접속 메서드
		boolean flag = false;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,
					"hr","hr");
			flag = true;
		}catch(Exception e) {
			
		}
		return flag;
	}
}














