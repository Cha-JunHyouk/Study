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
	//도서정보를 DB에 저장(insert)
	//등록 결과를 보여주는 페이지로 바꾼다.
	//한글처리를 한다. get일 때 한글처리, post일 때 한글처리
	request.setCharacterEncoding("euc-kr");//post일 때 한글처리
	String seqno = request.getParameter("SEQNO");
	String title = request.getParameter("TITLE");
	String writer = request.getParameter("WRITER");
	String publisher = request.getParameter("COMPANY");
	String price = request.getParameter("PRICE");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = DriverManager.getConnection(url,"hr","hr");
	String insert="insert into books_info values(?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(insert);
	pstmt.setInt(1, Integer.parseInt(seqno));//일련번호를 정수로 변환
	pstmt.setString(2, title);//두번째 물음표에 title을 설정
	pstmt.setString(3, writer);
	pstmt.setString(4, publisher);
	pstmt.setInt(5, Integer.parseInt(price));
	int r = pstmt.executeUpdate();//DB에 insert
	String result = "";
	if(r > 0) result = "OK";//삽입작업의 결과가 양수이면 삽입성공
	else result = "NOK";//양수가 아니면 삽입실패
	pstmt.close(); conn.close();
	response.sendRedirect("bookEntryResult.jsp?R="+result);
%>
</body>
</html>














