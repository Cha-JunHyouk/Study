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
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("ID");
	String title = request.getParameter("TITLE");
	String addr = request.getParameter("ADDR");
	String phone = request.getParameter("PHONE");
	String menu = request.getParameter("MENU");
	String intro = request.getParameter("INTRO");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String update="update matjip_inform set title=?, addr=?, phone=?,"+
					"menu=?, intro=? where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(update);
	pstmt.setString(1, title);
	pstmt.setString(2, addr);
	pstmt.setString(3, phone);
	pstmt.setString(4, menu);
	pstmt.setString(5, intro);
	pstmt.setInt(6, Integer.parseInt(id));
	int r = pstmt.executeUpdate();//DB에서 update 실행
	pstmt.close(); conn.close();
	if(r > 0){
		response.sendRedirect("updateResult.jsp?R=OK");
	}else{
		response.sendRedirect("updateResult.jsp?R=NOK");
	}
%>

</body>
</html>









