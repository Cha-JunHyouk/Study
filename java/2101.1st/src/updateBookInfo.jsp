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
	request.setCharacterEncoding("euc-kr");//한글처리(method=post)
	String seqno = request.getParameter("SEQNO");//파라미터 수신
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
	pstmt.setString(1, title);//첫번째 물음표에 제목을 설정
	pstmt.setString(2, writer);//두번째	물음표에 작성자를 설정
	pstmt.setString(3, company);//세번째 물음표에 출판사를 설정
	pstmt.setInt(4, Integer.parseInt(price));//네번째 물음표에 가격을 설정
	pstmt.setInt(5, Integer.parseInt(seqno));//다섯번째 물음표에 일련번호설정
	pstmt.executeUpdate();//DB에 update 실행
	pstmt.close(); conn.close();
	response.sendRedirect("updateBookResult.jsp");
%>
</body>
</html>






