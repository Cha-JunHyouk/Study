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
<div align="center"><h2>도서 상세 정보</h2></div>
<%
	String seqno = request.getParameter("SEQNO");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String select="select * from books_info where seqno=?";
	PreparedStatement pstmt = conn.prepareStatement(select);
	int no = Integer.parseInt(seqno);//문자열 일련번호를 정수 일련번호로변경
	pstmt.setInt(1, no);//검색 쿼리의 첫번째 물음표에 정수 일련번호를 할당
	ResultSet rs = pstmt.executeQuery();//검색 쿼리 실행
	if(rs == null){
		out.println("검색된 결과가 존재하지 않습니다.");
	}else{
		while(rs.next()){//조회 결과로 이동
			int serial = rs.getInt(1);//첫번째 검색 항목(seqno)을 수신
			String title = rs.getString(2);//두번째 검색 항목(name)을 수신
			String writer = rs.getString("writer");//writer항목을 수신
			String company = rs.getString(4);//네번째 검색 항목(publisher)
			int price = rs.getInt("price");//price항목을 수신
%>
<form action="deleteOrModify.jsp" method="post">
	<input type="hidden" value="<%= serial %>" name="SEQNO"/>
	<input type="hidden" value="<%= title %>" name="TITLE"/>
	<input type="hidden" value="<%= writer %>" name="WRITER"/>
	<input type="hidden" value="<%= company %>" name="COMPANY"/>
	<input type="hidden" value="<%= price %>" name="PRICE"/>
	<table border="1">
		<tr><td width="100" height="20" bgcolor="cyan">일련번호</td>
			<td width="150" height="20" bgcolor="cyan">제 목</td>
			<td width="150" height="20" bgcolor="cyan">저 자</td>
			<td width="150" height="20" bgcolor="cyan">출판사</td>
			<td width="100" height="20" bgcolor="cyan">가 격</td>
			<td width="100" height="20" bgcolor="cyan">&nbsp;</td></tr>
		<tr><td width="100" height="20"><%= serial %></td>
			<td width="150" height="20"><%= title %></td>
			<td width="150" height="20"><%= writer %></td>
			<td width="150" height="20"><%= company %></td>
			<td width="100" height="20"><%= price %></td>
			<td width="100" height="20">
			<input type="submit" value="삭제하기" name="BTN"/>
			<input type="submit" value="수정하기" name="BTN"/>
			</td></tr>
	</table>
</form>
<%			
		}
	}
%>
</body>
</html>










