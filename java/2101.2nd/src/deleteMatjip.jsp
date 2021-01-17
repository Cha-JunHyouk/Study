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
	String id = request.getParameter("ID");//삭제할 맛집의 번호를 수신
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String delete="delete from matjip_inform where id=?";
	PreparedStatement pstmt = conn.prepareStatement(delete);
	pstmt.setInt(1, Integer.parseInt(id));
	int result = pstmt.executeUpdate();
	pstmt.close(); conn.close();
	if(result > 0){
		response.sendRedirect("deleteResult.jsp?R=OK");
	}else {
		response.sendRedirect("deleteResult.jsp?R=NOK");
	}
%>
</body>
</html>