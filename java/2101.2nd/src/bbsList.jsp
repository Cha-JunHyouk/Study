<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>�Խñ� ���</h2></div>
<%
	String realPath = application.getRealPath("/WEB-INF/bbs");
	File dir = new File(realPath);//������ ��η� ����(����) ��ü�� ����
	String[] filename = dir.list();//�ش� ������ �ִ� �����̸��� ȹ��
	if(filename != null){
		for(String name : filename){
				out.print(name);
%>
			<a href="bbsRead.jsp?FILE=<%= name %>"><%= name %></a><br/>
<%			
		}
	}else{
		out.print("��ϵ� ���� �������� �ʽ��ϴ�.");
	}
%>
</body>
</html>











