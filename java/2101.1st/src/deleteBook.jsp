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
	String seqno = request.getParameter("SEQNO");//������ ������ �Ϸù�ȣ
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String delete="delete from books_info where seqno=?";
	PreparedStatement pstmt = conn.prepareStatement(delete);
	pstmt.setInt(1, Integer.parseInt(seqno));//�Ϸù�ȣ�� ������ ��ȯ
	pstmt.executeUpdate();//DB���� ���� ����
	pstmt.close(); conn.close();
	response.sendRedirect("deleteBookResult.jsp");
%>
</body>
</html>