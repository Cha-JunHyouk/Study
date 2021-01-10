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
	<tr><td style="border:1px solid blue"><b>번 호</b></td>
		<td style="border:1px solid blue"><b>이 름</b></td>
		<td style="border:1px solid blue"><b>주 소</b></td>
		<td style="border:1px solid blue"><b>연락처</b></td>
		<td style="border:1px solid blue"><b>메 뉴</b></td></tr>
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
			case "K":menuName = "한식";break;
			case "A":menuName = "양식";break;
			case "C":menuName = "중식";break;
			case "J":menuName = "일식";break;
			case "M":menuName = "분식";break;
			case "E":menuName = "기타";break;
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
	<tr><td style="border:1px solid blue">검색된 맛집이 없습니다.</td></tr>
<%		
	}
%>
</table>
</body>
</html>















