<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>���� ��� ���</h2></div>
<div align="right"><a href="booksList.jsp">���� ��� ����</a></div>
<div align="center">
<%
	String result = request.getParameter("R");
	if(result.equals("OK")){
		out.print("���� ������ ��ϵǾ����ϴ�.!!!");
	}else{
		out.print("���� ���� ��� �� ������ �߻��߽��ϴ�.<br/>");
		out.print("�����ڿ��� ������ �ּ���.");
	}
%>
</div>
</body>
</html>