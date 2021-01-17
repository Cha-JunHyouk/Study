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
	request.setCharacterEncoding("euc-kr");//한글처리
	String id = request.getParameter("ID");
	String name = request.getParameter("NAME");
	String addr = request.getParameter("ADDR");
	String phone = request.getParameter("TEL");
	String menu = request.getParameter("MENU");
	String intro = request.getParameter("INTRO");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String insert="insert into matjip_inform values(?,?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(insert);
	pstmt.setInt(1, Integer.parseInt(id));
	pstmt.setString(2, name); pstmt.setString(3, addr);
	pstmt.setString(4, phone); pstmt.setString(5, menu);
	pstmt.setString(6, intro);
	int result = pstmt.executeUpdate();//DB에 삽입(insert)
	pstmt.close(); conn.close();
	if(result > 0){
		response.sendRedirect("entryResult.jsp?R=OK");
	}else {
		response.sendRedirect("entryResult.jsp?R=NOK");
	}
%>
</body>
</html>















