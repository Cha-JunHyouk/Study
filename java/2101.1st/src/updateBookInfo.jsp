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
	request.setCharacterEncoding("euc-kr");//�ѱ�ó��(method=post)
	String seqno = request.getParameter("SEQNO");//�Ķ���� ����
	String title = request.getParameter("TITLE");
	String writer = request.getParameter("WRITER");
	String company = request.getParameter("COM");
	String price = request.getParameter("PRICE");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String update="update books_info set name=?, writer=?, publisher=?,"+
		"price=? where seqno = ?";
	PreparedStatement pstmt = conn.prepareStatement(update);
	pstmt.setString(1, title);//ù��° ����ǥ�� ������ ����
	pstmt.setString(2, writer);//�ι�°	����ǥ�� �ۼ��ڸ� ����
	pstmt.setString(3, company);//����° ����ǥ�� ���ǻ縦 ����
	pstmt.setInt(4, Integer.parseInt(price));//�׹�° ����ǥ�� ������ ����
	pstmt.setInt(5, Integer.parseInt(seqno));//�ټ���° ����ǥ�� �Ϸù�ȣ����
	pstmt.executeUpdate();//DB�� update ����
	pstmt.close(); conn.close();
	response.sendRedirect("updateBookResult.jsp");
%>
</body>
</html>






