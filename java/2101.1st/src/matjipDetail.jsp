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
<h2 align="center">���� �� ����</h2>
<%
	String id = request.getParameter("ID");//������ȣ�� ����
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from matjip_inform where id=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	pstmt.setInt(1, Integer.parseInt(id));
	ResultSet rs = pstmt.executeQuery();
	if(rs == null){
		out.print(
			"<h3 align='center'>�˻��� ����� �������� �ʽ��ϴ�.</h3>");
	}else {
		rs.next();//�˻� ����� �̵�
		int seqno = rs.getInt(1);//���� ��ȣ
		String title = rs.getString(2);//���� �̸�
		String addr = rs.getString(3);//���� �ּ�
		String tel = rs.getString(4);//���� ����ó
		String menu = rs.getString(5);//���� �޴�
		String menuName = "";
		switch(menu){
		case "K":menuName="�ѽ�"; break;
		case "A":menuName="���"; break;
		case "C":menuName="�߽�"; break;
		case "J":menuName="�Ͻ�"; break;
		case "M":menuName="�н�"; break;
		case "E":menuName="��Ÿ"; break;
		}
		String intro = rs.getString(6);//���� �Ұ�
%>
<div align="center">
	<a href="deleteMatjip.jsp?ID=<%= seqno %>">�� ���� �����ϱ�</a>
	<a href="updateMatjip.jsp">�� ���� ���� �����ϱ�</a>
	<table style="border:1px solid blue;">
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			�� ȣ</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= seqno %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			�� ��</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= title %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			�� ��</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= addr %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			����ó</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= tel %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			�� ��</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= menuName %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:100px;">
			���� �Ұ�</td>
			<td style="border:1px solid red; width:200px; height:100px;">
			<%= intro %></td></tr>
	</table>
</div>
<%
		pstmt.close(); conn.close();
	}
%>
</body>
</html>











