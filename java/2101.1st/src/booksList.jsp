<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>���� ���� �ý��� ver1.0</h2></div>
<br/>
<div align="right"><a href="bookEntry.jsp">���� ���</a></div><br/>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	if(conn == null){
		out.print("DB���ӿ� �����߽��ϴ�.");		
	}else{
		String select="select * from books_info order by seqno";
		PreparedStatement pstmt = conn.prepareStatement(select);
		ResultSet rs = pstmt.executeQuery();
%>
<table border="1">
	<tr><td width="50" height="20" bgcolor="orange"><b>�Ϸù�ȣ</b></td>
		<td width="150" height="20" bgcolor="orange"><b>�� ��</b></td>
		<td width="150" height="20" bgcolor="orange"><b>�� ��</b></td>
		<td width="200" height="20" bgcolor="orange"><b>���ǻ�</b></td>
		<td width="100" height="20" bgcolor="orange"><b>�� ��</b></td></tr>
<%
		if(rs != null){//�˻������ �����ϴ� ���
			while(rs.next()){
				int seqno = rs.getInt("seqno");//�Ϸù�ȣ
				String title = rs.getString("name");//����
				String writer = rs.getString(3);//����
				String publisher = rs.getString(4);//���ǻ�
				int price = rs.getInt(5);//����
%>
	<tr><td width="50" height="20"><%= seqno %></td>
		<td width="150" height="20">
			<a href="bookDetail.jsp?SEQNO=<%= seqno %>"><%= title %></a>
		</td>
		<td width="150" height="20"><%= writer %></td>
		<td width="200" height="20"><%= publisher %></td>
		<td width="100" height="20"><%= price %></td></tr>
<%
			}
			pstmt.close(); conn.close();
		}
	}
%>
</table>
</body>
</html>











