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
<div align="center"><h2>도서 정보 시스템 ver1.0</h2></div>
<br/>
<div align="right"><a href="bookEntry.jsp">도서 등록</a></div><br/>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	if(conn == null){
		out.print("DB접속에 실패했습니다.");		
	}else{
		String select="select * from books_info order by seqno";
		PreparedStatement pstmt = conn.prepareStatement(select);
		ResultSet rs = pstmt.executeQuery();
%>
<table border="1">
	<tr><td width="50" height="20" bgcolor="orange"><b>일련번호</b></td>
		<td width="150" height="20" bgcolor="orange"><b>제 목</b></td>
		<td width="150" height="20" bgcolor="orange"><b>저 자</b></td>
		<td width="200" height="20" bgcolor="orange"><b>출판사</b></td>
		<td width="100" height="20" bgcolor="orange"><b>가 격</b></td></tr>
<%
		if(rs != null){//검색결과가 존재하는 경우
			while(rs.next()){
				int seqno = rs.getInt("seqno");//일련번호
				String title = rs.getString("name");//제목
				String writer = rs.getString(3);//저자
				String publisher = rs.getString(4);//출판사
				int price = rs.getInt(5);//가격
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











