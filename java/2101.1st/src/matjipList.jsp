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
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from matjip_inform";
	PreparedStatement pstmt = conn.prepareStatement(select);
	ResultSet rs = pstmt.executeQuery();
%>
<table style="border:1px solid blue;">
	<tr><td style="border:1px solid blue"><b>�� ȣ</b></td>
		<td style="border:1px solid blue"><b>�� ��</b></td>
		<td style="border:1px solid blue"><b>�� ��</b></td>
		<td style="border:1px solid blue"><b>����ó</b></td>
		<td style="border:1px solid blue"><b>�� ��</b></td></tr>
<%
	if(rs != null){
		while(rs.next()){
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String addr = rs.getString(3);
			String phone = rs.getString(4);
			String menu = rs.getString(5);
			String menuName = "";
			switch(menu){
			case "K":menuName = "�ѽ�";break;
			case "A":menuName = "���";break;
			case "C":menuName = "�߽�";break;
			case "J":menuName = "�Ͻ�";break;
			case "M":menuName = "�н�";break;
			case "E":menuName = "��Ÿ";break;
			}
%>
	<tr><td style="border:1px solid blue"><%= id %></td>
		<td style="border:1px solid blue">
		<a href="matjipDetail.jsp?ID=<%= id %>"><%= title %></a>
		</td>
		<td style="border:1px solid blue"><%= addr %></td>
		<td style="border:1px solid blue"><%= phone %></td>
		<td style="border:1px solid blue"><%= menuName %></td></tr>
<%
		}
		pstmt.close(); conn.close();
	}else {
%>
	<tr><td style="border:1px solid blue">�˻��� ������ �����ϴ�.</td></tr>
<%		
	}
%>
</table>
</body>
</html>















