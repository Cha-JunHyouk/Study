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
<h2 align="center">맛집 상세 정보</h2>
<%
	String id = request.getParameter("ID");//맛집번호를 수신
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from matjip_inform where id=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	pstmt.setInt(1, Integer.parseInt(id));
	ResultSet rs = pstmt.executeQuery();
	if(rs == null){
		out.print(
			"<h3 align='center'>검색된 결과가 존재하지 않습니다.</h3>");
	}else {
		rs.next();//검색 결과로 이동
		int seqno = rs.getInt(1);//맛집 번호
		String title = rs.getString(2);//맛집 이름
		String addr = rs.getString(3);//맛집 주소
		String tel = rs.getString(4);//맛집 연락처
		String menu = rs.getString(5);//맛집 메뉴
		String menuName = "";
		switch(menu){
		case "K":menuName="한식"; break;
		case "A":menuName="양식"; break;
		case "C":menuName="중식"; break;
		case "J":menuName="일식"; break;
		case "M":menuName="분식"; break;
		case "E":menuName="기타"; break;
		}
		String intro = rs.getString(6);//맛집 소개
%>
<div align="center">
	<a href="deleteMatjip.jsp?ID=<%= seqno %>">■ 맛집 삭제하기</a>
	<a href="updateMatjip.jsp">■ 맛집 정보 수정하기</a>
	<table style="border:1px solid blue;">
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			번 호</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= seqno %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			이 름</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= title %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			주 소</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= addr %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			연락처</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= tel %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:50px;">
			메 뉴</td>
			<td style="border:1px solid red; width:200px; height:50px;">
			<%= menuName %></td></tr>
		<tr><td style="border:1px solid blue; width:100px; height:100px;">
			맛집 소개</td>
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











