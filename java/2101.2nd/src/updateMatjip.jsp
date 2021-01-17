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
<div align="center"><h2>맛집 정보 변경</h2>
<%
	String id = request.getParameter("ID");//맛집 번호를 수신
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from matjip_inform where id=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	pstmt.setInt(1, Integer.parseInt(id));
	ResultSet rs = pstmt.executeQuery();
	if(rs == null){
		out.print("<h2>검색 결과가 존재하지 않습니다.</h2>");		
	}else {
		rs.next();//조회 결과로 이동
		int seqno = rs.getInt(1);//조회결과의 첫번째 컬럼 값 수신
		String title = rs.getString(2);//조회결과의 두번째 컬럼 값 수신
		String addr = rs.getString("addr");//조회결과의 addr 컬럼 값 수신
		String phone = rs.getString("phone");
		String menu = rs.getString(5);
		String menuName = "";
		switch(menu){
		case "K":menuName="한식"; break;
		case "A":menuName="양식"; break;
		case "C":menuName="중식"; break;
		case "J":menuName="일식"; break;
		case "M":menuName="분식"; break;
		case "E":menuName="기타"; break;
		}
		String intro = rs.getString(6);
%>
<form action="updateMatjipInfo.jsp" method="post">
	<table border="1">
		<tr><td>맛집 번호</td>
			<td><input type="text" name="ID" value="<%= seqno %>" readonly/>
			</td></tr>
		<tr><td>이름</td>
			<td><input type="text" name="TITLE" value="<%= title %>"/>
			</td></tr>
		<tr><td>주소</td>
			<td><input type="text" name="ADDR" value="<%= addr %>"/>
			</td></tr>
		<tr><td>연락처</td>
			<td><input type="text" name="PHONE" value="<%= phone %>"/>
			</td></tr>
		<tr><td>메뉴</td>
			<td>한식
<%
	if(menu.equals("K")){
		out.print("<input type='radio' name='MENU' value='K' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='K' />");
	}
%>
				양식
<%
	if(menu.equals("A")){
		out.print("<input type='radio' name='MENU' value='A' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='A' />");
	}
%>
				중식
<%
	if(menu.equals("C")){
		out.print("<input type='radio' name='MENU' value='C' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='C' />");
	}
%>
				일식
<%
	if(menu.equals("J")){
		out.print("<input type='radio' name='MENU' value='J' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='J' />");
	}
%>				
				분식
<%
	if(menu.equals("M")){
		out.print("<input type='radio' name='MENU' value='M' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='M' />");
	}
%>				
				기타
<%
	if(menu.equals("E")){
		out.print("<input type='radio' name='MENU' value='E' checked/>");
	}else{
		out.print("<input type='radio' name='MENU' value='E' />");
	}
%>				
			</td></tr>
		<tr><td>소개글</td>
			<td><textarea rows="8" cols="40" name="INTRO"><%= intro %></textarea>
			</td></tr>
		<tr><td colspan="2"><input type="submit" value=" 정보수정 "/>
			<input type="reset" value=" 취소 "/>
		</tr>
	</table>
</form>
<%		
	}
	rs.close(); pstmt.close(); conn.close();
%>
</div>
</body>
</html>









