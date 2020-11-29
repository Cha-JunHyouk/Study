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
		boolean flag = false;//���Խ��и� ����
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, matjip.getNumber());//������ȣ
			pstmt.setString(2, matjip.getName());//�̸�
			pstmt.setString(3, matjip.getAddr());//�ּ�
			pstmt.setString(4, matjip.getTel());//����ó
			pstmt.setString(5, matjip.getMobile());//����
			pstmt.executeUpdate();//DB�� ����
			flag = true;//���Լ����� ����.
		}catch(Exception e) {
		}
		return flag;//tru�� ���ϵǸ� ����,false�̸� ����
	}
	InsertMatjipWindow imw;//���� ������ ��ü
	public MatjipUtility(InsertMatjipWindow imw) {//������
		this.imw = imw;//�̹� ������ ������ �ν��Ͻ��� ����
	}
	public void insert2(Matjip matjip) {
		try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setInt(1, matjip.getNumber());//������ȣ
			pstmt.setString(2, matjip.getName());//�̸�
			pstmt.setString(3, matjip.getAddr());//�ּ�
			pstmt.setString(4, matjip.getTel());//����ó
			pstmt.setString(5, matjip.getMobile());//����
			pstmt.executeUpdate();//DB�� ����
			JOptionPane.showMessageDialog(imw, 
				"���� ������ ��ϵǾ����ϴ�.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(imw, 
				"���� ������ ��ϵ��� �ʾҽ��ϴ�.");
		}
	}
	public void db_disconn() {//DB���� ���� �޼���
		try {
			if(conn != null) conn.close();
		}catch(Exception e) {}
	}
	public boolean db_conn() {//DB���� �޼���
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














