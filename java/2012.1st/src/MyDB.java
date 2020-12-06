package senior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class MyDB {
	//DB����,����,CRUD
	InsertDataWindow idw;//������ ��ü ����
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
		boolean flag = false;//true:���漺��,false:�������
		try {
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, jaegu.getPassword());//��ȣ����
			pstmt.setString(2, jaegu.getGender());//��������
			pstmt.setString(3, jaegu.getAddress());//�ּҼ���
			pstmt.setString(4, jaegu.getName());//�̸�����
			pstmt.setString(5, jaegu.getPhonenumber());//����ó����
			pstmt.setString(6, jaegu.getStar());//���ڸ� ����
			pstmt.setString(7, jaegu.getId());//��������
			pstmt.executeUpdate();//DB���� �������
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	public Remeber_jaegu select(String id){
		Remeber_jaegu jaegu = new Remeber_jaegu();//DTO����
		try {
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);//?�� �Էµ� ������ ����
			rs = pstmt.executeQuery();//��ȸ����� ResultSet�� ����
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				jaegu.setId(rs.getString("id"));
				jaegu.setPassword(rs.getString("password"));
				jaegu.setGender(rs.getString(3));
				jaegu.setAddress(rs.getString(4));
				jaegu.setName(rs.getString("name"));
				jaegu.setPhonenumber(rs.getString(6));
				jaegu.setJoindate(rs.getString(7));//7��°�� ������
				jaegu.setStar(rs.getString(8));
			}else {//��ȸ����� �������� �ʴ� ���
				jaegu = null;
			}
		}catch(Exception e) {
			
		}
		return jaegu;//��ȸ����� ��� DTO�� �����Ѵ�.
	}
	public void delete(Remeber_jaegu r) {
		if( ! r.getId().equals("")) {
			delete = delete + "and id='"+r.getId()+"' ";
		}//������ �Էµ� ���
		if( ! r.getPassword().equals("")) {
			delete=delete+" and password='"+r.getPassword()+"' ";
		}//��ȣ�� �Էµ� ���
		if( ! r.getGender().equals("")) {
			delete=delete+" and gender='"+r.getGender()+"' ";
		}//������ �Էµ� ���
		if(! r.getAddress().equals("")) {
			delete=delete+" and address='"+r.getAddress()+"' ";
		}//�ּҰ� �Էµ� ���
		if(! r.getName().equals("")) {
			delete=delete+" and name='"+r.getName()+"' ";
		}//�̸��� �Էµ� ���
		if(! r.getPhonenumber().equals("")) {
			delete=delete+" and phonenumber='"+
					r.getPhonenumber()+"' ";
		}//��ȭ��ȣ�� �Էµ� ���
		if(! r.getStar().equals("")) {
			delete=delete+" and star='"+r.getStar()+"' ";
		}//���ڸ��� �Էµ� ���
		try {
			pstmt = conn.prepareStatement(delete);
			int cnt=pstmt.executeUpdate();//DB���� ����
			JOptionPane.showMessageDialog(idw, 
				"���������� ����Ǿ����ϴ�. "
				+ "������ �Ǽ��� "+cnt+"�Դϴ�.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(idw, 
				"�Էµ� ������ �������� �ʾҽ��ϴ�.");
		}
	}
	public MyDB() {
		
	}//������-�������� �����ε�
	public MyDB(InsertDataWindow idw) {
		this.idw = idw;//������ ������ ��ü�� �޴´�.
	}//������
	public void insert(Remeber_jaegu r) {
		try {
			pstmt = conn.prepareStatement(insert);
			//������ �ִ� ����ǥ�� �ش� �����͸� �Ҵ��Ѵ�.
			pstmt.setString(1, r.getId());//����
			pstmt.setString(2, r.getPassword());//��ȣ
			pstmt.setString(3, r.getGender());//����
			pstmt.setString(4, r.getAddress());//�ּ�
			pstmt.setString(5, r.getName());//�̸�
			pstmt.setString(6, r.getPhonenumber());//����ó
			pstmt.setString(7, getToday());
			pstmt.setString(8, r.getStar());//���ڸ�
			pstmt.executeUpdate();//DB�� ����
			JOptionPane.showMessageDialog(idw, 
				"���ԵǾ����ϴ�.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(idw, 
				"���Ե��� �ʾҽ��ϴ�. �����ڿ��� �����ϼ���.");
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














