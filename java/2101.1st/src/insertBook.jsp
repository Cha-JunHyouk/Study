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
	//���������� DB�� ����(insert)
	//��� ����� �����ִ� �������� �ٲ۴�.
	//�ѱ�ó���� �Ѵ�. get�� �� �ѱ�ó��, post�� �� �ѱ�ó��
	request.setCharacterEncoding("euc-kr");//post�� �� �ѱ�ó��
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
	pstmt.setInt(1, Integer.parseInt(seqno));//�Ϸù�ȣ�� ������ ��ȯ
	pstmt.setString(2, title);//�ι�° ����ǥ�� title�� ����
	pstmt.setString(3, writer);
	pstmt.setString(4, publisher);
	pstmt.setInt(5, Integer.parseInt(price));
	int r = pstmt.executeUpdate();//DB�� insert
	String result = "";
	if(r > 0) result = "OK";//�����۾��� ����� ����̸� ���Լ���
	else result = "NOK";//����� �ƴϸ� ���Խ���
	pstmt.close(); conn.close();
	response.sendRedirect("bookEntryResult.jsp?R="+result);
%>
</body>
</html>














